import GraphClasses.Grafo;
import GraphClasses.Nodo;
import TreeClasses.Arbol;
import TreeClasses.NodoArbol;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class BFS {
    private Grafo G;
    private Arbol BFSTree; //Arbol generador de G
    
    public BFS(Grafo G) {
            this.G = G;
    }
	
    public boolean buscar(char c){
        //Instanciamos el arbol
        BFSTree = new Arbol();
        
        Queue<Nodo> pendientes = new LinkedList<>();
        Set<Nodo> visitados = new HashSet<>();
        Nodo V;
        NodoArbol nAux; //Nodos del arbol
        //Obtenemos el nodo raiz
        V = G.getRoot();
        //Nodo Raiz no tiene padre        
        nAux = new NodoArbol(V.getC());
        BFSTree.setRoot(nAux);
        BFSTree.addNodo(nAux);
        //Metemos el nodo raiz a la lista
        pendientes.add(V);
        
        /*El ciclo se repite hasta que se hayan visitado todos los nodos
          o se haya encontrado el elemento*/
        while(!pendientes.isEmpty()){      
            MainFrame.out.append("Cola: "+pendientes.toString());
            MainFrame.out.append("\nVisitados: "+visitados.toString());            
            //Sacamos el elemento de la cabeza de la Cola
            V = pendientes.poll();
            //Si no es la raiz, asignamos nuevo nodo
            if(nAux.getC() != V.getC()){
                nAux = (NodoArbol)BFSTree.getNodo(V.getC());
            }
            MainFrame.out.append("\nNodo Actual: "+V);                        	
            if(esIgual(V,c)){		
                //Si es el elemento, cerramos la busqueda
                MainFrame.out.append("\n===============================\n");
                return true;
            }else{
                //Agregamos el nodo al conjunto de nodos visitados                
                visitados.add(V);
                //Obtenemos todos los nodos vecinos del nodo actual
                List<Nodo> adyacentes = V.getAdyacentes();
                MainFrame.out.append("\nVecinos de "+V+": "+adyacentes.toString());
                for (Nodo nodo : adyacentes) {
                    /*Agregamos los vecinos a la Cola excepto 
                      los que están en el conjunto de los visitados o en la cola*/
                    if(!visitados.contains(nodo) && !pendientes.contains(nodo)){
                        pendientes.add(nodo);
                        //Definimos el padre y agregamos al Arbol 
                        NodoArbol children = new NodoArbol(nodo.getC());
                        nAux.addHijo(children);
                        children.setParent(nAux);
                        BFSTree.addNodo(children);
                    }
                        
                }
            }
                MainFrame.out.append("\n===============================\n");
        }//Fin ciclo
        return false;
    }
    
    
    public boolean esIgual(Nodo n, char c){
            return n.getC()==c;
    }
	
    
    public Arbol getArbol(){
        return BFSTree;
    }
}