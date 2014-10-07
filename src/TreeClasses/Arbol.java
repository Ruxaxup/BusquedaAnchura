
package TreeClasses;

import GraphClasses.Grafo;
import GraphClasses.Nodo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Arbol extends Grafo{    
    
    public NodoArbol root;
    
    List<NodoArbol> nodos = new LinkedList<>();
    
    public void printTree(){
        Stack<NodoArbol> pila = new Stack<>();
        Set<NodoArbol> visitados = new HashSet<>();
        pila.add(root);
        while(!pila.isEmpty()){
            NodoArbol na = pila.pop();
            visitados.add(na);
            System.out.print(na+" ");
            if(!na.getHijos().isEmpty()){
                for (NodoArbol nodoArbol : na.getHijos()) {
                    if(!visitados.contains(nodoArbol) && !pila.contains(nodoArbol)){
                        pila.add(nodoArbol);
                    }
                }
            }
        }
    }
    
    /*public void addNodo(NodoArbol na){
        nodos.add(na);
    }*/
    
    public void setRoot(NodoArbol root){
        this.root = root;
    }
}
