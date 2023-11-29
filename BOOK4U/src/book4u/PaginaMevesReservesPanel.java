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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaginaMevesReservesPanel extends javax.swing.JPanel {

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
    
    private List<Reserves> listaReserves;
    
    private JCalendar calendarioInicio;
    private JCalendar calendarioFin;
    private JFrame frame;
    
    public PaginaMevesReservesPanel(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
   
        listaReserves = new ArrayList<>();
        
        listaReserves = reserves.selectWithStatement();
                    
        if(listaReserves.size() == 1){
                
            Reserves reserva1 = listaReserves.get(0);            
             
            ImageIcon originalIcon1 = new ImageIcon(reserva1.getFoto());
        
            Image originalImage1 = originalIcon1.getImage();
        
            Image resizedImage1 = originalImage1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage1 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d1 = roundedImage1.createGraphics();

            g2d1.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d1.drawImage(resizedImage1, 0, 0, null);

            g2d1.dispose();
        
            ImageIcon finalIcon1 = new ImageIcon(resizedImage1);
        
            Foto1.setIcon(finalIcon1);
            
            Info1.setText(reserva1.getNombre() + " en: " + reserva1.getDireccion());
            Precio1.setText(String.valueOf(reserva1.getPrecio()));
            FechaInicio1.setText(String.valueOf(reserva1.getDataInici()));
            FechaFinal1.setText(String.valueOf(reserva1.getDataFi()));
                
            Foto2.setVisible(false);
            Foto3.setVisible(false);
            
            TituloInfo1.setVisible(false);
            TituloInfo2.setVisible(false);
            
            Info2.setVisible(false);
            Info3.setVisible(false);

            TituloPrecio1.setVisible(false);
            TituloPrecio2.setVisible(false);            
            
            Precio2.setVisible(false);
            Precio3.setVisible(false);
            
            TituloFechaInicio1.setVisible(false);
            TituloFechaInicio2.setVisible(false);
            
            FechaInicio2.setVisible(false);
            FechaInicio3.setVisible(false);
            
            TituloFechaFinal1.setVisible(false);
            TituloFechaFinal2.setVisible(false);            
            
            FechaFinal2.setVisible(false);
            FechaFinal3.setVisible(false);

            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            
        } else if(listaReserves.size() == 2){
            Reserves reserva1 = listaReserves.get(0);            

            Reserves reserva2 = listaReserves.get(1);            
             
            ImageIcon originalIcon1 = new ImageIcon(reserva1.getFoto());
        
            Image originalImage1 = originalIcon1.getImage();
        
            Image resizedImage1 = originalImage1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage1 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d1 = roundedImage1.createGraphics();

            g2d1.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d1.drawImage(resizedImage1, 0, 0, null);

            g2d1.dispose();
        
            ImageIcon finalIcon1 = new ImageIcon(resizedImage1);
        
            Foto1.setIcon(finalIcon1);
            
            ImageIcon originalIcon2 = new ImageIcon(reserva2.getFoto());
        
            Image originalImage2 = originalIcon2.getImage();
        
            Image resizedImage2 = originalImage2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage2 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d2 = roundedImage2.createGraphics();

            g2d2.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d2.drawImage(resizedImage2, 0, 0, null);

            g2d2.dispose();
        
            ImageIcon finalIcon2 = new ImageIcon(resizedImage2);
        
            Foto2.setIcon(finalIcon2);
                     
            Info1.setText(reserva1.getNombre() + " en: " + reserva1.getDireccion());
            Precio1.setText(String.valueOf(reserva1.getPrecio()));
            FechaInicio1.setText(String.valueOf(reserva1.getDataInici()));
            FechaFinal1.setText(String.valueOf(reserva1.getDataFi()));            
            
            Info2.setText(reserva2.getNombre() + " en: " + reserva2.getDireccion());
            Precio2.setText(String.valueOf(reserva2.getPrecio()));
            FechaInicio2.setText(String.valueOf(reserva2.getDataInici()));
            FechaFinal2.setText(String.valueOf(reserva2.getDataFi()));
                
            Foto2.setVisible(true);
            Foto3.setVisible(false);
            
            TituloInfo1.setVisible(true);
            TituloInfo2.setVisible(false);
            
            Info2.setVisible(true);
            Info3.setVisible(false);

            TituloPrecio1.setVisible(true);
            TituloPrecio2.setVisible(false);            
            
            Precio2.setVisible(true);
            Precio3.setVisible(false);
            
            TituloFechaInicio1.setVisible(true);
            TituloFechaInicio2.setVisible(false);
            
            FechaInicio2.setVisible(true);
            FechaInicio3.setVisible(false);
            
            TituloFechaFinal1.setVisible(true);
            TituloFechaFinal2.setVisible(false);            
            
            FechaFinal2.setVisible(true);
            FechaFinal3.setVisible(false);

            jLabel1.setVisible(true);
            jLabel2.setVisible(false);
            
            jButton1.setVisible(true);
            jButton2.setVisible(false);
            
        } else if (listaReserves.size() == 3) {
            
            Reserves reserva1 = listaReserves.get(0);            

            Reserves reserva2 = listaReserves.get(1);               
                
            Reserves reserva3 = listaReserves.get(2);           
             
            ImageIcon originalIcon1 = new ImageIcon(reserva1.getFoto());
        
            Image originalImage1 = originalIcon1.getImage();
        
            Image resizedImage1 = originalImage1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage1 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d1 = roundedImage1.createGraphics();

            g2d1.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d1.drawImage(resizedImage1, 0, 0, null);

            g2d1.dispose();
        
            ImageIcon finalIcon1 = new ImageIcon(resizedImage1);
        
            Foto1.setIcon(finalIcon1);
            
            ImageIcon originalIcon2 = new ImageIcon(reserva2.getFoto());
        
            Image originalImage2 = originalIcon2.getImage();
        
            Image resizedImage2 = originalImage2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage2 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d2 = roundedImage2.createGraphics();

            g2d2.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d2.drawImage(resizedImage2, 0, 0, null);

            g2d2.dispose();
        
            ImageIcon finalIcon2 = new ImageIcon(resizedImage2);
            
            Foto2.setIcon(finalIcon2);
   
            ImageIcon originalIcon3 = new ImageIcon(reserva3.getFoto());
        
            Image originalImage3 = originalIcon3.getImage();
        
            Image resizedImage3 = originalImage3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            BufferedImage roundedImage3 = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d3 = roundedImage3.createGraphics();

            g2d3.setClip(new Ellipse2D.Float(0, 0, 150, 150));

            g2d3.drawImage(resizedImage3, 0, 0, null);

            g2d3.dispose();
        
            ImageIcon finalIcon3 = new ImageIcon(resizedImage3);
        
            Foto3.setIcon(finalIcon3);           
            
            Info1.setText(reserva1.getNombre() + " en: " + reserva1.getDireccion());
            Precio1.setText(String.valueOf(reserva1.getPrecio()));
            FechaInicio1.setText(String.valueOf(reserva1.getDataInici()));
            FechaFinal1.setText(String.valueOf(reserva1.getDataFi()));            
            
            Info2.setText(reserva2.getNombre() + " en: " + reserva2.getDireccion());
            Precio2.setText(String.valueOf(reserva2.getPrecio()));
            FechaInicio2.setText(String.valueOf(reserva2.getDataInici()));
            FechaFinal2.setText(String.valueOf(reserva2.getDataFi()));            
            
            Info3.setText(reserva3.getNombre() + " en: " + reserva3.getDireccion());
            Precio3.setText(String.valueOf(reserva3.getPrecio()));
            FechaInicio3.setText(String.valueOf(reserva3.getDataInici()));
            FechaFinal3.setText(String.valueOf(reserva3.getDataFi()));
            
            Foto2.setVisible(true);
            Foto3.setVisible(true);
            
            TituloInfo1.setVisible(true);
            TituloInfo2.setVisible(true);
            
            Info2.setVisible(true);
            Info3.setVisible(true);

            TituloPrecio1.setVisible(true);
            TituloPrecio2.setVisible(true);            
            
            Precio2.setVisible(true);
            Precio3.setVisible(true);
            
            TituloFechaInicio1.setVisible(true);
            TituloFechaInicio2.setVisible(true);
            
            FechaInicio2.setVisible(true);
            FechaInicio3.setVisible(true);
            
            TituloFechaFinal1.setVisible(true);
            TituloFechaFinal2.setVisible(true);            
            
            FechaFinal2.setVisible(true);
            FechaFinal3.setVisible(true);

            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            
            jButton1.setVisible(true);
            jButton2.setVisible(true);
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonNuevaReserva = new javax.swing.JButton();
        BotonPaginaPrincipal = new javax.swing.JButton();
        BotonHistorial = new javax.swing.JButton();
        BotonUsuario = new javax.swing.JButton();
        BotonModificarReserva = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        Foto1 = new javax.swing.JLabel();
        TituloInfo = new javax.swing.JTextField();
        Info1 = new javax.swing.JTextField();
        TituloPrecio = new javax.swing.JTextField();
        Precio1 = new javax.swing.JTextField();
        TituloFechaInicio = new javax.swing.JTextField();
        FechaInicio1 = new javax.swing.JTextField();
        TituloFechaFinal = new javax.swing.JTextField();
        FechaFinal1 = new javax.swing.JTextField();
        Foto2 = new javax.swing.JLabel();
        TituloInfo1 = new javax.swing.JTextField();
        Info2 = new javax.swing.JTextField();
        TituloPrecio1 = new javax.swing.JTextField();
        Precio2 = new javax.swing.JTextField();
        Foto3 = new javax.swing.JLabel();
        TituloInfo2 = new javax.swing.JTextField();
        TituloFechaInicio1 = new javax.swing.JTextField();
        FechaInicio2 = new javax.swing.JTextField();
        TituloFechaFinal1 = new javax.swing.JTextField();
        FechaFinal2 = new javax.swing.JTextField();
        Info3 = new javax.swing.JTextField();
        TituloPrecio2 = new javax.swing.JTextField();
        Precio3 = new javax.swing.JTextField();
        TituloFechaInicio2 = new javax.swing.JTextField();
        FechaInicio3 = new javax.swing.JTextField();
        TituloFechaFinal2 = new javax.swing.JTextField();
        FechaFinal3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonNuevaReserva.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonNuevaReserva.setBorder(null);
        BotonNuevaReserva.setBorderPainted(false);
        BotonNuevaReserva.setContentAreaFilled(false);
        BotonNuevaReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonNuevaReserva.setFocusable(false);
        BotonNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevaReservaActionPerformed(evt);
            }
        });
        add(BotonNuevaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 220, 100));

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
        add(BotonPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 240, 90));

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
        add(BotonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 220, 100));

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

        BotonModificarReserva.setBorder(null);
        BotonModificarReserva.setBorderPainted(false);
        BotonModificarReserva.setContentAreaFilled(false);
        BotonModificarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonModificarReserva.setFocusable(false);
        BotonModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarReservaActionPerformed(evt);
            }
        });
        add(BotonModificarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 410, 260, 90));

        jButton1.setText("jButton1");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 660, -1, -1));

        jButton2.setText("jButton1");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 880, -1, -1));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("adadaasasdasd");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.setFocusable(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 50, 180, 80));
        add(Foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 200, 180));

        TituloInfo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloInfo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloInfo.setText("INFORMACIÓ:");
        TituloInfo.setBorder(null);
        TituloInfo.setFocusable(false);
        add(TituloInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 130, -1));

        Info1.setBackground(new java.awt.Color(204, 204, 204));
        Info1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info1.setFocusable(false);
        add(Info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 530, 90));

        TituloPrecio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloPrecio.setText("PREU:");
        TituloPrecio.setBorder(null);
        TituloPrecio.setFocusable(false);
        add(TituloPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, 60, -1));

        Precio1.setBackground(new java.awt.Color(204, 204, 204));
        Precio1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio1.setFocusable(false);
        add(Precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 420, 140, 70));

        TituloFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloFechaInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloFechaInicio.setText("DATA INICI:");
        TituloFechaInicio.setBorder(null);
        TituloFechaInicio.setFocusable(false);
        add(TituloFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1184, 380, 110, -1));

        FechaInicio1.setBackground(new java.awt.Color(204, 204, 204));
        FechaInicio1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FechaInicio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaInicio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaInicio1.setFocusable(false);
        add(FechaInicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 420, 140, 70));

        TituloFechaFinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloFechaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloFechaFinal.setText("DATA FINAL:");
        TituloFechaFinal.setBorder(null);
        TituloFechaFinal.setFocusable(false);
        add(TituloFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1335, 380, 120, -1));

        FechaFinal1.setBackground(new java.awt.Color(204, 204, 204));
        FechaFinal1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FechaFinal1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaFinal1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaFinal1.setFocusable(false);
        add(FechaFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 420, 140, 70));
        add(Foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 200, 180));

        TituloInfo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloInfo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloInfo1.setText("INFORMACIÓ:");
        TituloInfo1.setBorder(null);
        TituloInfo1.setFocusable(false);
        add(TituloInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, 130, -1));

        Info2.setBackground(new java.awt.Color(204, 204, 204));
        Info2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info2.setFocusable(false);
        add(Info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 630, 530, 90));

        TituloPrecio1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloPrecio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloPrecio1.setText("PREU:");
        TituloPrecio1.setBorder(null);
        TituloPrecio1.setFocusable(false);
        add(TituloPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 600, 60, -1));

        Precio2.setBackground(new java.awt.Color(204, 204, 204));
        Precio2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio2.setFocusable(false);
        add(Precio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 640, 140, 70));
        add(Foto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 810, 200, 180));

        TituloInfo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloInfo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloInfo2.setText("INFORMACIÓ:");
        TituloInfo2.setBorder(null);
        TituloInfo2.setFocusable(false);
        add(TituloInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 810, 130, -1));

        TituloFechaInicio1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloFechaInicio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloFechaInicio1.setText("DATA INICI:");
        TituloFechaInicio1.setBorder(null);
        TituloFechaInicio1.setFocusable(false);
        add(TituloFechaInicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1185, 600, 110, -1));

        FechaInicio2.setBackground(new java.awt.Color(204, 204, 204));
        FechaInicio2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FechaInicio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaInicio2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaInicio2.setFocusable(false);
        add(FechaInicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 640, 140, 70));

        TituloFechaFinal1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloFechaFinal1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloFechaFinal1.setText("DATA FINAL:");
        TituloFechaFinal1.setBorder(null);
        TituloFechaFinal1.setFocusable(false);
        add(TituloFechaFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 600, 120, -1));

        FechaFinal2.setBackground(new java.awt.Color(204, 204, 204));
        FechaFinal2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FechaFinal2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaFinal2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaFinal2.setFocusable(false);
        add(FechaFinal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 640, 140, 70));

        Info3.setBackground(new java.awt.Color(204, 204, 204));
        Info3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info3.setFocusable(false);
        add(Info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 850, 530, 90));

        TituloPrecio2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloPrecio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloPrecio2.setText("PREU:");
        TituloPrecio2.setBorder(null);
        TituloPrecio2.setFocusable(false);
        add(TituloPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 820, 60, -1));

        Precio3.setBackground(new java.awt.Color(204, 204, 204));
        Precio3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio3.setFocusable(false);
        add(Precio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 860, 140, 70));

        TituloFechaInicio2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloFechaInicio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloFechaInicio2.setText("DATA INICI:");
        TituloFechaInicio2.setBorder(null);
        TituloFechaInicio2.setFocusable(false);
        add(TituloFechaInicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1185, 820, 110, -1));

        FechaInicio3.setBackground(new java.awt.Color(204, 204, 204));
        FechaInicio3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FechaInicio3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaInicio3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaInicio3.setFocusable(false);
        add(FechaInicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 860, 140, 70));

        TituloFechaFinal2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloFechaFinal2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloFechaFinal2.setText("DATA FINAL:");
        TituloFechaFinal2.setBorder(null);
        TituloFechaFinal2.setFocusable(false);
        add(TituloFechaFinal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 820, 120, -1));

        FechaFinal3.setBackground(new java.awt.Color(204, 204, 204));
        FechaFinal3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        FechaFinal3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaFinal3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FechaFinal3.setFocusable(false);
        add(FechaFinal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 860, 140, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Line 2.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Line 2.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 770, -1, 10));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PaginaMevesReserves (1).png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaReservaActionPerformed
        // TODO add your handling code here:
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaReservaPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonNuevaReservaActionPerformed

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

    private void BotonModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarReservaActionPerformed
        // TODO add your handling code here:
               frame = new JFrame("Seleccionar Fechas");
        JPanel panel = new JPanel();
        Reserves reserva1 = listaReserves.get(0);

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
            
                  
                    enviarReservaABaseDeDatos(reserva1.getId(),calendarioInicio.getDate(), calendarioFin.getDate());
                    frame.dispose(); // Cerrar el pop-up después de enviar a la base de datos
                }
        });

        panel.add(botonFechaInicio);
        panel.add(botonFechaFin);
        panel.add(botonEnviar); // Agregar el botón "Enviar a la Base de Datos"

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_BotonModificarReservaActionPerformed
      private void enviarReservaABaseDeDatos(int id, Date fechaInicio, Date fechaFin) {
        
        Reserves reservas = new Reserves(id, fechaInicio, fechaFin);
        reservas.updateWithStatement();
        
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
    private javax.swing.JButton BotonHistorial;
    private javax.swing.JButton BotonModificarReserva;
    private javax.swing.JButton BotonNuevaReserva;
    private javax.swing.JButton BotonPaginaPrincipal;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JTextField FechaFinal1;
    private javax.swing.JTextField FechaFinal2;
    private javax.swing.JTextField FechaFinal3;
    private javax.swing.JTextField FechaInicio1;
    private javax.swing.JTextField FechaInicio2;
    private javax.swing.JTextField FechaInicio3;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Foto1;
    private javax.swing.JLabel Foto2;
    private javax.swing.JLabel Foto3;
    private javax.swing.JTextField Info1;
    private javax.swing.JTextField Info2;
    private javax.swing.JTextField Info3;
    private javax.swing.JTextField Precio1;
    private javax.swing.JTextField Precio2;
    private javax.swing.JTextField Precio3;
    private javax.swing.JTextField TituloFechaFinal;
    private javax.swing.JTextField TituloFechaFinal1;
    private javax.swing.JTextField TituloFechaFinal2;
    private javax.swing.JTextField TituloFechaInicio;
    private javax.swing.JTextField TituloFechaInicio1;
    private javax.swing.JTextField TituloFechaInicio2;
    private javax.swing.JTextField TituloInfo;
    private javax.swing.JTextField TituloInfo1;
    private javax.swing.JTextField TituloInfo2;
    private javax.swing.JTextField TituloPrecio;
    private javax.swing.JTextField TituloPrecio1;
    private javax.swing.JTextField TituloPrecio2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
