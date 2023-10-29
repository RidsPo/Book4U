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
public class PaginaRegistro2Panel extends javax.swing.JPanel {

    /**
     * Creates new form PaginaRegistro2Panel
     */
    public PaginaRegistro2Panel() {
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

        jBotonVolver = new javax.swing.JButton();
        jBotonRegistrar = new javax.swing.JButton();
        jFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBotonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Torna_PaginaRegistro2.png"))); // NOI18N
        jBotonVolver.setBorder(null);
        jBotonVolver.setBorderPainted(false);
        jBotonVolver.setContentAreaFilled(false);
        jBotonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonVolverActionPerformed(evt);
            }
        });
        add(jBotonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 910, 250, 90));

        jBotonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Registrar_PaginaRegistro2.png"))); // NOI18N
        jBotonRegistrar.setBorder(null);
        jBotonRegistrar.setBorderPainted(false);
        jBotonRegistrar.setContentAreaFilled(false);
        jBotonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonRegistrarActionPerformed(evt);
            }
        });
        add(jBotonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 910, 290, 90));

        jFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_PaginaRegistro2.png"))); // NOI18N
        add(jFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonRegistrarActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel());
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonRegistrarActionPerformed

    private void jBotonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonVolverActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaRegistroPanel());
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonRegistrar;
    private javax.swing.JButton jBotonVolver;
    private javax.swing.JLabel jFondo;
    // End of variables declaration//GEN-END:variables
}
