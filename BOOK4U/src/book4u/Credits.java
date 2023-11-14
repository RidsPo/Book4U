package book4u;

import static book4u.Usuarios.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Credits {
    private static final String USER = "23_24_DAM2_RIDSPO";
    private static final String PWD = "Rids_Po_0";
    private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";

    protected int id_credit;
    protected int id_usuari;
    protected int credits;
    protected int diners;
    
    static Connection connection = null;
       
    public Credits(int id_usuari){
        super();
        
        this.id_usuari = id_usuari;
        
        connection = makeConnection();
    }
    
    public Credits(int id_usuari, int credits, int diners){
        super();
        
        this.id_usuari = id_usuari;
        this.credits = credits;
        this.diners = diners;
        
        connection = makeConnection();
    }
    
    public int getIdCredit(){
       return id_credit;
    }
    
    public int getIdusuari(){
       return id_usuari;
    }
    
    public int getCredits(){
       return credits;
    }
    
    public int getDiners(){
       return diners;
    }
    
    public void setIdCredit(int id_credit) {
        this.id_credit = id_credit;
    } 
    
    public void setIdUsuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void setDiners(int diners) {
        this.diners = diners;
    }
    
    @Override
    public String toString() {
        return "La id del credit es " + this.id_credit + " la id del usuari es " + this.id_usuari + " a comprat " + this.credits + " per " +this.diners + " euros.";
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
    
    
public void insertOrUpdateWithStatement() {
    String selectSql = "SELECT * FROM CREDITOS WHERE id_usuario = ?";
    String insertSql = "INSERT INTO CREDITOS (monedavirtual, dinero, id_usuario) VALUES (?, ?, ?)";
    String updateSql = "UPDATE CREDITOS SET monedavirtual = ?, dinero = ? WHERE id_usuario = ?";

    try {
        // Verificar si existe una fila para el id_usuario
        PreparedStatement selectStatement = connection.prepareStatement(selectSql);
        selectStatement.setInt(1, id_usuari);
        ResultSet resultSet = selectStatement.executeQuery();

        if (resultSet.next()) {
            // Si existe, realizar una actualización (UPDATE)
            PreparedStatement updateStatement = connection.prepareStatement(updateSql);
            updateStatement.setInt(1, credits);
            updateStatement.setInt(2, diners);
            updateStatement.setInt(3, id_usuari);
            updateStatement.executeUpdate();
            updateStatement.close();
        } else {
            // Si no existe, realizar una inserción (INSERT)
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setInt(1, credits);
            insertStatement.setInt(2, diners);
            insertStatement.setInt(3, id_usuari);
            insertStatement.executeUpdate();
            insertStatement.close();
        }

        // Cerrar recursos
        resultSet.close();
        selectStatement.close();

    } catch (SQLException e) {
        System.out.println("Error during insert or update: " + e);
    }
}

    
    public void selectWithStatement() {
    String sql = "SELECT * FROM CREDITOS WHERE id_usuario = ?";

    try {
        // Crear una consulta preparada con placeholders (?)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        preparedStatement.setInt(1, id_usuari);

        // Ejecutar la consulta preparada
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            id_credit = rs.getInt("id");
            credits = rs.getInt("monedavirtual");
            diners = rs.getInt("dinero");
            id_usuari = rs.getInt("id_usuario");

            System.out.println("Mensaje de la clase Credits: " + id_credit + "," + credits + "," + diners + "," + id_usuari);
        }

        // Cerrar la consulta preparada y el resultado
        preparedStatement.close();
        rs.close();

    } catch (SQLException e) {
        System.out.println("Error during select: " + e);
    }
  }
}
