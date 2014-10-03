import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


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
		while(!pendientes.isEmpty()){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    MainFrame.out.setText(pendientes.toString());
                    System.out.println(pendientes);
			Nodo V = pendientes.poll();
			System.out.println("Analizando: "+V);
			if(!visitados.contains(V) && esIgual(V,c)){
				return true;
			}else{
				visitados.add(V);
				List<Nodo> adyacentes = V.getAdyacentes();
				for (Nodo nodo : adyacentes) {
					if(!visitados.contains(nodo))
						pendientes.add(nodo);
				}
			}
			
		}
		return false;
	}
	
	public boolean esIgual(Nodo n, char c){
		return n.getC()==c;
	}
	
}
