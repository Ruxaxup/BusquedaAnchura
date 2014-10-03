
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ruxaxup
 */
public class MainFrame extends JFrame{
    private int w_width, w_height;
    public static JLabel out;
    public MainFrame(){
        super("Busqueda en Anchura");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack();
    }

    private void initComponents() {
        //Colocacion y definicion de tamaño
        Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize(); 
        w_width = 300;
        w_height = 200;
        setPreferredSize(new Dimension(w_width,w_height));
        setLocation((windowDimension.width / 2) - (w_width/2),
                    (windowDimension.height / 2) - (w_height/2));
        
        //Creacion de la salida
        out = new JLabel("Hola");
        Font fOut = new Font("Arial", Font.PLAIN, 20);
        out.setFont(fOut);
        add(out);
        
    }
}
