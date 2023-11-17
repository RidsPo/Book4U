package book4u;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PaginaRegistroPanel extends javax.swing.JPanel {
    
    private byte[] imageData;
    
    private boolean passwordVisible1 = false;
    private boolean passwordVisible2 = false;

    public PaginaRegistroPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIniciarSession = new javax.swing.JButton();
        jRegistrar = new javax.swing.JButton();
        jDNI = new javax.swing.JTextField();
        jNom = new javax.swing.JTextField();
        jDomicili = new javax.swing.JTextField();
        jNom_Usuari = new javax.swing.JTextField();
        jCorreu = new javax.swing.JTextField();
        jCognoms = new javax.swing.JTextField();
        jSelectFoto = new javax.swing.JButton();
        jContra = new javax.swing.JPasswordField();
        jRepetirContra = new javax.swing.JPasswordField();
        jMostrarEsconder1 = new javax.swing.JButton();
        jMostrarEsconder2 = new javax.swing.JButton();
        jFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jIniciarSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_IniciarSesion_PaginaRegistro1.png"))); // NOI18N
        jIniciarSession.setBorder(null);
        jIniciarSession.setBorderPainted(false);
        jIniciarSession.setContentAreaFilled(false);
        jIniciarSession.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jIniciarSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIniciarSessionActionPerformed(evt);
            }
        });
        add(jIniciarSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 930, -1, -1));

        jRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Boton_Registrar_PaginaRegistro2.png"))); // NOI18N
        jRegistrar.setBorder(null);
        jRegistrar.setBorderPainted(false);
        jRegistrar.setContentAreaFilled(false);
        jRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRegistrar.setFocusable(false);
        jRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistrarActionPerformed(evt);
            }
        });
        add(jRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 930, -1, -1));

        jDNI.setBackground(new java.awt.Color(184, 221, 140));
        jDNI.setBorder(null);
        add(jDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, 450, 30));

        jNom.setBackground(new java.awt.Color(184, 221, 140));
        jNom.setBorder(null);
        add(jNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 450, 30));

        jDomicili.setBackground(new java.awt.Color(184, 221, 140));
        jDomicili.setBorder(null);
        add(jDomicili, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 730, 450, 30));

        jNom_Usuari.setBackground(new java.awt.Color(184, 221, 140));
        jNom_Usuari.setBorder(null);
        jNom_Usuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNom_UsuariActionPerformed(evt);
            }
        });
        add(jNom_Usuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 850, 450, 30));

        jCorreu.setBackground(new java.awt.Color(184, 221, 140));
        jCorreu.setBorder(null);
        add(jCorreu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 470, 450, 30));

        jCognoms.setBackground(new java.awt.Color(184, 221, 140));
        jCognoms.setBorder(null);
        jCognoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCognomsActionPerformed(evt);
            }
        });
        add(jCognoms, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 450, 30));

        jSelectFoto.setBackground(new java.awt.Color(204, 204, 204));
        jSelectFoto.setText("Seleccionar imagen...");
        jSelectFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSelectFotoActionPerformed(evt);
            }
        });
        add(jSelectFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 830, 470, 60));

        jContra.setBackground(new java.awt.Color(184, 221, 140));
        jContra.setBorder(null);
        jContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jContraActionPerformed(evt);
            }
        });
        add(jContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 600, 400, 30));

        jRepetirContra.setBackground(new java.awt.Color(184, 221, 140));
        jRepetirContra.setBorder(null);
        jRepetirContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRepetirContraActionPerformed(evt);
            }
        });
        add(jRepetirContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 730, 400, 30));

        jMostrarEsconder1.setBackground(new java.awt.Color(184, 221, 140));
        jMostrarEsconder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        jMostrarEsconder1.setBorder(null);
        jMostrarEsconder1.setBorderPainted(false);
        jMostrarEsconder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMostrarEsconder1ActionPerformed(evt);
            }
        });
        add(jMostrarEsconder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 720, 50, 40));

        jMostrarEsconder2.setBackground(new java.awt.Color(184, 221, 140));
        jMostrarEsconder2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        jMostrarEsconder2.setBorder(null);
        jMostrarEsconder2.setBorderPainted(false);
        jMostrarEsconder2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMostrarEsconder2ActionPerformed(evt);
            }
        });
        add(jMostrarEsconder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 590, 50, 40));

        jFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PaginaRegistroFinal.png"))); // NOI18N
        add(jFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jIniciarSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIniciarSessionActionPerformed
         // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        marco.remove(this);
        marco.add(new PaginaIniciarSesionPanel());
        marco.setVisible(true);    
    }//GEN-LAST:event_jIniciarSessionActionPerformed

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

    private void jMostrarEsconder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMostrarEsconder1ActionPerformed
        // TODO add your handling code here:
        passwordVisible2 = !passwordVisible2;
        
        if (passwordVisible2) {
            jRepetirContra.setEchoChar((char) 0); // Mostrar la contraseña
        } else {
            jRepetirContra.setEchoChar('*'); // Ocultar la contraseña con asteriscos
        }
    }//GEN-LAST:event_jMostrarEsconder1ActionPerformed

    private void jMostrarEsconder2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMostrarEsconder2ActionPerformed
        // TODO add your handling code here:
       passwordVisible1 = !passwordVisible1;
       
        if (passwordVisible1) {
            jContra.setEchoChar((char) 0); // Mostrar la contraseña
        } else {
            jContra.setEchoChar('*'); // Ocultar la contraseña con asteriscos
        }
    }//GEN-LAST:event_jMostrarEsconder2ActionPerformed

    private void jCognomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCognomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCognomsActionPerformed

    private void jNom_UsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNom_UsuariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNom_UsuariActionPerformed

    private void jContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jContraActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jContraActionPerformed

    private void jRepetirContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRepetirContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRepetirContraActionPerformed

    private void jRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistrarActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        if (jNom.getText().isEmpty() && jCognoms.getText().isEmpty() && jDNI.getText().isEmpty() && jDomicili.getText().isEmpty() && jNom_Usuari.getText().isEmpty() && jCorreu.getText().isEmpty() && jContra.getText().isEmpty() && jContra.getText().isEmpty() && imageData == null) {
            JOptionPane.showMessageDialog(jRegistrar, "Todos los campos estan vacios!");
        } else if (jNom.getText().isEmpty() || jCognoms.getText().isEmpty() || jDNI.getText().isEmpty() || jDomicili.getText().isEmpty() || jNom_Usuari.getText().isEmpty() || jCorreu.getText().isEmpty() || jContra.getText().isEmpty() || jContra.getText().isEmpty() || imageData == null) {
            JOptionPane.showMessageDialog(jRegistrar, "Rellena los campos vacios!");
        } else {
            String nom = jNom.getText();
            String cognoms = jCognoms.getText();
            String DNI = jDNI.getText();
            String domicili = jDomicili.getText();
            String nomUsuari = jNom_Usuari.getText();
            String correu = jCorreu.getText();
            String contra = jContra.getText();

            if(imageData != null){
                
                Usuarios informacion = new Usuarios(imageData, nomUsuari, cognoms, DNI, domicili, correu, contra, nom);

                informacion.makeConnection();
                informacion.insertWithStatement();

                marco.remove(this);
                marco.add(new PaginaIniciarSesionPanel());
                marco.setVisible(true);
            }
        }  
    }//GEN-LAST:event_jRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jCognoms;
    private javax.swing.JPasswordField jContra;
    private javax.swing.JTextField jCorreu;
    private javax.swing.JTextField jDNI;
    private javax.swing.JTextField jDomicili;
    private javax.swing.JLabel jFondo;
    private javax.swing.JButton jIniciarSession;
    private javax.swing.JButton jMostrarEsconder1;
    private javax.swing.JButton jMostrarEsconder2;
    private javax.swing.JTextField jNom;
    private javax.swing.JTextField jNom_Usuari;
    private javax.swing.JButton jRegistrar;
    private javax.swing.JPasswordField jRepetirContra;
    private javax.swing.JButton jSelectFoto;
    // End of variables declaration//GEN-END:variables
}
