package GraphClasses;

import TreeClasses.NodoArbol;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Nodo {
	private char c;
	private List<Nodo> adyacentes;
	
	public Nodo(char c){
		this.c = c;
		adyacentes = new LinkedList<>();
	}
	
	public void addAdyacente(Nodo n){
		adyacentes.add(n);
	}
	
	public List<Nodo> getAdyacentes(){
		return adyacentes;
	}
	
	public char getC(){
		return c;
	}
	
	@Override
	public String toString() {
		return ""+c;
	}
	
}
