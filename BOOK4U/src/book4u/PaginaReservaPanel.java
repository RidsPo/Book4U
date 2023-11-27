package book4u;

import com.toedter.calendar.JCalendar;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaginaReservaPanel extends javax.swing.JPanel {

    
    PaginaPerfilUsuario infousuario = null;
    
    private byte[] imageData;
    
    protected int id;
    protected byte[] foto;
    protected String nom_usuari;
    protected String cognom;
    protected String DNI;
    protected String domicili;
    protected String correu;
    protected String contra;
    protected String nom;   
    
    private byte[] imageData2;
        
    protected int id_residencia;
    protected byte[] foto_residencia;
    protected String nombre_residencia;
    protected String direccion_residencia;
    protected int precio_residencia;
    protected int ocupado_residencia;
    protected String precioFinal;
    
    protected String credits;
    
    private List<Residencias> listaResidencias;
    private int indiceActual = 0;
    
    private JCalendar calendarioInicio;
    private JCalendar calendarioFin;
    private JFrame frame;
    
    public PaginaReservaPanel(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
       super();
       
       /*Parte para la informaciónd el usuario*/
       
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
        
        /**/
        
        /*Parte para la información de la residencia*/
        Residencias residencias = new Residencias();

        listaResidencias = new ArrayList<>();
        
        listaResidencias = residencias.selectWithStatement();
        
        if(listaResidencias.size() >= 3){
            Residencias residencia1 = listaResidencias.get(0);
            
            ImageIcon originalIcon1 = new ImageIcon(residencia1.getFotoResidencia());
        
            Image originalImage1 = originalIcon1.getImage();
        
            Image resizedImage1 = originalImage1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage1 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d1 = roundedImage1.createGraphics();

            g2d1.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d1.drawImage(resizedImage1, 0, 0, null);

            g2d1.dispose();
        
            ImageIcon finalIcon1 = new ImageIcon(resizedImage1);
        
            Foto.setIcon(finalIcon1);
            
            Info.setText(residencia1.getNombre() + " en: " + residencia1.getDireccion());
            Precio.setText(String.valueOf(residencia1.getPrecio()));
            
            if(residencia1.getOcupado() == 0){
                BotonCrearReserva.setVisible(true);
                MensajeOcupado.setVisible(false);
            } else if (residencia1.getOcupado() == 1) {
                BotonCrearReserva.setVisible(false);
                MensajeOcupado.setVisible(true);
            }
            
            Residencias residencia2 = listaResidencias.get(1);
            
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
            }
        }

        /**/
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

        MensajeOcupado = new javax.swing.JLabel();
        MensajeOcupado1 = new javax.swing.JLabel();
        MensajeOcupado2 = new javax.swing.JLabel();
        BotonMisReservas = new javax.swing.JButton();
        BotonPaginaPrincipal = new javax.swing.JButton();
        BotonHistorial = new javax.swing.JButton();
        BotonUsuario = new javax.swing.JButton();
        BotonCrearReserva = new javax.swing.JButton();
        BotonCrearReserva1 = new javax.swing.JButton();
        BotonCrearReserva2 = new javax.swing.JButton();
        Foto = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Info = new javax.swing.JTextField();
        Precio = new javax.swing.JTextField();
        Foto1 = new javax.swing.JLabel();
        Info1 = new javax.swing.JTextField();
        Precio1 = new javax.swing.JTextField();
        Foto2 = new javax.swing.JLabel();
        Info2 = new javax.swing.JTextField();
        Precio2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MensajeOcupado.setBackground(new java.awt.Color(255, 102, 102));
        MensajeOcupado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MensajeOcupado.setForeground(new java.awt.Color(153, 0, 0));
        MensajeOcupado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MensajeOcupado.setText("RESIDENCIA YA RESERVADA");
        MensajeOcupado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        MensajeOcupado.setFocusable(false);
        MensajeOcupado.setOpaque(true);
        add(MensajeOcupado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 400, 240, 110));

        MensajeOcupado1.setBackground(new java.awt.Color(255, 102, 102));
        MensajeOcupado1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MensajeOcupado1.setForeground(new java.awt.Color(153, 0, 0));
        MensajeOcupado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MensajeOcupado1.setText("RESIDENCIA YA RESERVADA");
        MensajeOcupado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        MensajeOcupado1.setFocusable(false);
        MensajeOcupado1.setOpaque(true);
        add(MensajeOcupado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 640, 240, 110));

        MensajeOcupado2.setBackground(new java.awt.Color(255, 102, 102));
        MensajeOcupado2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MensajeOcupado2.setForeground(new java.awt.Color(153, 0, 0));
        MensajeOcupado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MensajeOcupado2.setText("RESIDENCIA YA RESERVADA");
        MensajeOcupado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        MensajeOcupado2.setFocusable(false);
        MensajeOcupado2.setOpaque(true);
        add(MensajeOcupado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 880, 240, 110));

        BotonMisReservas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonMisReservas.setBorder(null);
        BotonMisReservas.setBorderPainted(false);
        BotonMisReservas.setContentAreaFilled(false);
        BotonMisReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonMisReservas.setFocusable(false);
        BotonMisReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMisReservasActionPerformed(evt);
            }
        });
        add(BotonMisReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 290, 100));

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
        add(BotonPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 240, 100));

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
        add(BotonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 220, 100));

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

        BotonCrearReserva.setBorder(null);
        BotonCrearReserva.setBorderPainted(false);
        BotonCrearReserva.setContentAreaFilled(false);
        BotonCrearReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCrearReserva.setFocusable(false);
        BotonCrearReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearReservaActionPerformed(evt);
            }
        });
        add(BotonCrearReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 410, 220, 100));

        BotonCrearReserva1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reserva.png"))); // NOI18N
        BotonCrearReserva1.setBorder(null);
        BotonCrearReserva1.setBorderPainted(false);
        BotonCrearReserva1.setContentAreaFilled(false);
        BotonCrearReserva1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCrearReserva1.setFocusable(false);
        BotonCrearReserva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearReserva1ActionPerformed(evt);
            }
        });
        add(BotonCrearReserva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 640, 220, 100));

        BotonCrearReserva2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reserva.png"))); // NOI18N
        BotonCrearReserva2.setBorder(null);
        BotonCrearReserva2.setBorderPainted(false);
        BotonCrearReserva2.setContentAreaFilled(false);
        BotonCrearReserva2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCrearReserva2.setFocusable(false);
        BotonCrearReserva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearReserva2ActionPerformed(evt);
            }
        });
        add(BotonCrearReserva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 880, 220, 100));
        add(Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 200, 180));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("adkjfadahkfds");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.setFocusable(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 50, 180, 80));

        Info.setBackground(new java.awt.Color(204, 204, 204));
        Info.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info.setText("ejemplo");
        Info.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info.setFocusable(false);
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });
        add(Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 530, 180));

        Precio.setBackground(new java.awt.Color(204, 204, 204));
        Precio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio.setText("ejemplo");
        Precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio.setFocusable(false);
        add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1301, 422, 140, 70));
        add(Foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 200, 180));

        Info1.setBackground(new java.awt.Color(204, 204, 204));
        Info1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info1.setText("ejemplo");
        Info1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info1.setFocusable(false);
        Info1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Info1ActionPerformed(evt);
            }
        });
        add(Info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 610, 530, 180));

        Precio1.setBackground(new java.awt.Color(204, 204, 204));
        Precio1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio1.setText("ejemplo");
        Precio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio1.setFocusable(false);
        add(Precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 660, 140, 70));
        add(Foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 840, 200, 180));

        Info2.setBackground(new java.awt.Color(204, 204, 204));
        Info2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info2.setText("ejemplo");
        Info2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info2.setFocusable(false);
        Info2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Info2ActionPerformed(evt);
            }
        });
        add(Info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 840, 530, 180));

        Precio2.setBackground(new java.awt.Color(204, 204, 204));
        Precio2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio2.setText("ejemplo");
        Precio2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio2.setFocusable(false);
        add(Precio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 900, 140, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Line 2.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 810, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Line 2.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PaginaReserva (1).png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonMisReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMisReservasActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaMevesReservesPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonMisReservasActionPerformed

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
            
            this.infousuario = new PaginaPerfilUsuario (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom);
            
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

    private void BotonCrearReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearReservaActionPerformed
        // TODO add your handling code here:
        frame = new JFrame("Seleccionar Fechas");
        JPanel panel = new JPanel();
        Residencias residencia1 = listaResidencias.get(0);

        calendarioInicio = new JCalendar();
        JButton botonFechaInicio = new JButton("Elegir Fecha de Inicio");
        botonFechaInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCalendario(calendarioInicio);
            }
        });

        calendarioFin = new JCalendar();
        JButton botonFechaFin = new JButton("Elegir Fecha de Fin");
        botonFechaFin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCalendario(calendarioFin);
            }
        });

        JButton botonEnviar = new JButton("CONFIRMAR");
        botonEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.valueOf(credits) - residencia1.getPrecio() < 0){
                    JOptionPane.showMessageDialog(botonEnviar, "No tens prou crèdits.");
                    frame.dispose(); // Cerrar el pop-up después de enviar a la base de datos
                } else {
                    int resta = Integer.valueOf(credits) - residencia1.getPrecio();
                    enviarReservaABaseDeDatos(residencia1.getId(), id, residencia1.getPrecio(),calendarioInicio.getDate(), calendarioFin.getDate(), resta);
                    frame.dispose(); // Cerrar el pop-up después de enviar a la base de datos
                }
            }
        });

        panel.add(botonFechaInicio);
        panel.add(botonFechaFin);
        panel.add(botonEnviar); // Agregar el botón "Enviar a la Base de Datos"

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_BotonCrearReservaActionPerformed

    private void BotonCrearReserva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearReserva1ActionPerformed
        // TODO add your handling code here:
        
        frame = new JFrame("Seleccionar Fechas");
        JPanel panel = new JPanel();
        Residencias residencia2 = listaResidencias.get(1);

        calendarioInicio = new JCalendar();
        JButton botonFechaInicio = new JButton("Elegir Fecha de Inicio");
        botonFechaInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCalendario(calendarioInicio);
            }
        });

        calendarioFin = new JCalendar();
        JButton botonFechaFin = new JButton("Elegir Fecha de Fin");
        botonFechaFin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCalendario(calendarioFin);
            }
        });

        JButton botonEnviar = new JButton("CONFIRMAR");
        botonEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.valueOf(credits) - residencia2.getPrecio() < 0){
                    JOptionPane.showMessageDialog(botonEnviar, "No tens prou crèdits.");
                    frame.dispose(); // Cerrar el pop-up después de enviar a la base de datos
                } else {
                    int resta = Integer.valueOf(credits) - residencia2.getPrecio();
                    enviarReservaABaseDeDatos(residencia2.getId(), id, residencia2.getPrecio(),calendarioInicio.getDate(), calendarioFin.getDate(), resta);
                    frame.dispose(); // Cerrar el pop-up después de enviar a la base de datos
                }                
            }
        });

        panel.add(botonFechaInicio);
        panel.add(botonFechaFin);
        panel.add(botonEnviar); // Agregar el botón "Enviar a la Base de Datos"

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_BotonCrearReserva1ActionPerformed

    private void BotonCrearReserva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearReserva2ActionPerformed
        // TODO add your handling code here:
        frame = new JFrame("Seleccionar Fechas");
        JPanel panel = new JPanel();
        Residencias residencia3 = listaResidencias.get(3);

        calendarioInicio = new JCalendar();
        JButton botonFechaInicio = new JButton("Elegir Fecha de Inicio");
        botonFechaInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCalendario(calendarioInicio);
            }
        });

        calendarioFin = new JCalendar();
        JButton botonFechaFin = new JButton("Elegir Fecha de Fin");
        botonFechaFin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCalendario(calendarioFin);
            }
        });

        JButton botonEnviar = new JButton("CONFIRMAR");
        botonEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.valueOf(credits) - residencia3.getPrecio() < 0){
                    JOptionPane.showMessageDialog(botonEnviar, "No tens prou crèdits.");
                    frame.dispose(); // Cerrar el pop-up después de enviar a la base de datos
                } else {
                    int resta = Integer.valueOf(credits) - residencia3.getPrecio();
                    enviarReservaABaseDeDatos(residencia3.getId(), id, residencia3.getPrecio(),calendarioInicio.getDate(), calendarioFin.getDate(), resta);
                    frame.dispose(); // Cerrar el pop-up después de enviar a la base de datos
                } 
            }
        });

        panel.add(botonFechaInicio);
        panel.add(botonFechaFin);
        panel.add(botonEnviar); // Agregar el botón "Enviar a la Base de Datos"

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_BotonCrearReserva2ActionPerformed
   
    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InfoActionPerformed

    private void Info1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Info1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Info1ActionPerformed

    private void Info2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Info2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Info2ActionPerformed
    
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
    
    private void mostrarCalendario(final JCalendar calendario) {
        final JFrame frameCalendario = new JFrame("Calendario");
        JPanel panelCalendario = new JPanel();
        panelCalendario.add(calendario);

        calendario.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                frameCalendario.dispose(); // Cierra el calendario al seleccionar una fecha
            }   
        });

        frameCalendario.add(panelCalendario);
        frameCalendario.pack();
        frameCalendario.setVisible(true);
    }
    
    private void enviarReservaABaseDeDatos(int id_residencia, int id_usuari, int precio, Date fechaInicio, Date fechaFin, int resta) {
        
        Reserves reservas = new Reserves(id_residencia, id_usuari, precio, fechaInicio, fechaFin, resta);
        reservas.insertWithStatement();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCrearReserva;
    private javax.swing.JButton BotonCrearReserva1;
    private javax.swing.JButton BotonCrearReserva2;
    private javax.swing.JButton BotonHistorial;
    private javax.swing.JButton BotonMisReservas;
    private javax.swing.JButton BotonPaginaPrincipal;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel Foto1;
    private javax.swing.JLabel Foto2;
    private javax.swing.JTextField Info;
    private javax.swing.JTextField Info1;
    private javax.swing.JTextField Info2;
    private javax.swing.JLabel MensajeOcupado;
    private javax.swing.JLabel MensajeOcupado1;
    private javax.swing.JLabel MensajeOcupado2;
    private javax.swing.JTextField Precio;
    private javax.swing.JTextField Precio1;
    private javax.swing.JTextField Precio2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
