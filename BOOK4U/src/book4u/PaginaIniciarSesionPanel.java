/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package book4u;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author xavic
 */
public class PaginaIniciarSesionPanel extends javax.swing.JPanel {

    /**
     * Creates new form PaginaIniciarSesionPanel
     */
    public PaginaIniciarSesionPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNombreUsuario = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jBotonRegistro = new javax.swing.JButton();
        jBotonInicioSesion = new javax.swing.JButton();
        jFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jNombreUsuario.setBackground(new java.awt.Color(184, 221, 140));
        jNombreUsuario.setBorder(null);
        jNombreUsuario.setMinimumSize(new java.awt.Dimension(64, 40));
        jNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNombreUsuarioActionPerformed(evt);
            }
        });
        add(jNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 530, 450, 50));

        jPasswordField1.setBackground(new java.awt.Color(184, 221, 140));
        jPasswordField1.setBorder(null);
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 742, 430, 60));

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
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel ());
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonInicioSesionActionPerformed

    private void jNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNombreUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonInicioSesion;
    private javax.swing.JButton jBotonRegistro;
    private javax.swing.JLabel jFondo;
    private javax.swing.JTextField jNombreUsuario;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
