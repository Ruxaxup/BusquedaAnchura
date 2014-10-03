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
            MainFrame.out.append("\n===============================\n");
            MainFrame.out.append("Cola: "+pendientes.toString());
            MainFrame.out.append("\nVisitados: "+visitados.toString());
            System.out.println(pendientes);
			Nodo V = pendientes.poll();
			MainFrame.out.append("\nNodo Actual: "+V);
			if(!visitados.contains(V) && esIgual(V,c)){
				System.out.println(contador);
				return true;
			}else{
				visitados.add(V);
				List<Nodo> adyacentes = V.getAdyacentes();
				MainFrame.out.append("\nHijos de "+V+": "+adyacentes.toString());
				for (Nodo nodo : adyacentes) {
					if(!visitados.contains(nodo))
						pendientes.add(nodo);
				}
			}
			
		}
		System.out.println(contador);
		return false;
	}
	int contador = 0;
	public boolean esIgual(Nodo n, char c){
		contador++;
		return n.getC()==c;
	}
	
}
