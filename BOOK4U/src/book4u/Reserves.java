package book4u;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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
   
    
    static Connection connection = null;
    
    public Reserves() {
        super();

        
        connection = makeConnection();
    }
    
    public Reserves( int id, byte[] foto, String nombre, String direccion, int precio, int ocupado) {
        super();
        
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.precio = precio;
        this.ocupado = ocupado;
        
        connection = makeConnection();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public int getOcupado() {
        return precio;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }
    
    @Override
    public String toString() {
        return "la residencia se llama " + this.nombre + " y su direccion es " + this.direccion;
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
    
    public void insertWithStatement() {

        try {
            // Crear una consulta preparada con placeholders (?)
            String sql = "INSERT INTO RESIDENCIAS (nombre, direccion, precio, ocupado, foto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setInt(3, precio);
            preparedStatement.setInt(4, ocupado);
            preparedStatement.setBytes(5, foto);

            // Ejecutar la consulta preparada
            preparedStatement.executeUpdate();

            // Cerrar la consulta preparada
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Error during insert: " + e);
        }
    }
    
    public void selectWithStatement() {
    
        String sql = "SELECT * FROM RESERVES";

    try {
        // Crear una consulta preparada con placeholders (?)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        // Ejecutar la consulta preparada
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            id_residencia = rs.getInt("id_residensia"); // Cambié getString a getBytes para el campo de la foto
            id_usuari= rs.getInt("id_usuari");
            precio = rs.getInt("precio");
            data_inici = rs.getDate("fecha_inicio");
            data_fi = rs.getDate("fecha_final");
            System.out.println("Mensaje de la clase Reserves: " + id + "," + id_residencia + "," + id_usuari + "," + precio + "," + data_inici+ "," + data_fi);
        }

        // Cerrar la consulta preparada y el resultado
        preparedStatement.close();
        rs.close();

    } catch (SQLException e) {
        System.out.println("Error during select: " + e);
    }
  }
    
}
