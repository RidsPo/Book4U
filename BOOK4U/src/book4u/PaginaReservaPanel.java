package book4u;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PaginaReservaPanel extends javax.swing.JPanel {

    
    PaginaPerfilUsuario infousuario = null;
    
    private byte[] imageData;
    
    protected int id;
    protected byte[] foto;
    protected String nom_usuari;
    protected String cognom;
    protected String DNI;
    protected String domicili;
    protected String correu;
    protected String contra;
    protected String nom;   
    
    public PaginaReservaPanel(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
               
        initComponents();
       
        ImageIcon originalIcon = new ImageIcon(foto);
        
        Image originalImage = originalIcon.getImage();
        
        Image resizedImage = originalImage.getScaledInstance(106, 106, Image.SCALE_SMOOTH);

        BufferedImage roundedImage = new BufferedImage(106, 106, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = roundedImage.createGraphics();

        g2d.setClip(new Ellipse2D.Float(0, 0, 106, 106));

        g2d.drawImage(resizedImage, 0, 0, null);

        g2d.dispose();
        
        ImageIcon finalIcon = new ImageIcon(resizedImage);
        
        BotonUsuario.setIcon(finalIcon);
        
        System.out.println("Mensaje de la pagina principal: " + id + foto + nom_usuari + cognom + DNI + domicili + correu + contra + nom);        

        actualizarInterfazGrafica();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonMisReservas = new javax.swing.JButton();
        BotonPaginaPrincipal = new javax.swing.JButton();
        BotonHistorial = new javax.swing.JButton();
        BotonMonedero = new javax.swing.JButton();
        BotonUsuario = new javax.swing.JButton();
        BotonCrearReserva = new javax.swing.JButton();
        BotonCrearReserva1 = new javax.swing.JButton();
        BotonCrearReserva2 = new javax.swing.JButton();
        jSelectFoto = new javax.swing.JButton();
        Crear = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonMisReservas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonMisReservas.setBorder(null);
        BotonMisReservas.setBorderPainted(false);
        BotonMisReservas.setContentAreaFilled(false);
        BotonMisReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonMisReservas.setFocusable(false);
        BotonMisReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMisReservasActionPerformed(evt);
            }
        });
        add(BotonMisReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 290, 100));

        BotonPaginaPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonPaginaPrincipal.setBorder(null);
        BotonPaginaPrincipal.setBorderPainted(false);
        BotonPaginaPrincipal.setContentAreaFilled(false);
        BotonPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPaginaPrincipal.setFocusPainted(false);
        BotonPaginaPrincipal.setFocusable(false);
        BotonPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPaginaPrincipalActionPerformed(evt);
            }
        });
        add(BotonPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 240, 100));

        BotonHistorial.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonHistorial.setBorder(null);
        BotonHistorial.setBorderPainted(false);
        BotonHistorial.setContentAreaFilled(false);
        BotonHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonHistorial.setFocusable(false);
        BotonHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHistorialActionPerformed(evt);
            }
        });
        add(BotonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 220, 100));

        BotonMonedero.setBorder(null);
        BotonMonedero.setBorderPainted(false);
        BotonMonedero.setContentAreaFilled(false);
        BotonMonedero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonMonedero.setFocusable(false);
        add(BotonMonedero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 30, 210, 110));

        BotonUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil.png"))); // NOI18N
        BotonUsuario.setBorder(null);
        BotonUsuario.setBorderPainted(false);
        BotonUsuario.setContentAreaFilled(false);
        BotonUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonUsuario.setFocusable(false);
        BotonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUsuarioActionPerformed(evt);
            }
        });
        add(BotonUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 30, 110, 110));

        BotonCrearReserva.setBorder(null);
        BotonCrearReserva.setBorderPainted(false);
        BotonCrearReserva.setContentAreaFilled(false);
        BotonCrearReserva.setFocusable(false);
        BotonCrearReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearReservaActionPerformed(evt);
            }
        });
        add(BotonCrearReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 410, 220, 100));

        BotonCrearReserva1.setBorder(null);
        BotonCrearReserva1.setBorderPainted(false);
        BotonCrearReserva1.setContentAreaFilled(false);
        BotonCrearReserva1.setFocusable(false);
        BotonCrearReserva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearReserva1ActionPerformed(evt);
            }
        });
        add(BotonCrearReserva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 640, 220, 100));

        BotonCrearReserva2.setBorder(null);
        BotonCrearReserva2.setBorderPainted(false);
        BotonCrearReserva2.setContentAreaFilled(false);
        BotonCrearReserva2.setFocusable(false);
        BotonCrearReserva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearReserva2ActionPerformed(evt);
            }
        });
        add(BotonCrearReserva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 870, 220, 100));

        jSelectFoto.setText("jButton1");
        jSelectFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSelectFotoActionPerformed(evt);
            }
        });
        add(jSelectFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_PaginaReserva.png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonMisReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMisReservasActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaMevesReservesPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonMisReservasActionPerformed

    private void BotonPaginaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPaginaPrincipalActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonPaginaPrincipalActionPerformed

    private void BotonHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHistorialActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaHistorial (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonHistorialActionPerformed

    private void BotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuarioActionPerformed
        // TODO add your handling code here:
       JDialog dialog = new JDialog();
        dialog.setLayout(new FlowLayout());
        dialog.setLocation(1720, 70); // Establece la ubicación en las coordenadas (300, 200)
       
        // Crea los dos botones para el diálogo
        JButton button1 = new JButton("Ver Perfil");
        JButton button2 = new JButton("Cerrar Sesión");
        
        // Agrega los botones al diálogo
        dialog.add(button1);
        dialog.add(button2);
        
        // Establece el tamaño del diálogo
        dialog.setSize(200, 110);
           // Haz que el diálogo sea modal para bloquear la ventana principal
        dialog.setModal(true);
           // Define un manejador de eventos para los botones del diálogo
        button1.addActionListener((ActionEvent e) -> {
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
            
            this.infousuario = new PaginaPerfilUsuario (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom);
            
            marco.remove(this);
            marco.add(new PaginaPerfilUsuario (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
            marco.setVisible(true);
            dialog.dispose(); // Cierra el diálogo
       });  button2.addActionListener((ActionEvent e) -> {
            // Código para el botón 2
            dialog.dispose(); // Cierra el diálogo
            
            // Obtener el marco principal
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);

            // Remover la actual interfaz de usuario
            marco.remove(this);

            // Agregar la página de inicio de sesión (reemplaza 'PaginaInicioSesion' con tu clase real)
            marco.add(new PaginaInicial());

            // Hacer visible el cambio
            marco.setVisible(true);
       });
         // Haz visible el diálogo
        dialog.setVisible(true);
    }//GEN-LAST:event_BotonUsuarioActionPerformed

    private void BotonCrearReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonCrearReservaActionPerformed

    private void BotonCrearReserva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearReserva1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonCrearReserva1ActionPerformed

    private void BotonCrearReserva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearReserva2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonCrearReserva2ActionPerformed
   
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
    
    private void jSelectFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSelectFotoActionPerformed
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
    }//GEN-LAST:event_jSelectFotoActionPerformed

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        // TODO add your handling code here:
        
        String nombre = "Piso en Madrid";
        String direccion = "Calle Girona, 25, 1a";
        int precio = 20;
        int ocupado = 0;
        
       Residencias residencia = new Residencias(imageData, nombre, direccion, precio, ocupado);
       
       residencia.makeConnection();
       
       residencia.insertWithStatement();
    }//GEN-LAST:event_CrearActionPerformed
    
    public void actualizarInterfazGrafica() {   
        
        Usuarios nuevaFoto = new Usuarios(nom_usuari, contra);
        
        nuevaFoto.selectWithStatement();
        
        ImageIcon nuevaImagen = new ImageIcon(nuevaFoto.foto);

        Image originalImage = nuevaImagen.getImage();
        
        Image resizedImage = originalImage.getScaledInstance(106, 106, Image.SCALE_SMOOTH);

        BufferedImage roundedImage = new BufferedImage(106, 106, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = roundedImage.createGraphics();

        g2d.setClip(new Ellipse2D.Float(0, 0, 106, 106));

        g2d.drawImage(resizedImage, 0, 0, null);

        g2d.dispose();
        
        ImageIcon finalIcon = new ImageIcon(resizedImage);
        
        BotonUsuario.setIcon(finalIcon);     
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCrearReserva;
    private javax.swing.JButton BotonCrearReserva1;
    private javax.swing.JButton BotonCrearReserva2;
    private javax.swing.JButton BotonHistorial;
    private javax.swing.JButton BotonMisReservas;
    private javax.swing.JButton BotonMonedero;
    private javax.swing.JButton BotonPaginaPrincipal;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JButton Crear;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jSelectFoto;
    // End of variables declaration//GEN-END:variables
}
