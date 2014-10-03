
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ruxaxup
 */
public class MainFrame extends JFrame implements ActionListener{
    private int w_width, w_height;
    public static JTextArea out;
    private JButton bStart;
    private JTextField tfElement;
    
    
    private Grafo G;
    
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
        out = new JTextArea();
        out.setEditable(false);
        Font fOut = new Font("Arial", Font.PLAIN, 20);
        out.setFont(fOut);
        JScrollPane spOut = new JScrollPane(
        		out, 
        		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //Creacion componentes
        bStart = new JButton("Start");
        bStart.addActionListener(this);
        
        //--Panel Buscar
        JPanel panelBuscar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tfElement = new JTextField(5);
        tfElement.setText("A");
        tfElement.addKeyListener(new LimitadorCaracter(tfElement, 1));
        panelBuscar.add(new JLabel("Elemento a buscar:"));
        panelBuscar.add(tfElement);
        panelBuscar.add(bStart);
        
        //Colocacion de componentes
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 3;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 3;
        gbc.weighty = 3;
        //Agregamos la salida
        add(spOut, gbc);
        
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        //Agregamos el panel de busqueda
        add(panelBuscar,gbc);
           
    }
    
    private void creaGrafo(){
    	G = new Grafo();
    	//CREAMOS LOS NODOS
		G.addNodo(new Nodo('A'));
		G.addNodo(new Nodo('B'));
		G.addNodo(new Nodo('C'));
		G.addNodo(new Nodo('D'));
		G.addNodo(new Nodo('E'));
		G.addNodo(new Nodo('F'));
		G.addNodo(new Nodo('G'));
		G.addNodo(new Nodo('H'));
		G.addNodo(new Nodo('I'));
		G.addNodo(new Nodo('J'));
		G.addNodo(new Nodo('K'));
		
		//CREAMOS LOS ENLACES
		G.createEdge('A', 'B');
		G.createEdge('A', 'C');
		G.createEdge('B', 'D');
		G.createEdge('B', 'E');
		G.createEdge('B', 'H');
		G.createEdge('C', 'F');
		G.createEdge('C', 'G');
		G.createEdge('C', 'I');
		G.createEdge('H', 'J');
		G.createEdge('I', 'K');
		
		//ESTABLECEMOS EL NODO RAIZ
		G.setRoot('A');
    }

    private void BFS(){
    	//BFS (BUSQUEDA EN AMPLITUD)
        Thread t = new Thread(new Runnable(){

            @Override
            public void run() {
                BFS bfs = new BFS(G);
                char elementoABuscar = tfElement.getText().charAt(0);
                if(bfs.buscar(elementoABuscar)){
                	out.append("\n**Se encontró: "+elementoABuscar);
                    /*JOptionPane.showMessageDialog(null,
                            "Si se encontro: "+elementoABuscar,
                            "Yeiiiih",
                            JOptionPane.INFORMATION_MESSAGE);*/
                    System.out.println("Si se encontro: "+elementoABuscar);
                }else{
                        System.out.println("No se encontro: "+elementoABuscar);
                        out.append("\n**No se encontró: "+elementoABuscar);
                        /*JOptionPane.showMessageDialog(null,
                            "No se encontro: "+elementoABuscar,
                            "Yeiiiih",
                            JOptionPane.INFORMATION_MESSAGE);*/
                }
            }
            
        });
        t.start();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bStart){
			out.setText("");
			if(tfElement.getText().isEmpty()){
				tfElement.setText("A");
			}
			creaGrafo();
			BFS();
		}
		
	}
}
