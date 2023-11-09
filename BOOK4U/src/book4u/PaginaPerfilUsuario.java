/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package book4u;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Daniel
 */
public class PaginaPerfilUsuario extends javax.swing.JPanel {

    /**
     * Creates new form PaginaPerfilUsuario
     */
    public PaginaPerfilUsuario() {
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

        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setBackground(new java.awt.Color(184, 221, 140));
        jTextField2.setBorder(null);
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 680, 210, 30));

        jTextField3.setBackground(new java.awt.Color(184, 221, 140));
        jTextField3.setBorder(null);
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 540, 220, 30));

        jTextField4.setBackground(new java.awt.Color(184, 221, 140));
        jTextField4.setBorder(null);
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 400, 220, 30));

        jTextField5.setBackground(new java.awt.Color(184, 221, 140));
        jTextField5.setBorder(null);
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 400, 220, 30));

        jTextField6.setBackground(new java.awt.Color(184, 221, 140));
        jTextField6.setBorder(null);
        add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 540, 210, 30));

        jTextField7.setBackground(new java.awt.Color(184, 221, 140));
        jTextField7.setBorder(null);
        add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 710, 280, 30));

        jPasswordField1.setBackground(new java.awt.Color(184, 221, 140));
        jPasswordField1.setBorder(null);
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 690, 170, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 680, 40, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonIniciarSesion.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 800, 340, 100));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonComprarCreditos.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 800, 390, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paginaPerfilUsuario.png"))); // NOI18N
        jLabel1.setFocusable(false);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jLabel1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents
private boolean passwordVisible1 = false;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           passwordVisible1 = !passwordVisible1;
    if (passwordVisible1) {
        jPasswordField1.setEchoChar((char) 0); // Mostrar la contraseña
    } else {
        jPasswordField1.setEchoChar('*'); // Ocultar la contraseña con asteriscos
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel ());
        marco.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
    JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);

    // Panel personalizado con JTextField y JLabel organizados en un GridLayout
    JPanel panel = new JPanel(new GridLayout(3, 1));
    JLabel mensajeLabel = new JLabel("Quants crèdits vols comprar?");
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
        System.out.println("Comprar " + cantidadCreditos + " créditos");

        // Continúa con la lógica de cambio de panel si es necesario
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel());
        marco.setVisible(true);
    }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
