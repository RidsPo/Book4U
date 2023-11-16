package book4u;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.text.JTextComponent;

public class PaginaPerfilUsuario extends javax.swing.JPanel {

    protected int id;
    protected byte[] foto;
    protected String nom_usuari;
    protected String cognom;
    protected String DNI;
    protected String domicili;
    protected String correu;
    protected String contra;
    protected String nom;  
    
    protected int creditos;
    protected int dinero;
    
    private boolean passwordVisible1 = false;
    
    public PaginaPerfilUsuario(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
                
       System.out.println("Mensaje de la pagina de perfil:" + id + foto + nom_usuari + cognom + DNI + domicili + correu + contra + nom);
       
       initComponents();
       
        ImageIcon originalIcon = new ImageIcon(foto);
        
        Image originalImage = originalIcon.getImage();
        
        Image resizedImage = originalImage.getScaledInstance(384, 384, Image.SCALE_SMOOTH);

        BufferedImage roundedImage = new BufferedImage(384, 384, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = roundedImage.createGraphics();

        g2d.setClip(new Ellipse2D.Float(0, 0, 384, 384));

        g2d.drawImage(resizedImage, 0, 0, null);

        g2d.dispose();
        
        ImageIcon finalIcon = new ImageIcon(resizedImage);
        
        jFotoUsuario.setIcon(finalIcon);
       
       mostrarInformacionUsuario();      
    }

    /*getters*/
        public int getId() {
            return id;
        }

        public byte[] getFoto() {
            return foto;
        }

        public String getNom_Usuari() {
            return nom_usuari;
        }

        public String getCognom () {
            return cognom;
        }

        public String getDNI() {
            return DNI;
        }

        public String getDomicili() {
            return domicili;
        }

        public String getCorreu() {
            return correu;
        }

        public String setContra() {
            return contra;
        }
    
        public String getNom() {
            return nom;
        }
    /**/    
    /*setters*/
        public void setId(int id) {
            this.id = id;
        }

        public void setFoto(byte[] foto) {
            this.foto = foto;
        }

        public void setNom_Usuari(String nom_usuari) {
            this.nom_usuari = nom_usuari;
        }

        public void setCognom(String cognom) {
            this.cognom = cognom;
        }

        public void setDNI(String DNI) {
            this.DNI = DNI;
        }

        public void setDomicili(String domicili) {
            this.domicili = domicili;
        }

        public void setCorreu(String correu) {
            this.correu = correu;
        }

        public void setContra(String contra) {
            this.contra = contra;
        }
    
        public void setNom(String nom) {
            this.nom = nom;
        }
    /**/    
        
    private void mostrarInformacionUsuario(){        
        System.out.println(id);
        System.out.println(foto);
        System.out.println(nom_usuari);
        System.out.println(cognom);
        System.out.println(DNI);
        System.out.println(domicili);
        System.out.println(correu);
        System.out.println(contra);
        System.out.println(nom);
        
        
        jNomUsuari.setText(nom_usuari);
        jNom.setText(nom);
        jCognom.setText(cognom);
        jDNI.setText(DNI);
        jDomicili.setText(domicili);
        jCorreu.setText(correu);
        jContra.setText(contra);
      
    }        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCorreu = new javax.swing.JTextField();
        jDNI = new javax.swing.JTextField();
        jNom = new javax.swing.JTextField();
        jCognom = new javax.swing.JTextField();
        jDomicili = new javax.swing.JTextField();
        jNomUsuari = new javax.swing.JTextField();
        jContra = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jEditarImagen = new javax.swing.JButton();
        jBotonEditar = new javax.swing.JButton();
        jBotonGuardar = new javax.swing.JButton();
        jFotoUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCorreu.setBackground(new java.awt.Color(184, 221, 140));
        jCorreu.setText(correu);
        jCorreu.setBorder(null);
        jCorreu.setFocusable(false);
        add(jCorreu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 680, 210, 30));

