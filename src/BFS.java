import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class BFS {
	private Grafo G;
	public BFS(Grafo G) {
		this.G = G;
	}
	
        
        
	public boolean buscar(char c){
		Queue<Nodo> pendientes = new LinkedList<>();
		Set<Nodo> visitados = new HashSet<>();
		//Metemos el nodo raiz a la lista
		pendientes.add(G.getRoot());
                /*El ciclo se repite hasta que se hayan visitado todos los nodos
                  o se haya encontrado el elemento*/
		while(!pendientes.isEmpty()){            
            MainFrame.out.append("Cola: "+pendientes.toString());
            MainFrame.out.append("\nVisitados: "+visitados.toString());            
            //Sacamos el elemento de la cabeza de la Cola
            Nodo V = pendientes.poll();
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
                                    //Agregamos los vecinos a la Cola excepto 
                                    //los que están en el conjunto de los visitados
					if(!visitados.contains(nodo))
						pendientes.add(nodo);
				}
			}
		    MainFrame.out.append("\n===============================\n");
		}//Fin ciclo
		return false;
	}
	int contador = 0;
	public boolean esIgual(Nodo n, char c){
		contador++;
		return n.getC()==c;
	}
	
}
