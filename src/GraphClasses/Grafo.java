package GraphClasses;

import GraphClasses.Nodo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Grafo {
	private Set<Nodo> nodos;
	private Nodo root;
	
	public Grafo(){
		nodos = new HashSet<>();
	}
	
	public void addNodo(Nodo n){
		if(n != null) nodos.add(n);
	}
	
	public Nodo getNodo(char c){
		Iterator<Nodo> i = nodos.iterator();
		while(i.hasNext()){
			Nodo n = i.next();
			if(n.getC() == c){
				return n;
			}
		}
		return null;
	}
	
	public void createEdge(char c1, char c2){
		Nodo n1 = getNodo(c1);
		Nodo n2 = getNodo(c2);
		
		n1.addAdyacente(n2);
		n2.addAdyacente(n1);
	}
	
	public void setRoot(char c){
		root = getNodo(c);
	}
	
	public Nodo getRoot(){
		return root;
	}
}
