package book4u;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PaginaPrincipalPanel extends javax.swing.JPanel {

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
    
    public PaginaPrincipalPanel(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
        
        jBotonUsuario.setIcon(finalIcon);
        
        System.out.println("Mensaje de la pagina principal: " + id + foto + nom_usuari + cognom + DNI + domicili + correu + contra + nom);        
    
        Credits creditos =  new Credits(id);
        
        creditos.selectWithStatement();
        
        this.credits = String.valueOf(creditos.credits);
        
        jTextField1.setText(credits);
        
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

        jBotonNovaReserva = new javax.swing.JButton();
        jBotonLesMevesReserves = new javax.swing.JButton();
        jBotonHistorial1 = new javax.swing.JButton();
        jBotonUsuario = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBotonNovaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_NuevaReserva_PaginaPrincipal.png"))); // NOI18N
        jBotonNovaReserva.setBorderPainted(false);
        jBotonNovaReserva.setContentAreaFilled(false);
        jBotonNovaReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonNovaReserva.setFocusPainted(false);
        jBotonNovaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonNovaReservaActionPerformed(evt);
            }
        });
        add(jBotonNovaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 230, 100));

        jBotonLesMevesReserves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_MisReservas_PaginaPrincipal.png"))); // NOI18N
        jBotonLesMevesReserves.setBorder(null);
        jBotonLesMevesReserves.setBorderPainted(false);
        jBotonLesMevesReserves.setContentAreaFilled(false);
        jBotonLesMevesReserves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonLesMevesReserves.setFocusPainted(false);
        jBotonLesMevesReserves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonLesMevesReservesActionPerformed(evt);
            }
        });
        add(jBotonLesMevesReserves, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 310, 110));

        jBotonHistorial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Historial_PaginaPrincipal.png"))); // NOI18N
        jBotonHistorial1.setBorder(null);
        jBotonHistorial1.setBorderPainted(false);
        jBotonHistorial1.setContentAreaFilled(false);
        jBotonHistorial1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonHistorial1.setFocusPainted(false);
        jBotonHistorial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonHistorial1ActionPerformed(evt);
            }
        });
        add(jBotonHistorial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, -1, -1));

        jBotonUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil.png"))); // NOI18N
        jBotonUsuario.setBorder(null);
        jBotonUsuario.setBorderPainted(false);
        jBotonUsuario.setContentAreaFilled(false);
        jBotonUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonUsuario.setFocusPainted(false);
        jBotonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonUsuarioActionPerformed(evt);
            }
        });
        add(jBotonUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 30, -1, -1));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("adsdaadad");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.setFocusable(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 50, 180, 80));

        jFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_PaginaPrinicpal.png"))); // NOI18N
        add(jFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonNovaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonNovaReservaActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        marco.remove(this);
        marco.add(new PaginaReservaPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonNovaReservaActionPerformed

    private void jBotonLesMevesReservesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonLesMevesReservesActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        marco.remove(this);
        marco.add(new PaginaMevesReservesPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonLesMevesReservesActionPerformed

    private void jBotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonUsuarioActionPerformed
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
    }//GEN-LAST:event_jBotonUsuarioActionPerformed

    private void jBotonHistorial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonHistorial1ActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        marco.remove(this);
        marco.add(new PaginaHistorial (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonHistorial1ActionPerformed
    
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
        
        jBotonUsuario.setIcon(finalIcon);     
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonHistorial1;
    private javax.swing.JButton jBotonLesMevesReserves;
    private javax.swing.JButton jBotonNovaReserva;
    private javax.swing.JButton jBotonUsuario;
    private javax.swing.JLabel jFondo;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
