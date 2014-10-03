
public class Main {
	public static void main(String[] args) {
		Grafo G = new Grafo();
		
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
		
		//BFS (BUSQUEDA EN AMPLITUD)
		BFS bfs = new BFS(G);
		char elementoABuscar = 'J';
		if(bfs.buscar('J')){
			System.out.println("Si se encontro: "+elementoABuscar);
		}else{
			System.out.println("No se encontro");
		}
	}
}
