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
    
    protected byte[] foto;
    protected String nombre;
    protected String direccion;
    
    static Connection connection = null;
    
    public Reserves(int id_usuari) {
        super();

        this.id_usuari = id_usuari;
        
        connection = makeConnection();
    }
    
    public Reserves(String id_residencia) {
        super();

        this.id_residencia = Integer.getInteger(id_residencia);
        
        connection = makeConnection();
    }
    
    public Reserves(int id_residencia, int id_usuari, int precio, Date data_inici, Date data_fi, int resta, byte[] foto, String nombre, String direccion) {
        super();
        
        this.id_residencia = id_residencia;
        this.id_usuari = id_usuari;
        this.precio = precio;
        this.data_inici = data_inici;
        this.data_fi = data_fi;
        this.resta = resta;
        this.foto = foto;
        this.nombre = nombre;
        this.direccion = direccion;
        
        connection = makeConnection();
    }
    
    public Reserves(int id_residencia, int ocupado) {
        super();
        
        this.id_residencia = id_residencia;
        this.ocupado = ocupado;
        
        connection = makeConnection();
    }
    
    public Reserves(int id, Date fechaInicio, Date fechaFinal) {
        super();
        
        this.id = id;
        this.data_inici = fechaInicio;
        this.data_fi = fechaFinal;
        
        connection = makeConnection();
    }
    
    public Reserves(int id, int id_usuari, int id_residencia) {
        super();
        
        this.id = id;
        this.id_usuari = id_usuari;
        this.id_residencia = id_residencia;
        
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
            String sql = "INSERT INTO RESERVES (id_residensia, id_usuari, precio, fecha_inicio, fecha_final, foto, nombre, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
            preparedStatement.setBytes(6, foto);
            preparedStatement.setString(7, nombre);
            preparedStatement.setString(8, direccion);

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
            reserva.setFoto(rs.getBytes("foto"));
            reserva.setNombre(rs.getString("nombre"));
            reserva.setDireccion(rs.getString("direccion"));

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
        String sql = "UPDATE RESERVES SET FECHA_INICIO = ?, FECHA_FINAL = ? WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        java.sql.Date sqlDataInici = new java.sql.Date(data_inici.getTime());
        java.sql.Date sqlDataFi = new java.sql.Date(data_fi.getTime());

        // Establecer los valores de los parámetros
        preparedStatement.setDate(1, sqlDataInici);
        preparedStatement.setDate(2, sqlDataFi);
        preparedStatement.setInt(3, id);

        // Ejecutar la consulta preparada
        preparedStatement.executeUpdate();

        // Cerrar la consulta preparada
        preparedStatement.close();

    } catch (SQLException e) {
        System.out.println("Error during update: " + e);
    }
}
    
