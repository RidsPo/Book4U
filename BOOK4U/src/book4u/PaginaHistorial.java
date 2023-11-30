package book4u;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PaginaHistorial extends javax.swing.JPanel {

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
    protected String dinero;
    
    public PaginaHistorial(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
        
        List<Reserves> reservasCaducadas = reserves.getReservasCaducadas();
        
        for(Reserves reserva : reservasCaducadas){
            ImageIcon originalIcon1 = new ImageIcon(reserva.getFoto());
        
            Image originalImage1 = originalIcon1.getImage();
        
            Image resizedImage1 = originalImage1.getScaledInstance(106, 106, Image.SCALE_SMOOTH);

            BufferedImage roundedImage1 = new BufferedImage(106, 106, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d1 = roundedImage1.createGraphics();

            g2d1.setClip(new Ellipse2D.Float(0, 0, 106, 106));

            g2d1.drawImage(resizedImage1, 0, 0, null);

            g2d1.dispose();
        
            ImageIcon finalIcon1 = new ImageIcon(resizedImage1);
            
            JLabel labelfoto = new JLabel();
            labelfoto.setIcon(finalIcon1);
            JTextField Nombre = new JTextField(reserva.getNombre());
            JTextField precio = new JTextField(reserva.getPrecio());
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LesMevesReserves = new javax.swing.JButton();
        BotonPaginaPrincipal = new javax.swing.JButton();
        BotonNovaReserva = new javax.swing.JButton();
        BotonUsuario = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LesMevesReserves.setBorder(null);
        LesMevesReserves.setBorderPainted(false);
        LesMevesReserves.setContentAreaFilled(false);
        LesMevesReserves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LesMevesReserves.setFocusable(false);
        LesMevesReserves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LesMevesReservesActionPerformed(evt);
            }
        });
        add(LesMevesReserves, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 290, 90));

        BotonPaginaPrincipal.setBorder(null);
        BotonPaginaPrincipal.setBorderPainted(false);
        BotonPaginaPrincipal.setContentAreaFilled(false);
        BotonPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPaginaPrincipal.setFocusable(false);
        BotonPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPaginaPrincipalActionPerformed(evt);
            }
        });
        add(BotonPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 230, 90));

        BotonNovaReserva.setBorder(null);
        BotonNovaReserva.setBorderPainted(false);
        BotonNovaReserva.setContentAreaFilled(false);
        BotonNovaReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonNovaReserva.setFocusable(false);
        BotonNovaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNovaReservaActionPerformed(evt);
            }
        });
        add(BotonNovaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 220, 90));

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
        add(BotonUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 30, -1, -1));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("adsasdasd");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.setFocusable(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 50, 180, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PaginaHistorial (2).png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void LesMevesReservesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LesMevesReservesActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaMevesReservesPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_LesMevesReservesActionPerformed

    private void BotonPaginaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPaginaPrincipalActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonPaginaPrincipalActionPerformed

    private void BotonNovaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNovaReservaActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaReservaPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonNovaReservaActionPerformed

    private void BotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuarioActionPerformed
        // TODO add your handling code here:
        JDialog dialog = new JDialog();
        dialog.setLayout(new FlowLayout());
        dialog.setLocation(1720, 70);

        JButton button1 = new JButton("Ver Perfil");
        JButton button2 = new JButton("Cerrar Sesión");

        dialog.add(button1);
        dialog.add(button2);

        dialog.setSize(200, 110);
        dialog.setModal(true);

        button1.addActionListener((ActionEvent e) -> {
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
            
            this.infousuario = new PaginaPerfilUsuario (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom);

            System.out.println("Mensaje de la pagina principal al perfil: " + infousuario.id + "," + infousuario.foto + "," + infousuario.nom_usuari + "," + infousuario.cognom + "," + infousuario.DNI + "," + infousuario.domicili + "," + infousuario.correu + "," + infousuario.contra + "," + infousuario.nom);
            
            marco.remove(this);
            marco.add(new PaginaPerfilUsuario(id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
            marco.setVisible(true);
            dialog.dispose();
        });

        button2.addActionListener((ActionEvent e) -> {
            // Código para cerrar la sesión (puede incluir limpiar datos de usuario, etc.)

            // Cerrar el diálogo
            dialog.dispose();

            // Obtener el marco principal
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);

            // Remover la actual interfaz de usuario
            marco.remove(this);

            // Agregar la página de inicio de sesión (reemplaza 'PaginaInicioSesion' con tu clase real)
            marco.add(new PaginaInicial());

            // Hacer visible el cambio
            marco.setVisible(true);
        });

        dialog.setVisible(true);
    }//GEN-LAST:event_BotonUsuarioActionPerformed

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
    private javax.swing.JButton BotonNovaReserva;
    private javax.swing.JButton BotonPaginaPrincipal;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JButton LesMevesReserves;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
