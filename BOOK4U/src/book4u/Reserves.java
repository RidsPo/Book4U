package book4u;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserves {
    private static final String USER = "23_24_DAM2_RIDSPO";
    private static final String PWD = "Rids_Po_0";
    private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
    
    protected int id;
    protected int id_residencia;
    protected int id_usuari;
    protected int precio;
    protected Date data_inici;
    protected Date data_fi;
   
    protected int ocupado;
    
    protected int resta;
    
    static Connection connection = null;
    
    public Reserves(int id_usuari) {
        super();

        this.id_usuari = id_usuari;
        
        connection = makeConnection();
    }
    
    public Reserves(int id_residencia, int id_usuari, int precio, Date data_inici, Date data_fi, int resta) {
        super();
        
        this.id_residencia = id_residencia;
        this.id_usuari = id_usuari;
        this.precio = precio;
        this.data_inici = data_inici;
        this.data_fi = data_fi;
        this.resta = resta;
        
        connection = makeConnection();
    }
    
    public Reserves(int id_residencia, int ocupado) {
        super();
        
        this.id_residencia = id_residencia;
        this.ocupado = ocupado;
        
        connection = makeConnection();
    }
    
    public Reserves(int id_reserva, Date fecha_inici, Date fecha_fi ) {
        super();
        
        this.id = id_reserva;
        this.data_inici = fecha_inici;
        this.data_fi = fecha_fi;
        connection = makeConnection();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public int getIdResidencia() {
        return id_residencia;
    }

    public void setIdResidencia(int id_residencia) {
        this.id_residencia = id_residencia;
    }
    
    public int getIdUsuari() {
        return id_usuari;
    }

    public void setIdUsuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public Date getDataInici() {
        return data_inici;
    }

    public void setDataInici(Date data_inici) {
        this.data_inici = data_inici;
    }
    
    public Date getDataFi() {
        return data_fi;
    }

    public void setDataFi(Date data_fi) {
        this.data_fi = data_fi;
    }
    
    public int getOcupado(){
        return ocupado;
    }
    
    public void setOcupado(int ocupado){
        this.ocupado = ocupado;
    }
    
    public int getResta(){
        return resta;
    }
    
    public void setResta(int resta){
        this.resta = resta;
    }
    
    /*@Override
    public String toString() {
        return "la residencia se llama " + this.nombre + " y su direccion es " + this.direccion;
    }*/
    
    public static Connection makeConnection() {
        
        System.out.println("Connecting database...");

        Connection con = null;
        // intentamos la conexion a la base de datos
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PWD);

            System.out.println("Database connected!");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database! ", e);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // devolvemos el valor de la conexion
        return con;
    }
    
    public static void closeConnection(Connection con) {
        // cierra la conexi�n
        try {
            con.close();

        } catch (SQLException e) {
            System.out.println("Error closing connection!!" + e);

        }
    }
    
    public void insertWithStatement() {

        try {
            // Crear una consulta preparada con placeholders (?)
            String sql = "INSERT INTO RESERVES (id_residensia, id_usuari, precio, fecha_inicio, fecha_final) VALUES (?, ?, ?, ?, ?)";
            String sql2 = "UPDATE RESIDENCIAS SET ocupado = ? WHERE id = ?";
            String sql3 = "UPDATE CREDITOS SET monedavirtual = ? WHERE id_usuario = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);

            // Establecer los valores de los parámetros
            java.sql.Date sqlDataInici = new java.sql.Date(data_inici.getTime());
            java.sql.Date sqlDataFi = new java.sql.Date(data_fi.getTime());

            preparedStatement.setInt(1, id_residencia);
            preparedStatement.setInt(2, id_usuari);
            preparedStatement.setInt(3, precio);
            preparedStatement.setDate(4, sqlDataInici); // Establecer la fecha de inicio como java.sql.Date
            preparedStatement.setDate(5, sqlDataFi);

            preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(2, id_residencia);
            
            preparedStatement3.setInt(1, resta);
            preparedStatement3.setInt(2, id_usuari);

            // Ejecutar la consulta preparada
            preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();

            // Cerrar la consulta preparada
            preparedStatement.close();
            preparedStatement2.close();
            preparedStatement3.close();

        } catch (SQLException e) {
            System.out.println("Error during insert: " + e);
        }
    }
    
    public List<Reserves> selectWithStatement() {
        List<Reserves> reservesList = new ArrayList<>();
         
        String sql = "SELECT * FROM RESERVES WHERE id_usuari = ?";

    try {
        // Crear una consulta preparada con placeholders (?)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, id_usuari);
        
        // Ejecutar la consulta preparada
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Reserves reserva = new Reserves(id_usuari);
            
            reserva.setId(rs.getInt("id"));
            reserva.setIdResidencia(rs.getInt("id_residensia")); // Cambié getString a getBytes para el campo de la foto
            reserva.setIdUsuari(rs.getInt("id_usuari"));
            reserva.setPrecio(rs.getInt("precio"));
            reserva.setDataInici(rs.getDate("fecha_inicio"));
            reserva.setDataFi(rs.getDate("fecha_final"));
           
            reservesList.add(reserva);
            
            System.out.println("Mensaje de la clase Reserves: " + reserva.getId() + "," + reserva.getIdResidencia() + "," + reserva.getIdUsuari() + "," + reserva.getPrecio() + "," + reserva.getDataInici() + "," + reserva.getDataFi());
        }

        // Cerrar la consulta preparada y el resultado
        preparedStatement.close();
        rs.close();

    } catch (SQLException e) {
        System.out.println("Error during select: " + e);
    }
    
    return reservesList;
  }
    
    
public void updateWithStatement() {
    try {
        // Crear una consulta preparada con placeholders (?)
        String sql = "UPDATE RESERVES SET fecha_inicio = ?, fecha_final = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        preparedStatement.setDate(1, (java.sql.Date) data_inici);
        preparedStatement.setDate(2, (java.sql.Date) data_fi);
        preparedStatement.setInt(3, id);
        

        // Ejecutar la consulta preparada
        preparedStatement.executeUpdate();

        // Cerrar la consulta preparada
        preparedStatement.close();

    } catch (SQLException e) {
        System.out.println("Error during update: " + e);
    }
}
    
}