public void deleteAndUpdateTables() {
    Connection connection = null;
    PreparedStatement preparedStatement1 = null;
    PreparedStatement preparedStatement2 = null;
    PreparedStatement preparedStatement3 = null;
    PreparedStatement preparedStatement4 = null;
    ResultSet resultSet = null;

    try {
        connection = makeConnection(); // Obtener conexión a la base de datos

        // Iniciar una transacción
        connection.setAutoCommit(false);

        String sql1 = "SELECT precio FROM reserves WHERE id = ? AND id_usuari = ?";
        preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement1.setInt(1, id);
        preparedStatement1.setInt(2, id_usuari);
        resultSet = preparedStatement1.executeQuery();

        int precio = 0;

        if (resultSet.next()) {
            precio = resultSet.getInt("precio");
        }

        String sql2 = "DELETE FROM reserves WHERE id = ? AND id_usuari = ?";
        preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setInt(1, id);
        preparedStatement2.setInt(2, id_usuari);
        preparedStatement2.executeUpdate();

        String sql3 = "UPDATE creditos SET monedavirtual = monedavirtual + ? WHERE id_usuario = ?";
        preparedStatement3 = connection.prepareStatement(sql3);
        preparedStatement3.setInt(1, precio);
        preparedStatement3.setInt(2, id_usuari);
        preparedStatement3.executeUpdate();

        String sql4 = "UPDATE residencias SET ocupado = ? WHERE id = ?";
        preparedStatement4 = connection.prepareStatement(sql4);
        preparedStatement4.setInt(1, 0);
        preparedStatement4.setInt(2, id_residencia);
        preparedStatement4.executeUpdate();

        // Confirmar la transacción si todo fue exitoso
        connection.commit();

    } catch (SQLException e) {
        // Si algo falla, hacer rollback para revertir los cambios
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex);
            }
        }
        System.out.println("Error durante la operación: " + e);

    } finally {
        // Cerrar los recursos
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement1 != null) preparedStatement1.close();
            if (preparedStatement2 != null) preparedStatement2.close();
            if (preparedStatement3 != null) preparedStatement3.close();
            if (preparedStatement4 != null) preparedStatement4.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e);
        }
    }
}
  
    
public List<Reserves> getReservasCaducadas() {
        List<Reserves> reservesCaducadas = new ArrayList<>();
         
    try {
        
        Date fechaActual = new Date();
        
        String sql = "SELECT * FROM RESERVES WHERE fecha_final < ?";

        // Crear una consulta preparada con placeholders (?)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setDate(1, new java.sql.Date(fechaActual.getTime()));
          
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
            reserva.setFoto(rs.getBytes("foto"));
            reserva.setNombre(rs.getString("nombre"));
            reserva.setDireccion(rs.getString("direccion"));

            reservesCaducadas.add(reserva);
            
            System.out.println("Reservas Caducadas: " + reserva.getId() + "," + reserva.getIdResidencia() + "," + reserva.getIdUsuari() + "," + reserva.getPrecio() + "," + reserva.getDataInici() + "," + reserva.getDataFi() + "," + reserva.getFoto()+ "," + reserva.getNombre()+ "," + reserva.getDireccion());
        }

        // Cerrar la consulta preparada y el resultado
        preparedStatement.close();
        rs.close();

    } catch (SQLException e) {
        System.out.println("Error during select: " + e);
    }
    
    return reservesCaducadas;
  }

public void insertHistorialWithStatement() {
    try {
        String insertHistorialQuery = "INSERT INTO HISTORIAL (id_reserva, id_residencia, id_usuari, precio, fecha_inicio, fecha_final, foto, nombre, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String deleteReservaQuery = "DELETE FROM RESERVES WHERE id = ?"; // Asumiendo que el identificador de la reserva es id_reserva
        String updateresidenciasQuary = "UPDATE residencias SET ocupado = 0 WHERE id = ?";
        
        PreparedStatement insertStatement = connection.prepareStatement(insertHistorialQuery);
        PreparedStatement deleteStatement = connection.prepareStatement(deleteReservaQuery);
        PreparedStatement updateStatement = connection.prepareStatement(updateresidenciasQuary);

        // Establecer los valores de los parámetros para la inserción
        java.sql.Date sqlDataInici = new java.sql.Date(data_inici.getTime());
        java.sql.Date sqlDataFi = new java.sql.Date(data_fi.getTime());

        insertStatement.setInt(1, id);
        insertStatement.setInt(2, id_residencia);
        insertStatement.setInt(3, id_usuari);
        insertStatement.setInt(4, precio);
        insertStatement.setDate(5, sqlDataInici); // Establecer la fecha de inicio como java.sql.Date
        insertStatement.setDate(6, sqlDataFi);
        insertStatement.setBytes(7, foto);
        insertStatement.setString(8, nombre);
        insertStatement.setString(9, direccion);

        // Ejecutar la consulta preparada para insertar en la tabla 'historial'
        insertStatement.executeUpdate();
        insertStatement.close();

        // Establecer el valor del parámetro para la eliminación
        deleteStatement.setInt(1, id);

        // Ejecutar la consulta preparada para eliminar de la tabla 'reservas'
        int rowsAffected = deleteStatement.executeUpdate();
        deleteStatement.close();
        
        updateStatement.setInt(1, id_residencia);
        updateStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Reserva eliminada de la tabla 'reservas'.");
        } else {
            System.out.println("No se pudo eliminar la reserva de la tabla 'reservas'.");
        }

    } catch (SQLException e) {
        System.out.println("Error during insert or delete: " + e);
    }
}

    
}
