/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package book4u;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author xavic
 */
public class PaginaRegistro2Panel extends javax.swing.JPanel {
private boolean passwordVisible1 = false;
private boolean passwordVisible2 = false;
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
        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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

        jTextField1.setBackground(new java.awt.Color(184, 221, 140));
        jTextField1.setBorder(null);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 440, 30));

        jTextField5.setBackground(new java.awt.Color(184, 221, 140));
        jTextField5.setBorder(null);
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 440, 30));

        jPasswordField2.setBackground(new java.awt.Color(184, 221, 140));
        jPasswordField2.setBorder(null);
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 692, 360, 30));

        jPasswordField1.setBackground(new java.awt.Color(184, 221, 140));
        jPasswordField1.setBorder(null);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, 360, 30));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Seleccionar imagen...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 810, 460, 50));

        jButton2.setBackground(new java.awt.Color(184, 221, 140));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 690, 40, 40));

        jButton3.setBackground(new java.awt.Color(184, 221, 140));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 560, 40, 40));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        if(jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         passwordVisible2 = !passwordVisible2;
    if (passwordVisible2) {
        jPasswordField2.setEchoChar((char) 0); // Mostrar la contraseña
    } else {
        jPasswordField2.setEchoChar('*'); // Ocultar la contraseña con asteriscos
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
     passwordVisible1 = !passwordVisible1;
    if (passwordVisible1) {
        jPasswordField1.setEchoChar((char) 0); // Mostrar la contraseña
    } else {
        jPasswordField1.setEchoChar('*'); // Ocultar la contraseña con asteriscos
    }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonRegistrar;
    private javax.swing.JButton jBotonVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jFondo;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
