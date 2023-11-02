/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book4u;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author xavic
 */
public class Usuarios {
    private static final String USER = "23_24_DAM2_RIDSPO";
    private static final String PWD = "Rids_Po_0";
    private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
    
    protected String foto;
    protected String nom_usuari;
    protected String cognom;
    protected String DNI;
    protected String domicili;
    protected String correu;
    protected String contra;
    protected String nom;

    static Connection connection = null;

    public Usuarios() {

    }
    
    public Usuarios(String foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
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

        Usuarios nombreusuario = new Usuarios(foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom);

        System.out.println(nombreusuario);
                 
        String sql = "INSERT INTO USUARIO (foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom) VALUES ('" + nombreusuario.foto + "', '" + nombreusuario.nom_usuari + "', '" + nombreusuario.cognom + "', '" + nombreusuario.DNI + "', '" + nombreusuario.domicili + "', '" + nombreusuario.correu + "', '" + nombreusuario.contra + "', '" + nombreusuario.nom +"')";

        try {
            Statement statement = (Statement) connection.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException e) {
            System.out.println("The Insert had problems!! " + e);

        }
    }
    
    
    /*public String selectWithStatement() {

        Usuarios1 infousuario = new Usuarios1();

        String nombre = null;
        String sql = "SELECT * FROM USUARIO WHERE nom_usuari = '" + getNom_usuari() + "' AND contra = '" + getContraseña() + "'";

        System.out.println(sql);

        try {
            Statement statement = (Statement) connection.createStatement();

            System.out.println(getNom_Usuari());

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                nombreusuario.foto = rs.getString("foto");
                nombreusuario.nom_usuari = rs.getString("nom_usuari");
                infousuario.cognom = rs.getString("cognom");
                infousuario.DNI = rs.getString("DNI");
                infousuario.domicili = rs.getString("domicili");
                nombreusuario.correu = rs.getString("correu");
                nombreusuario.contra = rs.getString("contra");
                infousuario.nom = rs.getString("nom");

                System.out.println(nombreusuario.foto + "," + nombreusuario.nom_usuari + "," + infousuario.cognom + "," + infousuario.DNI + "," + infousuario.domicili + "," + nombreusuario.correu + "," + nombreusuario.contra + "," + infousuario.nom);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("The select had problems!! " + e);

        }
        return nombre;
    }*/
            /*JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);*/
        
       /* if (jNom.getText().isEmpty() && jCognoms.getText().isEmpty() && jDNI.getText().isEmpty() && jDomicili.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jBotonSiguiente, "Todos los campos estan vacios!");
        } else if (jNom.getText().isEmpty() || jCognoms.getText().isEmpty() || jDNI.getText().isEmpty() || jDomicili.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jBotonSiguiente, "Rellena los campos vacios!");
        } else {
            String nom = jNom.getText();
            String cognom = jCognoms.getText();
            String DNI = jDNI.getText();
            String domicili = jDomicili.getText();

            Usuarios1 informacion = new Usuarios1(nom, cognom, DNI, domicili);

            informacion.makeConnection();
            informacion.insertWithStatement();

            marco.remove(this);
            marco.add(new PaginaRegistro2Panel());
            marco.setVisible(true);*/
}
