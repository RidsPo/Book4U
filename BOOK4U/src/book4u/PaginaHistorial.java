package book4u;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class PaginaHistorial extends javax.swing.JPanel {

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
    protected String dinero;
    
    List<Historial> reservasCaducadas;

    
    public PaginaHistorial(int id, byte[] foto, String nom_usuari, String cognom, String DNI, String domicili, String correu, String contra, String nom) {
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
                
        Historial historial = new Historial(id);
        
        reservasCaducadas = historial.selectWithStatement();
        
        if(reservasCaducadas.size() == 1){
                
            Historial reserva1 = reservasCaducadas.get(0);            
             
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
            Creditos1.setText(String.valueOf(reserva1.getPrecio()));
            Precio1.setText(String.valueOf(reserva1.getPrecio() / 10));
            
            Foto1.setVisible(true);    
            Foto2.setVisible(false);
            Foto3.setVisible(false);
            
            TituloInfo1.setVisible(true);
            TituloInfo2.setVisible(false);
            TituloInfo3.setVisible(false);
            
            Info1.setVisible(true);            
            Info2.setVisible(false);
            Info3.setVisible(false);

            TituloCreditos1.setVisible(true);
            TituloCreditos2.setVisible(false);            
            TituloCreditos3.setVisible(false);   
            
            Creditos1.setVisible(true);            
            Creditos2.setVisible(false);
            Creditos3.setVisible(false);
            
            
            TituloPrecio1.setVisible(true);
            TituloPrecio2.setVisible(false);            
            TituloPrecio3.setVisible(false);            

            Precio1.setVisible(true);            
            Precio2.setVisible(false);
            Precio3.setVisible(false);

            Linea1.setVisible(false);
            Linea2.setVisible(false);

            NullMensaje.setVisible(false);
            
        } else if(reservasCaducadas.size() == 2){
            Historial reserva1 = reservasCaducadas.get(0);            

            Historial reserva2 = reservasCaducadas.get(1);            
             
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
            Creditos1.setText(String.valueOf(reserva1.getPrecio()));
            Precio1.setText(String.valueOf(reserva1.getPrecio() / 10));
            
            Info2.setText(reserva2.getNombre() + " en: " + reserva2.getDireccion());
            Creditos2.setText(String.valueOf(reserva2.getPrecio()));
            Precio2.setText(String.valueOf(reserva2.getPrecio() / 10));
            
            Foto1.setVisible(true);    
            Foto2.setVisible(true);
            Foto3.setVisible(false);
            
            TituloInfo1.setVisible(true);
            TituloInfo2.setVisible(true);
            TituloInfo3.setVisible(false);
            
            Info1.setVisible(true);            
            Info2.setVisible(true);
            Info3.setVisible(false);

            TituloCreditos1.setVisible(true);
            TituloCreditos2.setVisible(true);            
            TituloCreditos3.setVisible(false);   
            
            Creditos1.setVisible(true);            
            Creditos2.setVisible(true);
            Creditos3.setVisible(false);
            
            
            TituloPrecio1.setVisible(true);
            TituloPrecio2.setVisible(true);            
            TituloPrecio3.setVisible(false);            

            Precio1.setVisible(true);            
            Precio2.setVisible(true);
            Precio3.setVisible(false);

            Linea1.setVisible(true);
            Linea2.setVisible(false);

            NullMensaje.setVisible(false);
            
        } else if (reservasCaducadas.size() == 3) {
            
            Historial reserva1 = reservasCaducadas.get(0);            

            Historial reserva2 = reservasCaducadas.get(1);               
                
            Historial reserva3 = reservasCaducadas.get(2);           
             
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
            Creditos1.setText(String.valueOf(reserva1.getPrecio()));
            Precio1.setText(String.valueOf(reserva1.getPrecio() / 10));
            
            Info2.setText(reserva2.getNombre() + " en: " + reserva2.getDireccion());
            Creditos2.setText(String.valueOf(reserva2.getPrecio()));
            Precio2.setText(String.valueOf(reserva2.getPrecio() / 10));
            
            Info3.setText(reserva3.getNombre() + " en: " + reserva3.getDireccion());
            Creditos3.setText(String.valueOf(reserva3.getPrecio()));
            Precio3.setText(String.valueOf(reserva3.getPrecio() / 10));
            
            Foto1.setVisible(true);    
            Foto2.setVisible(true);
            Foto3.setVisible(true);
            
            TituloInfo1.setVisible(true);
            TituloInfo2.setVisible(true);
            TituloInfo3.setVisible(true);
            
            Info1.setVisible(true);            
            Info2.setVisible(true);
            Info3.setVisible(true);

            TituloCreditos1.setVisible(true);
            TituloCreditos2.setVisible(true);            
            TituloCreditos3.setVisible(true);   
            
            Creditos1.setVisible(true);            
            Creditos2.setVisible(true);
            Creditos3.setVisible(true);
            
            
            TituloPrecio1.setVisible(true);
            TituloPrecio2.setVisible(true);            
            TituloPrecio3.setVisible(true);            

            Precio1.setVisible(true);            
            Precio2.setVisible(true);
            Precio3.setVisible(true);

            Linea1.setVisible(true);
            Linea2.setVisible(true);

            NullMensaje.setVisible(false);

        } else if (reservasCaducadas.size() == 0){
            
            Foto1.setVisible(false);    
            Foto2.setVisible(false);
            Foto3.setVisible(false);
            
            TituloInfo1.setVisible(false);
            TituloInfo2.setVisible(false);
            TituloInfo3.setVisible(false);
            
            Info1.setVisible(false);            
            Info2.setVisible(false);
            Info3.setVisible(false);

            TituloCreditos1.setVisible(false);
            TituloCreditos2.setVisible(false);            
            TituloCreditos3.setVisible(false);   
            
            Creditos1.setVisible(false);            
            Creditos2.setVisible(false);
            Creditos3.setVisible(false);
            
            
            TituloPrecio1.setVisible(false);
            TituloPrecio2.setVisible(false);            
            TituloPrecio3.setVisible(false);            

            Precio1.setVisible(false);            
            Precio2.setVisible(false);
            Precio3.setVisible(false);

            Linea1.setVisible(false);
            Linea2.setVisible(false);

            NullMensaje.setVisible(true);
        }    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NullMensaje = new javax.swing.JTextField();
        LesMevesReserves = new javax.swing.JButton();
        BotonPaginaPrincipal = new javax.swing.JButton();
        BotonNovaReserva = new javax.swing.JButton();
        BotonUsuario = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        Foto1 = new javax.swing.JLabel();
        TituloInfo1 = new javax.swing.JTextField();
        Info1 = new javax.swing.JTextField();
        TituloCreditos1 = new javax.swing.JTextField();
        Creditos1 = new javax.swing.JTextField();
        TituloPrecio1 = new javax.swing.JTextField();
        Precio1 = new javax.swing.JTextField();
        Foto2 = new javax.swing.JLabel();
        TituloInfo2 = new javax.swing.JTextField();
        Info2 = new javax.swing.JTextField();
        TituloCreditos2 = new javax.swing.JTextField();
        Creditos2 = new javax.swing.JTextField();
        TituloPrecio2 = new javax.swing.JTextField();
        Precio2 = new javax.swing.JTextField();
        Foto3 = new javax.swing.JLabel();
        TituloInfo3 = new javax.swing.JTextField();
        Info3 = new javax.swing.JTextField();
        TituloCreditos3 = new javax.swing.JTextField();
        Creditos3 = new javax.swing.JTextField();
        TituloPrecio3 = new javax.swing.JTextField();
        Precio3 = new javax.swing.JTextField();
        Linea1 = new javax.swing.JLabel();
        Linea2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NullMensaje.setBackground(new java.awt.Color(204, 204, 204));
        NullMensaje.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        NullMensaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NullMensaje.setText("NO TENS CAP RESERVA CADUCADA");
        NullMensaje.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(NullMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, 820, 110));

        LesMevesReserves.setBorder(null);
        LesMevesReserves.setBorderPainted(false);
        LesMevesReserves.setContentAreaFilled(false);
        LesMevesReserves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LesMevesReserves.setFocusable(false);
        LesMevesReserves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LesMevesReservesActionPerformed(evt);
            }
        });
        add(LesMevesReserves, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 290, 90));

        BotonPaginaPrincipal.setBorder(null);
        BotonPaginaPrincipal.setBorderPainted(false);
        BotonPaginaPrincipal.setContentAreaFilled(false);
        BotonPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPaginaPrincipal.setFocusable(false);
        BotonPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPaginaPrincipalActionPerformed(evt);
            }
        });
        add(BotonPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 230, 90));

        BotonNovaReserva.setBorder(null);
        BotonNovaReserva.setBorderPainted(false);
        BotonNovaReserva.setContentAreaFilled(false);
        BotonNovaReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonNovaReserva.setFocusable(false);
        BotonNovaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNovaReservaActionPerformed(evt);
            }
        });
        add(BotonNovaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 220, 90));

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
        add(BotonUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 30, -1, -1));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("adsasdasd");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.setFocusable(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 50, 180, 80));
        add(Foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 200, 180));

        TituloInfo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloInfo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloInfo1.setText("INFORMACIÓ:");
        TituloInfo1.setBorder(null);
        TituloInfo1.setFocusable(false);
        add(TituloInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 130, -1));

        Info1.setBackground(new java.awt.Color(204, 204, 204));
        Info1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info1.setFocusable(false);
        add(Info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 530, 90));

        TituloCreditos1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloCreditos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloCreditos1.setText("CRÈDITS:");
        TituloCreditos1.setBorder(null);
        add(TituloCreditos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1184, 380, 110, -1));

        Creditos1.setBackground(new java.awt.Color(204, 204, 204));
        Creditos1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Creditos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Creditos1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Creditos1.setFocusable(false);
        add(Creditos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 420, 140, 70));

        TituloPrecio1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloPrecio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloPrecio1.setText("EUROS:");
        TituloPrecio1.setBorder(null);
        TituloPrecio1.setFocusable(false);
        TituloPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloPrecio1ActionPerformed(evt);
            }
        });
        add(TituloPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1335, 380, 120, -1));

        Precio1.setBackground(new java.awt.Color(204, 204, 204));
        Precio1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio1.setFocusable(false);
        add(Precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 420, 140, 70));
        add(Foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 200, 180));

        TituloInfo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloInfo2.setText("INFORMACIÓ:");
        TituloInfo2.setBorder(null);
        TituloInfo2.setFocusable(false);
        add(TituloInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, 130, -1));

        Info2.setBackground(new java.awt.Color(204, 204, 204));
        Info2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info2.setFocusable(false);
        add(Info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 630, 530, 90));

        TituloCreditos2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloCreditos2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloCreditos2.setText("CRÈDITS:");
        TituloCreditos2.setBorder(null);
        add(TituloCreditos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1185, 600, 110, -1));

        Creditos2.setBackground(new java.awt.Color(204, 204, 204));
        Creditos2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Creditos2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Creditos2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Creditos2.setFocusable(false);
        add(Creditos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 640, 140, 70));

        TituloPrecio2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloPrecio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloPrecio2.setText("EUROS:");
        TituloPrecio2.setBorder(null);
        TituloPrecio2.setFocusable(false);
        TituloPrecio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloPrecio2ActionPerformed(evt);
            }
        });
        add(TituloPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 600, 120, -1));

        Precio2.setBackground(new java.awt.Color(204, 204, 204));
        Precio2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio2.setFocusable(false);
        add(Precio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 640, 140, 70));
        add(Foto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 810, 200, 180));

        TituloInfo3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloInfo3.setText("INFORMACIÓ:");
        TituloInfo3.setBorder(null);
        TituloInfo3.setFocusable(false);
        add(TituloInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 810, 130, -1));

        Info3.setBackground(new java.awt.Color(204, 204, 204));
        Info3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Info3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Info3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Info3.setFocusable(false);
        add(Info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 850, 530, 90));

        TituloCreditos3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloCreditos3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloCreditos3.setText("CRÈDITS:");
        TituloCreditos3.setBorder(null);
        add(TituloCreditos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1185, 820, 110, -1));

        Creditos3.setBackground(new java.awt.Color(204, 204, 204));
        Creditos3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Creditos3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Creditos3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Creditos3.setFocusable(false);
        add(Creditos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 860, 140, 70));

        TituloPrecio3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloPrecio3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TituloPrecio3.setText("EUROS:");
        TituloPrecio3.setBorder(null);
        TituloPrecio3.setFocusable(false);
        TituloPrecio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloPrecio3ActionPerformed(evt);
            }
        });
        add(TituloPrecio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 820, 120, -1));

        Precio3.setBackground(new java.awt.Color(204, 204, 204));
        Precio3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Precio3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Precio3.setFocusable(false);
        add(Precio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 860, 140, 70));

        Linea1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Line 2.png"))); // NOI18N
        add(Linea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, -1, -1));

        Linea2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Line 2.png"))); // NOI18N
        add(Linea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 770, -1, 10));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PaginaHistorial (2).png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void LesMevesReservesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LesMevesReservesActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaMevesReservesPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_LesMevesReservesActionPerformed

    private void BotonPaginaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPaginaPrincipalActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaPrincipalPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonPaginaPrincipalActionPerformed

    private void BotonNovaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNovaReservaActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PaginaReservaPanel (id, foto, nom_usuari, cognom, DNI, domicili, correu, contra, nom));
        marco.setVisible(true);
    }//GEN-LAST:event_BotonNovaReservaActionPerformed

    private void BotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuarioActionPerformed
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
    }//GEN-LAST:event_BotonUsuarioActionPerformed

    private void TituloPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloPrecio1ActionPerformed

    private void TituloPrecio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloPrecio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloPrecio2ActionPerformed

    private void TituloPrecio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloPrecio3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloPrecio3ActionPerformed

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
    private javax.swing.JButton BotonNovaReserva;
    private javax.swing.JButton BotonPaginaPrincipal;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JTextField Creditos1;
    private javax.swing.JTextField Creditos2;
    private javax.swing.JTextField Creditos3;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Foto1;
    private javax.swing.JLabel Foto2;
    private javax.swing.JLabel Foto3;
    private javax.swing.JTextField Info1;
    private javax.swing.JTextField Info2;
    private javax.swing.JTextField Info3;
    private javax.swing.JButton LesMevesReserves;
    private javax.swing.JLabel Linea1;
    private javax.swing.JLabel Linea2;
    private javax.swing.JTextField NullMensaje;
    private javax.swing.JTextField Precio1;
    private javax.swing.JTextField Precio2;
    private javax.swing.JTextField Precio3;
    private javax.swing.JTextField TituloCreditos1;
    private javax.swing.JTextField TituloCreditos2;
    private javax.swing.JTextField TituloCreditos3;
    private javax.swing.JTextField TituloInfo1;
    private javax.swing.JTextField TituloInfo2;
    private javax.swing.JTextField TituloInfo3;
    private javax.swing.JTextField TituloPrecio1;
    private javax.swing.JTextField TituloPrecio2;
    private javax.swing.JTextField TituloPrecio3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
