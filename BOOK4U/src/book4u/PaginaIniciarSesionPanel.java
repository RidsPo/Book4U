package book4u;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PaginaIniciarSesionPanel extends javax.swing.JPanel {

    Usuarios informacion = null;
    PaginaPrincipalPanel infousuarios = null;
    
    private boolean passwordVisible = false; 
    
    public PaginaIniciarSesionPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNombreUsuario = new javax.swing.JTextField();
        BotonMostrar = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jBotonRegistro = new javax.swing.JButton();
        jBotonInicioSesion = new javax.swing.JButton();
        jFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jNombreUsuario.setBackground(new java.awt.Color(184, 221, 140));
        jNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jNombreUsuario.setBorder(null);
        jNombreUsuario.setMinimumSize(new java.awt.Dimension(64, 40));
        add(jNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 532, 450, 50));

        BotonMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        BotonMostrar.setBorder(null);
        BotonMostrar.setBorderPainted(false);
        BotonMostrar.setContentAreaFilled(false);
        BotonMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonMostrar.setFocusPainted(false);
        BotonMostrar.setFocusable(false);
        BotonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarActionPerformed(evt);
            }
        });
        add(BotonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 750, 60, -1));

        jPasswordField1.setBackground(new java.awt.Color(184, 221, 140));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPasswordField1.setBorder(null);
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 739, 370, 60));

        jBotonRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Registro_PaginaIniciarSesion.png"))); // NOI18N
        jBotonRegistro.setBorder(null);
        jBotonRegistro.setBorderPainted(false);
        jBotonRegistro.setContentAreaFilled(false);
        jBotonRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonRegistro.setFocusPainted(false);
        jBotonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonRegistroActionPerformed(evt);
            }
        });
        add(jBotonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 900, 340, 100));

        jBotonInicioSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_IniciarSesion_PaginaIniciarSesion.png"))); // NOI18N
        jBotonInicioSesion.setBorder(null);
        jBotonInicioSesion.setBorderPainted(false);
        jBotonInicioSesion.setContentAreaFilled(false);
        jBotonInicioSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonInicioSesion.setFocusPainted(false);
        jBotonInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonInicioSesionActionPerformed(evt);
            }
        });
        add(jBotonInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 900, -1, -1));

        jFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_PaginIniciarSesion.png"))); // NOI18N
        add(jFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonRegistroActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaRegistroPanel ());
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonRegistroActionPerformed

    private void jBotonInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonInicioSesionActionPerformed
        // TODO add your handling code here:
        
        if (jNombreUsuario.getText().isEmpty() && jPasswordField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jBotonInicioSesion, "Introduce un nombre y una contraseña.");
        } else if (jNombreUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jBotonInicioSesion, "Introduce un nombre de usuario.");
        } else if (jPasswordField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jBotonInicioSesion, "Introduce una contraseña.");
        } else {
            String nombreUsuario = jNombreUsuario.getText();
            String contraseñaUsuario = jPasswordField1.getText();

            this.informacion = new Usuarios(nombreUsuario, contraseñaUsuario);

            informacion.makeConnection();

            informacion.selectWithStatement();

            if (informacion.id == 0) {
                JOptionPane.showMessageDialog(jBotonInicioSesion, "El usuario o la contraseña no existe.");
            } else {
                System.out.println("Mensaje de la pagina de iniciar sesion a la principal: " + informacion.id + "," + informacion.foto + "," + informacion.nom_usuari + "," + informacion.cognom + "," + informacion.DNI + "," + informacion.domicili + "," + informacion.correu + "," + informacion.contra + "," + informacion.nom);

                this.infousuarios = new PaginaPrincipalPanel(informacion.id, informacion.foto, informacion.nom_usuari, informacion.cognom, informacion.DNI, informacion.domicili, informacion.correu, informacion.contra, informacion.nom);

                JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
                marco.remove(this);
                marco.add(infousuarios);
                marco.setVisible(true);
        }
        }
    }//GEN-LAST:event_jBotonInicioSesionActionPerformed

    private void BotonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMostrarActionPerformed
        // TODO add your handling code here:
        passwordVisible = !passwordVisible; // Alternar el estado
    if (passwordVisible) {
        jPasswordField1.setEchoChar((char) 0); // Mostrar caracteres
    } else {
        jPasswordField1.setEchoChar('*'); // Ocultar caracteres
    }
    }//GEN-LAST:event_BotonMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonMostrar;
    private javax.swing.JButton jBotonInicioSesion;
    private javax.swing.JButton jBotonRegistro;
    private javax.swing.JLabel jFondo;
    private javax.swing.JTextField jNombreUsuario;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
