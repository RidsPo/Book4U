package book4u;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuarios {
    private static final String USER = "23_24_DAM2_RIDSPO";
    private static final String PWD = "Rids_Po_0";
    private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
    
    protected int id;
    protected byte[] foto;
    protected String nom_usuari;
    protected String cognom;
    protected String DNI;
    protected String domicili;
    protected String correu;
    protected String contra;
    protected String nom;

    static Connection connection = null;
    
    /*Contructor para el insert*/
    
    public Usuarios(byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
        super();
        
        this.foto = foto;
        this.nom_usuari = nom_usuari;
        this.cognom = cognom;
        this.DNI = DNI;
        this.domicili = domicili;
        this.correu = correu;
        this.contra = contra;
        this.nom = nom;

        connection = makeConnection();
    }
    
    /**/
    
    /*Contructor para iniciar sesion*/
    
    public Usuarios(String nom_usuari, String contra) {
        super();
        
        this.nom_usuari = nom_usuari;
        this.contra = contra;

        connection = makeConnection();
    }
    
    /**/
    
    /*Contructor para hacer el update de los jTextField y jPasswordFields*/   
    public Usuarios(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
        super();
        
        this.id = id;
        this.foto = foto;
        this.nom_usuari = nom_usuari;
        this.cognom = cognom;
        this.DNI = DNI;
        this.domicili = domicili;
        this.correu = correu;
        this.contra = contra;
        this.nom = nom;

        connection = makeConnection();
    }
    
    /**/
    
    
    public Usuarios(int id, byte[] foto) {
        super();
        
        this.id = id;
        this.foto = foto;

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
    
    public String getNom_Usuari() {
        return nom_usuari;
    }

    public void setNom_Usuari(String nom_usuari) {
        this.nom_usuari = nom_usuari;
    }
    
    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    public String getDomicili() {
        return domicili;
    }

    public void setDomicili(String domicili) {
        this.domicili = domicili;
    }
    
    public String getCorreu() {
        return nom_usuari;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }
    
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "El cliente se llama " + this.nom + " y su apellido es " + this.cognom;
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
            String sql = "INSERT INTO USUARIO (nom_usuari, cognom, DNI, domicili, correu, contra, nom, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setString(1, nom_usuari);
            preparedStatement.setString(2, cognom);
            preparedStatement.setString(3, DNI);
            preparedStatement.setString(4, domicili);
            preparedStatement.setString(5, correu);
            preparedStatement.setString(6, contra);
            preparedStatement.setString(7, nom);
            preparedStatement.setBytes(8, foto); // Suponiendo que "foto" es la variable de bytes de la imagen

            // Ejecutar la consulta preparada
            preparedStatement.executeUpdate();

            // Cerrar la consulta preparada
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Error during insert: " + e);
        }
    }
    
    
    public void selectWithStatement() {
    
        String sql = "SELECT * FROM USUARIO WHERE nom_usuari = ? AND contra = ?";

    try {
        // Crear una consulta preparada con placeholders (?)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        preparedStatement.setString(1, nom_usuari);
        preparedStatement.setString(2, contra);

        // Ejecutar la consulta preparada
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            foto = rs.getBytes("foto"); // Cambié getString a getBytes para el campo de la foto
            nom_usuari = rs.getString("nom_usuari");
            cognom = rs.getString("cognom");
            DNI = rs.getString("DNI");
            domicili = rs.getString("domicili");
            correu = rs.getString("correu");
            contra = rs.getString("contra");
            nom = rs.getString("nom");

            System.out.println("Mensaje de la clase Usuarios: " + id + "," + nom_usuari + "," + cognom + "," + DNI + "," + domicili + "," + correu + "," + contra + "," + nom);
        }

        // Cerrar la consulta preparada y el resultado
        preparedStatement.close();
        rs.close();

    } catch (SQLException e) {
        System.out.println("Error during select: " + e);
    }
  }
    
    
public void updateWithStatement() {
    try {
        // Crear una consulta preparada con placeholders (?)
        String sql = "UPDATE USUARIO SET nom_usuari = ?, cognom = ?, DNI = ?, domicili = ?, correu = ?, contra = ?, nom = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        preparedStatement.setString(1, nom_usuari);
        preparedStatement.setString(2, cognom);
        preparedStatement.setString(3, DNI);
        preparedStatement.setString(4, domicili);
        preparedStatement.setString(5, correu);
        preparedStatement.setString(6, contra);
        preparedStatement.setString(7, nom);
        preparedStatement.setInt(8, id); // Se asume que id es el identificador único del usuario

        // Ejecutar la consulta preparada
        preparedStatement.executeUpdate();

        // Cerrar la consulta preparada
        preparedStatement.close();

    } catch (SQLException e) {
        System.out.println("Error during update: " + e);
    }
}

public void updateImageWithStatement() {
    try {
        // Crear una consulta preparada con placeholders (?)
        String sql = "UPDATE USUARIO SET foto = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        preparedStatement.setBytes(1, foto);
        preparedStatement.setInt(2, id);

        // Ejecutar la consulta preparada
        preparedStatement.executeUpdate();

        // Cerrar la consulta preparada
        preparedStatement.close();

    } catch (SQLException e) {
        System.out.println("Error during update: " + e);
    }
}

}
