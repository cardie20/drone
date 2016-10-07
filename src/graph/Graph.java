package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author erebper
 *
 */
/**
 * @author erebper
 *
 */
/**
 * @author erebper
 *
 */
public class Graph {

    //Mapa que representa la relacion CoordenadaX-Y tiene 1 Identificador de urbanización
	private Map <String, String> coordenadasId;
	//Cada Identificador de urbanización tiene como máximo 4 Aristas Arriba, Abajo, Izq, Derecha
	private Map<String, ArrayList<Edge>> edges;
	//Mapa que almacena las Urbanizaciones visitadas
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

	
	/**
	 * Devuelve la urbanizacón adyacente en funcion de la dirección
	 * @param id
	 * @param direccion UP, DOWN, LEFT, RIGHT
	 * @return String con el ID de urbanización
	 */
	public String getAdyacente (String id, Direction direccion){

		if (this.getEdges()!=null){
			ArrayList<Edge> edges = this.edges.get(id);

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

	/**
	 * Devuelve el peso de la arista 
	 * @param id Urbanización origen
	 * @param direccion UP, DOWN, LEFT, RIGHT
	 * @return entero con el peso de la arista
	 */
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
		edgesAdyacency = this.edges.get(dstUrb);
		if ( edgesAdyacency == null){
			edgesAdyacency = new ArrayList<>();
		}

		if (!edgesAdyacency.contains(edge)){
			edgesAdyacency.add(edge);
			this.edges.put(dstUrb, edgesAdyacency);
		}

	}

	public List<String> obtenerUrbanizaciónes(double coordendaX, double coordendaY,int rango){
		String urbanizacion = this.getUrbanizacion(coordendaX, coordendaY);
		return recorridoAnchura(urbanizacion,rango);
	}



	public List<String> recorridoAnchura(String nodoI, int peso) {

		//Lista donde guardo los nodos recorridos

		ArrayList<String> recorridos = new ArrayList<String>();
		if (this.edges.containsKey(nodoI)){

			//El nodo inicial ya está visitado
			this.visitado.put(nodoI, true);

			//pila de visitas de los nodos adyacentes

			LinkedList<String> pila = new LinkedList<String>();

			//Se agrega el nodo a la pila de visitas

			pila.add(nodoI);

			//Hasta que visite todos los nodos

			while (!pila.isEmpty()) {

				//se saca el ultimo de la pila
				String urbj = pila.remove(pila.size()-1); 
			
				//se marca el recorrido
				recorridos.add(urbj);
				
				//Se busca en la matriz que representa el grafo los nodos adyacentes

				calculate(urbj,Direction.RIGTH,peso,pila,recorridos,visitado);
				calculate(urbj,Direction.DOWN,peso,pila,recorridos,visitado);
				calculate(urbj,Direction.LEFT,peso,pila,recorridos,visitado);
				calculate(urbj,Direction.UP,peso,pila,recorridos,visitado);

			}


		}
		return recorridos;//Devuelvo el recorrido del grafo

	}



	private void calculate( String urbanizacionOrigen , Direction direccion,int peso,LinkedList<String> pila, ArrayList<String> recorridos,Map<String,Boolean>visitado){

		int pesoAdyacente = getPesoAdyacente(urbanizacionOrigen,direccion);
		String urbDest= this.getAdyacente(urbanizacionOrigen, direccion);
		
		if (pesoAdyacente>0 && pesoAdyacente <= peso){

			
			if( !this.visitado.get(urbDest)) {

				pila.add(urbDest);//Se agrega a la pila de visitas

				this.visitado.put(urbDest, true); //Se marca como visitado

			}
		}else if (pesoAdyacente == -1){
			
			if (urbDest!=null){
				if( !this.visitado.get(urbDest)) {
					this.visitado.put(urbDest, true); //Se marca como visitado
				}
			}
		}
	}



}
