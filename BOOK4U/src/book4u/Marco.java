package book4u;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Marco extends JFrame{
    PaginaInicial laminal;
    Dimension screenSize;
    
    Marco() {
        
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();//poner la pantalla al maximo
        setSize(screenSize);
        setResizable(false);//No poder modificar el tamaño (false)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fin del programa al pulsar la X de cerrar.
        setTitle("BOOK4U"); //titulo del marco.
        laminal = new PaginaInicial();
        add(laminal);
        setVisible(true);
    }
}
