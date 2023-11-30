/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book4u;

/**
 *
 * @author xavic
 */
public class GuardarInfoUsuarios {
    protected String foto;
    protected String nom_usuari;
    protected String nom;
    protected String cognom;
    protected String DNI;
    protected String domicili;
    protected String correu;
    protected String contra;
    
    
    public GuardarInfoUsuarios(){
        
    }
    
    public GuardarInfoUsuarios(String foto, String nom_usuari, String nom, String cognom, String DNI, String domicili, String correu, String contra) {
        super();
        this.foto = foto;
        this.nom_usuari = nom_usuari;
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
        this.domicili = domicili;
        this.correu = correu;
        this.contra = contra;
    }
    
}
