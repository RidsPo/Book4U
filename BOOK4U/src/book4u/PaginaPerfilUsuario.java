package book4u;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.text.JTextComponent;

public class PaginaPerfilUsuario extends javax.swing.JPanel {

    protected int id;
    protected byte[] foto;
    
    private byte[] imageData;

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
        jBotonContra = new javax.swing.JButton();
        jBotonPaginaPrincipal = new javax.swing.JButton();
        jBotonCancelar = new javax.swing.JButton();
        jComprarCreditos = new javax.swing.JButton();
        jEditarImagen = new javax.swing.JButton();
        jBotonEditar = new javax.swing.JButton();
        jBotonGuardar = new javax.swing.JButton();
        jFotoUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCorreu.setBackground(new java.awt.Color(184, 221, 140));
        jCorreu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jCorreu.setText(correu);
        jCorreu.setBorder(null);
        jCorreu.setFocusable(false);
        add(jCorreu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 683, 210, 30));

        jDNI.setBackground(new java.awt.Color(184, 221, 140));
        jDNI.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jDNI.setText(DNI);
        jDNI.setBorder(null);
        jDNI.setFocusable(false);
        add(jDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 540, 220, 30));

        jNom.setBackground(new java.awt.Color(184, 221, 140));
        jNom.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jNom.setText(nom);
        jNom.setBorder(null);
        jNom.setFocusable(false);
        add(jNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1055, 397, 220, 30));

        jCognom.setBackground(new java.awt.Color(184, 221, 140));
        jCognom.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jCognom.setText(cognom);
        jCognom.setBorder(null);
        jCognom.setFocusable(false);
        add(jCognom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 398, 220, 30));

        jDomicili.setBackground(new java.awt.Color(184, 221, 140));
        jDomicili.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jDomicili.setText(domicili);
        jDomicili.setBorder(null);
        jDomicili.setFocusable(false);
        add(jDomicili, new org.netbeans.lib.awtextra.AbsoluteConstraints(1405, 539, 210, 30));

        jNomUsuari.setBackground(new java.awt.Color(184, 221, 140));
        jNomUsuari.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jNomUsuari.setText(nom_usuari);
        jNomUsuari.setBorder(null);
        jNomUsuari.setFocusable(false);
        add(jNomUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 714, 280, 30));

        jContra.setBackground(new java.awt.Color(184, 221, 140));
        jContra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jContra.setText(contra);
        jContra.setBorder(null);
        jContra.setFocusable(false);
        add(jContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1405, 688, 170, 20));

        jBotonContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        jBotonContra.setBorder(null);
        jBotonContra.setBorderPainted(false);
        jBotonContra.setContentAreaFilled(false);
        jBotonContra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonContra.setFocusable(false);
        jBotonContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonContraActionPerformed(evt);
            }
        });
        add(jBotonContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 680, 40, -1));

        jBotonPaginaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonIniciarSesion.png"))); // NOI18N
        jBotonPaginaPrincipal.setBorder(null);
        jBotonPaginaPrincipal.setContentAreaFilled(false);
        jBotonPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonPaginaPrincipal.setFocusable(false);
        jBotonPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonPaginaPrincipalActionPerformed(evt);
            }
        });
        add(jBotonPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 800, 340, 100));

        jBotonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonCancelar.png"))); // NOI18N
        jBotonCancelar.setBorder(null);
        jBotonCancelar.setBorderPainted(false);
        jBotonCancelar.setContentAreaFilled(false);
        jBotonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonCancelar.setFocusable(false);
        jBotonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonCancelarActionPerformed(evt);
            }
        });
        add(jBotonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 800, -1, -1));

        jComprarCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonComprarCreditos.png"))); // NOI18N
        jComprarCreditos.setBorder(null);
        jComprarCreditos.setBorderPainted(false);
        jComprarCreditos.setContentAreaFilled(false);
        jComprarCreditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComprarCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComprarCreditosActionPerformed(evt);
            }
        });
        add(jComprarCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 800, 390, 100));

        jEditarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Foto_Editar_Imagen.png"))); // NOI18N
        jEditarImagen.setBorder(null);
        jEditarImagen.setBorderPainted(false);
        jEditarImagen.setContentAreaFilled(false);
        jEditarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jEditarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarImagenActionPerformed(evt);
            }
        });
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


    private void jBotonContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonContraActionPerformed
        // TODO add your handling code here:
        passwordVisible1 = !passwordVisible1;
        
        if (passwordVisible1) {
            jContra.setEchoChar((char) 0); // Mostrar la contraseña
        } else {
            jContra.setEchoChar('*'); // Ocultar la contraseña con asteriscos
        }
    }//GEN-LAST:event_jBotonContraActionPerformed

    private void jBotonPaginaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonPaginaPrincipalActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonPaginaPrincipalActionPerformed

    private void jComprarCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComprarCreditosActionPerformed
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
    }//GEN-LAST:event_jComprarCreditosActionPerformed

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
        jBotonPaginaPrincipal.setVisible(false);
        jBotonGuardar.setVisible(true);
    }//GEN-LAST:event_jBotonEditarActionPerformed

    private void jBotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonGuardarActionPerformed
        // TODO add your handling code here:
        Component[] components = this.getComponents();
        for (Component comp : components) {
            if (comp instanceof JTextField || comp instanceof JPasswordField) {
                ((JTextComponent) comp).setFocusable(false);
            }
        }
        
        nom = jNom.getText();
        cognom = jCognom.getText();
        DNI = jDNI.getText();
        domicili = jDomicili.getText();
        nom_usuari = jNomUsuari.getText();
        correu = jCorreu.getText();
        contra = jContra.getText();
        
        Usuarios editarinfo = new Usuarios(id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom);
        
        editarinfo.makeConnection();
        editarinfo.updateWithStatement();
        
        jBotonEditar.setVisible(true);
        jBotonGuardar.setVisible(false);
        jBotonPaginaPrincipal.setVisible(true);
        jBotonGuardar.setVisible(false);
    }//GEN-LAST:event_jBotonGuardarActionPerformed

    private void jBotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonCancelarActionPerformed
        // TODO add your handling code here:
        
        Component[] components = this.getComponents();
        for (Component comp : components) {
            if (comp instanceof JTextField || comp instanceof JPasswordField) {
                ((JTextComponent) comp).setFocusable(false);
            }
        }
        
        jBotonEditar.setVisible(true);
        jBotonGuardar.setVisible(false);
        jBotonPaginaPrincipal.setVisible(true);
        jBotonGuardar.setVisible(false);
    }//GEN-LAST:event_jBotonCancelarActionPerformed

    private void jEditarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarImagenActionPerformed
        // TODO add your handling code here:
        
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        
        if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = jf.getSelectedFile();

            // Almacenar la ruta del archivo seleccionado en la variable
            imageData = getBytesFromFile(selectedFile);
           
            System.out.println("Tamaño de la imagen en bytes: " + imageData.length);
        }
        
        Usuarios imagenUsuario = new Usuarios(id, imageData);
        
        imagenUsuario.makeConnection();
        imagenUsuario.updateImageWithStatement();
        
        actualizarInterfazGrafica();
    }//GEN-LAST:event_jEditarImagenActionPerformed

    private byte[] getBytesFromFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            
            byte[] buf = new byte[1024];
        
            int bytesRead;
            while ((bytesRead = fis.read(buf)) != -1) {
                bos.write(buf, 0, bytesRead);
            }

            fis.close();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }  
    
    public void actualizarInterfazGrafica() {   
        
        Usuarios nuevaFoto = new Usuarios(nom_usuari, contra);
        
        nuevaFoto.selectWithStatement();
        
        ImageIcon nuevaImagen = new ImageIcon(nuevaFoto.foto);

        Image originalImage = nuevaImagen.getImage();
        
        Image resizedImage = originalImage.getScaledInstance(384, 384, Image.SCALE_SMOOTH);

        BufferedImage roundedImage = new BufferedImage(384, 384, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = roundedImage.createGraphics();

        g2d.setClip(new Ellipse2D.Float(0, 0, 384, 384));

        g2d.drawImage(resizedImage, 0, 0, null);

        g2d.dispose();
        
        ImageIcon finalIcon = new ImageIcon(resizedImage);
        
        jFotoUsuario.setIcon(finalIcon);
        
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonCancelar;
    private javax.swing.JButton jBotonContra;
    private javax.swing.JButton jBotonEditar;
    private javax.swing.JButton jBotonGuardar;
    private javax.swing.JButton jBotonPaginaPrincipal;
    private javax.swing.JTextField jCognom;
    private javax.swing.JButton jComprarCreditos;
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
