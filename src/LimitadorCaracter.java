import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;


public class LimitadorCaracter implements KeyListener{
	private int limite;
	private JTextField tfLimitado;
	
	public LimitadorCaracter(JTextField tfLimitado, int limite) {
		this.tfLimitado = tfLimitado;
		this.limite = limite;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(tfLimitado.getText().length() == limite){
			e.consume();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
