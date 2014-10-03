import java.util.Vector;


public class Nodo {
	private char c;
	private Vector<Nodo> adyacentes;
	
	public Nodo(char c){
		this.c = c;
		adyacentes = new Vector<>();
	}
	
	public void addAdyacente(Nodo n){
		adyacentes.add(n);
	}
	
	public Vector<Nodo> getAdyacentes(){
		return adyacentes;
	}
	
	public char getC(){
		return c;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Nodo){
			Nodo n = (Nodo)obj;
			return n.getC() == this.c; 
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+c;
	}
	
}
