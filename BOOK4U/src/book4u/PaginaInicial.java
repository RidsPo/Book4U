package book4u;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PaginaInicial extends javax.swing.JPanel {

    public PaginaInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBotonRegistro = new javax.swing.JButton();
        jBotonIniciarSesion = new javax.swing.JButton();
        jFondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBotonRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Regristro_PaginaInicial.png"))); // NOI18N
        jBotonRegistro.setBorder(null);
        jBotonRegistro.setBorderPainted(false);
        jBotonRegistro.setContentAreaFilled(false);
        jBotonRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonRegistro.setFocusable(false);
        jBotonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonRegistroActionPerformed(evt);
            }
        });
        add(jBotonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 580, 530, -1));

        jBotonIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_IniciarSesion_PaginaInicial.png"))); // NOI18N
        jBotonIniciarSesion.setBorder(null);
        jBotonIniciarSesion.setBorderPainted(false);
        jBotonIniciarSesion.setContentAreaFilled(false);
        jBotonIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBotonIniciarSesion.setFocusable(false);
        jBotonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonIniciarSesionActionPerformed(evt);
            }
        });
        add(jBotonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 350, 530, 130));

        jFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_PaginaInicial.png"))); // NOI18N
        add(jFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonIniciarSesionActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaIniciarSesionPanel());
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonIniciarSesionActionPerformed

    private void jBotonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonRegistroActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaRegistroPanel());
        marco.setVisible(true);
    }//GEN-LAST:event_jBotonRegistroActionPerformed
                                             

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonIniciarSesion;
    private javax.swing.JButton jBotonRegistro;
    private javax.swing.JLabel jFondo;
    // End of variables declaration//GEN-END:variables
}
