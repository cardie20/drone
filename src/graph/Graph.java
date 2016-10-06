package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import drone.Urbanizacion;

public class Graph {


	private Map <String, String> coordenadasId;
	private Map<String, ArrayList<Edge>> edges;
	private Map <String, Boolean> visitado;
	public Graph(){
		coordenadasId = new HashMap<String, String >();
		edges = new HashMap<String, ArrayList<Edge> >();
		visitado = new HashMap<String, Boolean>();
	}


	public Map<String, String> getCoordenadasId() {
		return coordenadasId;
	}


	public void setCoordenadasId(Map<String, String> coordenadasId) {
		this.coordenadasId = coordenadasId;
	}


	public Map<String, ArrayList<Edge>> getEdges() {
		return edges;
	}


	public void setEdges(Map<String, ArrayList<Edge>> edges) {
		this.edges = edges;
	}


	public Map<String, Boolean> getVisitado() {
		return visitado;
	}


	public void setVisitado(Map<String, Boolean> visitado) {
		this.visitado = visitado;
	}


	/**
	 * Adds a vertex to the graph.
	 * @param string        vertex to add
	 */
	public boolean addVertex(double coordenadaX, double coordenadaY, String id) {

		if (!this.coordenadasId.containsKey(coordenadaX+","+ coordenadaY)) {

			this.coordenadasId.put(coordenadaX+","+ coordenadaY, id);

			visitado.put(id, false);
			if (!this.edges.containsKey(id)){
				this.edges.put(id,  new ArrayList<Edge>(4));
			}
		}


		return true;
	}

	public String getUrbanizacion (double coordenadaX, double coordenadaY){		
		return this.coordenadasId.get(coordenadaX+","+coordenadaY);
	}

	public String getAdyacente (String id, Direction direccion){

		if (this.getEdges()!=null){
			ArrayList<Edge> edges = this.edges.get(id);

			boolean found = false;
			if (edges != null){
				for (Edge e : edges){
					if(e.getDirection() == direccion){
						return e.getDstUrb();
					}
				}
			}

		}

		return null;


	}

	public int getPesoAdyacente (String id, Direction direccion){
		if (this.getEdges()!=null){
			ArrayList<Edge> edges = this.edges.get(id);

			boolean found = false;
			if (edges!= null){
				for (Edge e : edges){
					if(e.getDirection() == direccion){
						return e.getWeight();
					}
				}
			}

		}
		return -1;
	}






	public void addEdge(String srcUrb, String dstUrb, int weigth, Direction direction){


		Edge edge = new Edge(dstUrb, weigth,direction);
		ArrayList<Edge> edgesAdyacency = this.edges.get(srcUrb);
		if ( edgesAdyacency == null){
			edgesAdyacency = new ArrayList<>();
		}

		if (!edgesAdyacency.contains(edge)){
			edgesAdyacency.add(edge);
			this.edges.put(srcUrb, edgesAdyacency);
		}



		edge = new Edge(srcUrb, weigth,direction.reverse(direction));
		edgesAdyacency = this.edges.get(srcUrb);
		if ( edgesAdyacency == null){
			edgesAdyacency = new ArrayList<>();
		}

		if (!edgesAdyacency.contains(edge)){
			edgesAdyacency.add(edge);
			this.edges.put(srcUrb, edgesAdyacency);
		}

	}

	public List <String> obtenerUrbanizaciónes(double coordendaX, double coordendaY,int rango){
		String urbanizacion = this.getUrbanizacion(coordendaX, coordendaY);
		return recorridoAnchura(urbanizacion,rango);
	}



	public ArrayList<String> recorridoAnchura(String nodoI, int peso) {

		//Lista donde guardo los nodos recorridos

		ArrayList<String> recorridos = new ArrayList<String>();

		if (this.edges.containsKey(nodoI)){
			
			//El nodo inicial ya está visitado
			this.visitado.put(nodoI, true);

			//Cola de visitas de los nodos adyacentes

			ArrayList<String> cola = new ArrayList<String>();

			//Se lista el nodo como ya recorrido

			recorridos.add(nodoI);

			//Se agrega el nodo a la cola de visitas

			cola.add(nodoI);

			//Hasta que visite todos los nodos

			while (!cola.isEmpty()) {

				String urbj = cola.remove(0); //Se saca el primero nodo de la cola

				//Se busca en la matriz que representa el grafo los nodos adyacentes

				ArrayList<Edge> adyacentes = this.edges.get(urbj);


				calculate(urbj,Direction.UP,peso,cola,recorridos,visitado);
				calculate(urbj,Direction.LEFT,peso,cola,recorridos,visitado);
				calculate(urbj,Direction.RIGTH,peso,cola,recorridos,visitado);
				calculate(urbj,Direction.DOWN,peso,cola,recorridos,visitado);




			}
		}
		return recorridos;//Devuelvo el recorrido del grafo en anchura

	}



	private void calculate( String urbanizacionOrigen , Direction direccion,int peso,ArrayList<String> cola, ArrayList<String> recorridos,Map<String,Boolean>visitado){

		if ( getPesoAdyacente(urbanizacionOrigen,direccion) == peso){

			String urbDest= (String)this.getAdyacente(urbanizacionOrigen, direccion);
			if( !this.visitado.get(urbDest)) {

				cola.add(urbDest);//Se agrega a la cola de visitas

				recorridos.add(urbDest);//Se marca como recorrido
				this.visitado.put(urbDest, true); //Se marca como visitado

			}
		}else if (getPesoAdyacente(urbanizacionOrigen,direccion) == -1){
			String urbDest= (String)this.getAdyacente(urbanizacionOrigen, direccion);
			if( !this.visitado.get(urbDest)) {
				this.visitado.put(urbDest, true); //Se marca como visitado
			}
		}
	}



	public String toString(){
		StringBuffer a = new StringBuffer();
		for (String s :this.edges.keySet()) {
			ArrayList<Edge>edgeA =this.edges.get(s);
			a.append( " \nSRC "+ s +" ");
			for (int i =0; i< edgeA.size(); i++){
				if (edgeA.get(i)!=null){
					a.append(edgeA.get(i).getDstUrb());
				}

			}

		}
		return a.toString();
	}
}
