package book4u;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Historial {
   private static final String USER = "23_24_DAM2_RIDSPO";
   private static final String PWD = "Rids_Po_0";
   private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
    
   protected int id;
   protected int id_reserva;
   protected int id_residencia;
   protected int id_usuari;
   protected int precio;
   protected Date data_inici;
   protected Date data_fi;
    
   protected byte[] foto;
   protected String nombre;
   protected String direccion;
    
   static Connection connection = null;
   
    public Historial(int id_usuari) {
       super();

       this.id_usuari = id_usuari;
        
       connection = makeConnection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 
    
    public int getIdReserva(){
        return id_reserva;
    }
    
    public void setIdReserva(int idReserva){
        this.id_reserva = idReserva;
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
    
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }  
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }  

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

    public List<Historial> selectWithStatement() {
        List<Historial> historialList = new ArrayList<>();
         
        String sql = "SELECT * FROM HISTORIAL WHERE id_usuari = ?";

    try {
        // Crear una consulta preparada con placeholders (?)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id_usuari);
          
        // Ejecutar la consulta preparada
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Historial historial = new Historial(id_usuari);
            
            historial.setId(rs.getInt("id"));
            historial.setIdReserva(rs.getInt("id_reserva"));
            historial.setIdResidencia(rs.getInt("id_residencia")); // Cambié getString a getBytes para el campo de la foto
            historial.setIdUsuari(rs.getInt("id_usuari"));
            historial.setPrecio(rs.getInt("precio"));
            historial.setDataInici(rs.getDate("fecha_inicio"));
            historial.setDataFi(rs.getDate("fecha_final"));
            historial.setFoto(rs.getBytes("foto"));
            historial.setNombre(rs.getString("nombre"));
            historial.setDireccion(rs.getString("direccion"));

            historialList.add(historial);
            
            System.out.println("Mensaje de la clase Reserves: " + historial.getId() + "," + historial.getIdResidencia() + "," + historial.getIdUsuari() + "," + historial.getPrecio() + "," + historial.getDataInici() + "," + historial.getDataFi());
        }

        // Cerrar la consulta preparada y el resultado
        preparedStatement.close();
        rs.close();

    } catch (SQLException e) {
        System.out.println("Error during select: " + e);
    }
    
    return historialList;
  }
    
}