        jDNI.setBackground(new java.awt.Color(184, 221, 140));
        jDNI.setText(DNI);
        jDNI.setBorder(null);
        jDNI.setFocusable(false);
        add(jDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 540, 220, 30));

        jNom.setBackground(new java.awt.Color(184, 221, 140));
        jNom.setText(nom);
        jNom.setBorder(null);
        jNom.setFocusable(false);
        add(jNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 400, 220, 30));

        jCognom.setBackground(new java.awt.Color(184, 221, 140));
        jCognom.setText(cognom);
        jCognom.setBorder(null);
        jCognom.setFocusable(false);
        add(jCognom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 400, 220, 30));

        jDomicili.setBackground(new java.awt.Color(184, 221, 140));
        jDomicili.setText(domicili);
        jDomicili.setBorder(null);
        jDomicili.setFocusable(false);
        add(jDomicili, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 540, 210, 30));

        jNomUsuari.setBackground(new java.awt.Color(184, 221, 140));
        jNomUsuari.setText(nom_usuari);
        jNomUsuari.setBorder(null);
        jNomUsuari.setFocusable(false);
        add(jNomUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 710, 280, 30));

        jContra.setBackground(new java.awt.Color(184, 221, 140));
        jContra.setText(contra);
        jContra.setBorder(null);
        jContra.setFocusable(false);
        add(jContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 690, 170, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 680, 40, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonIniciarSesion.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 800, 340, 100));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonComprarCreditos.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 800, 390, 100));

        jEditarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Foto_Editar_Imagen.png"))); // NOI18N
        jEditarImagen.setBorder(null);
        jEditarImagen.setBorderPainted(false);
        jEditarImagen.setContentAreaFilled(false);
        jEditarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jEditarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, -1, -1));

        jBotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonEditar.png"))); // NOI18N
        jBotonEditar.setBorder(null);
        jBotonEditar.setBorderPainted(false);
        jBotonEditar.setContentAreaFilled(false);
        jBotonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonEditar.setFocusable(false);
        jBotonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonEditarActionPerformed(evt);
            }
        });
        add(jBotonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 800, -1, -1));

        jBotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonGuardar.png"))); // NOI18N
        jBotonGuardar.setBorder(null);
        jBotonGuardar.setBorderPainted(false);
        jBotonGuardar.setContentAreaFilled(false);
        jBotonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonGuardar.setFocusable(false);
        jBotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonGuardarActionPerformed(evt);
            }
        });
        add(jBotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 800, -1, -1));

        jFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FotoUsuario.png"))); // NOI18N
        add(jFotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_PaginaPerfilUsuario.png"))); // NOI18N
        jLabel1.setFocusable(false);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jLabel1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        passwordVisible1 = !passwordVisible1;
        
        if (passwordVisible1) {
            jContra.setEchoChar((char) 0); // Mostrar la contraseña
        } else {
            jContra.setEchoChar('*'); // Ocultar la contraseña con asteriscos
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
    JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);

    // Panel personalizado con JTextField y JLabel organizados en un GridLayout
    JPanel panel = new JPanel(new GridLayout(3, 1));
    JLabel mensajeLabel = new JLabel("Quants crèdits vols comprar? (1 crèdit = 10 €)");
    JTextField cantidadField = new JTextField(10);

    panel.add(mensajeLabel);
    panel.add(cantidadField);

    // Botones personalizados
    Object[] opciones = {"Comprar", "Cancelar"};

    // Muestra el cuadro de diálogo personalizado
    int result = JOptionPane.showOptionDialog(
            marco,
            panel,
            "Compra de Crèdits",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]);

    // Verifica la opción seleccionada por el usuario
    // Verifica la opción seleccionada por el usuario
    if (result == JOptionPane.OK_OPTION) {
        // Aquí puedes manejar la cantidad de créditos ingresada (puedes convertirla a int si es necesario)
        // Puedes mostrar un mensaje de confirmación o realizar otras acciones según tu lógica
        String cantidadCreditos = cantidadField.getText();
        
        creditos = Integer.parseInt(cantidadCreditos);
        
        dinero = creditos * 10;
        
        System.out.println("Comprar " + creditos + " creditos");
        System.out.println("Gastar " + dinero + " euros");
        
        Credits credits = new Credits(id, creditos, dinero);
        
        credits.makeConnection();
        credits.insertOrUpdateWithStatement();

        // Muestra un mensaje de compra realizada correctamente
        JOptionPane.showMessageDialog(marco, "Compra realizada correctamente");
        // Continúa con la lógica de cambio de panel si es necesario
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel(id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);

    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBotonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonEditarActionPerformed
        // TODO add your handling code here:
        Component[] components = this.getComponents();
        for (Component comp : components) {
            if (comp instanceof JTextField || comp instanceof JPasswordField) {
                ((JTextComponent) comp).setFocusable(true);
            }
        }
    
        // Reemplazar jBotonEditar con jBotonGuardar
        jBotonEditar.setVisible(false);
        jBotonGuardar.setVisible(true);
    }//GEN-LAST:event_jBotonEditarActionPerformed

    private void jBotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonGuardarActionPerformed
        // TODO add your handling code here:
        
        jBotonEditar.setVisible(true);
        jBotonGuardar.setVisible(false);
    }//GEN-LAST:event_jBotonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonEditar;
    private javax.swing.JButton jBotonGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jCognom;
    private javax.swing.JPasswordField jContra;
    private javax.swing.JTextField jCorreu;
    private javax.swing.JTextField jDNI;
    private javax.swing.JTextField jDomicili;
    private javax.swing.JButton jEditarImagen;
    private javax.swing.JLabel jFotoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNom;
    private javax.swing.JTextField jNomUsuari;
    // End of variables declaration//GEN-END:variables
}
