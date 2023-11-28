package book4u;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PaginaMevesReservesPanel extends javax.swing.JPanel {

    PaginaPerfilUsuario infousuario = null;
    
    protected int id;
    protected byte[] foto;
    protected String nom_usuari;
    protected String cognom;
    protected String DNI;
    protected String domicili;
    protected String correu;
    protected String contra;
    protected String nom;  
    
    protected String credits;
    
    private List<Reserves> listaReserves;
    
    public PaginaMevesReservesPanel(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
        
        Credits creditos = new Credits(id);
        
        creditos.selectWithStatement();
        
        this.credits = String.valueOf(creditos.credits);
        
        jTextField1.setText(credits);
        
        actualizarInterfazGrafica();
        
        Reserves reserves = new Reserves(id);

        listaReserves = new ArrayList<>();
        
        listaReserves = reserves.selectWithStatement();
        
        if(listaReserves.size() >= 1){
            Reserves reserva1 = listaReserves.get(0);
            
            /*ImageIcon originalIcon1 = new ImageIcon(residencia1.getFotoResidencia());
        
            Image originalImage1 = originalIcon1.getImage();
        
            Image resizedImage1 = originalImage1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage1 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d1 = roundedImage1.createGraphics();

            g2d1.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d1.drawImage(resizedImage1, 0, 0, null);

            g2d1.dispose();
        
            ImageIcon finalIcon1 = new ImageIcon(resizedImage1);
        
            Foto.setIcon(finalIcon1);*/
            
            jTextField2.setText(String.valueOf(reserva1.getPrecio()));
            jTextField3.setText(String.valueOf(reserva1.getDataInici()));
            jTextField4.setText(String.valueOf(reserva1.getDataFi()));
            
            
            /*Residencias residencia2 = listaResidencias.get(1);
            
            ImageIcon originalIcon2 = new ImageIcon(residencia1.getFotoResidencia());
        
            Image originalImage2 = originalIcon2.getImage();
        
            Image resizedImage2 = originalImage2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage2 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d2 = roundedImage2.createGraphics();

            g2d2.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d2.drawImage(resizedImage2, 0, 0, null);

            g2d2.dispose();
        
            ImageIcon finalIcon2 = new ImageIcon(resizedImage2);
        
            Foto1.setIcon(finalIcon2);
            
            Info1.setText(residencia2.getNombre() + " en: " + residencia2.getDireccion());
            Precio1.setText(String.valueOf(residencia2.getPrecio()));
            
            if(residencia2.getOcupado() == 0){
                BotonCrearReserva1.setVisible(true);
                MensajeOcupado1.setVisible(false);
            } else if (residencia2.getOcupado() == 1) {
                BotonCrearReserva1.setVisible(false);
                MensajeOcupado1.setVisible(true);
            }

            Residencias residencia3 = listaResidencias.get(2);
            
            ImageIcon originalIcon3 = new ImageIcon(residencia1.getFotoResidencia());
        
            Image originalImage3 = originalIcon3.getImage();
        
            Image resizedImage3 = originalImage3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage3 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d3 = roundedImage3.createGraphics();

            g2d3.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d3.drawImage(resizedImage3, 0, 0, null);

            g2d3.dispose();
        
            ImageIcon finalIcon3 = new ImageIcon(resizedImage3);
        
            Foto2.setIcon(finalIcon3);
            
            Info2.setText(residencia3.getNombre() + " en: " + residencia3.getDireccion());
            Precio2.setText(String.valueOf(residencia3.getPrecio()));
            
            if(residencia3.getOcupado() == 0){
                BotonCrearReserva2.setVisible(true);
                MensajeOcupado2.setVisible(false);
            } else if (residencia3.getOcupado() == 1) {
                BotonCrearReserva2.setVisible(false);
                MensajeOcupado2.setVisible(true);
            }*/
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonNuevaReserva = new javax.swing.JButton();
        BotonPaginaPrincipal = new javax.swing.JButton();
        BotonHistorial = new javax.swing.JButton();
        BotonUsuario = new javax.swing.JButton();
        BotonModificarReserva = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        Foto = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonNuevaReserva.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonNuevaReserva.setBorder(null);
        BotonNuevaReserva.setBorderPainted(false);
        BotonNuevaReserva.setContentAreaFilled(false);
        BotonNuevaReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonNuevaReserva.setFocusable(false);
        BotonNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevaReservaActionPerformed(evt);
            }
        });
        add(BotonNuevaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 220, 100));

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
        add(BotonPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 240, 90));

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
        add(BotonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 220, 100));

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

        BotonModificarReserva.setBorder(null);
        BotonModificarReserva.setBorderPainted(false);
        BotonModificarReserva.setContentAreaFilled(false);
        BotonModificarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonModificarReserva.setFocusable(false);
        BotonModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarReservaActionPerformed(evt);
            }
        });
        add(BotonModificarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 410, 260, 90));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("adadaasasdasd");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.setFocusable(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 50, 180, 80));
        add(Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 130, 120));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 470, -1, -1));
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 470, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PaginaMevesReserves (1).png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaReservaActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaReservaPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonNuevaReservaActionPerformed

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

    private void BotonModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonModificarReservaActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
    private javax.swing.JButton BotonHistorial;
    private javax.swing.JButton BotonModificarReserva;
    private javax.swing.JButton BotonNuevaReserva;
    private javax.swing.JButton BotonPaginaPrincipal;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Foto;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
