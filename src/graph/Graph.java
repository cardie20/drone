package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import drone.Urbanizacion;

public class Graph<T> {


	private Map <String, String> coordenadasId;
	private Map <String, Edge[]> edges;

	public Graph(){
		coordenadasId = new HashMap<String, String >();
		edges = new HashMap<String, Edge[] >();
	}


	/**
	 * Adds a vertex to the graph.
	 * @param string        vertex to add
	 */
	public boolean addVertex(double coordenadaX, double coordenadaY, String id) {
		if (!coordenadasId.containsKey(coordenadaX+","+ coordenadaY)) {
			coordenadasId.put(coordenadaX+","+ coordenadaY, id);
		}
		if (!edges.containsKey(id)){
			edges.put(id,  new Edge[4]);
		}

		return true;
	}

	public String getUrbanizacion (double coordenadaX, double coordenadaY){
		return this.coordenadasId.get(coordenadaX+","+coordenadaY);
	}

	public Object getAdyacente (String id, Direction direccion){
		return this.edges.get(id)[direccion.value];
	}






	public void addEdge(String srcUrb, String dstUrb, int weigth, Direction direction){
		Edge edge = new Edge(dstUrb, weigth,direction);
		Edge edgesAdyacency[]= this.edges.get(srcUrb);
		if ( edgesAdyacency == null){
			edgesAdyacency = new Edge[4];
		}
		System.out.println("direction.value" + direction.value);
		edgesAdyacency[direction.value] = edge;
		
		this.edges.put(srcUrb, edgesAdyacency);
			


	}

	public List DFS( String origin, List visitedNodes){
		Stack<String> stack = new Stack<String>();

		stack.push(origin);
		while (!stack.isEmpty()){
			String visited = stack.pop();
			if (!visitedNodes.contains(visited)){
				visitedNodes.add(visited);
				Edge [] edges =this.edges.get(visited);


				if (edges[Direction.RIGTH.value]!= null){
					visitedNodes.addAll(DFS(edges[Direction.RIGTH.value].getDstUrb(),visitedNodes));
				}
				if (edges[Direction.DOWN.value]!= null){
					visitedNodes.addAll(DFS(edges[Direction.DOWN.value].getDstUrb(),visitedNodes));
				}
				if (edges[Direction.LEFT.value]!= null){
					visitedNodes.addAll(DFS(edges[Direction.LEFT.value].getDstUrb(),visitedNodes));
				}
				if (edges[Direction.UP.value]!= null){
					visitedNodes.addAll(DFS(edges[Direction.UP.value].getDstUrb(),visitedNodes));
				}

			}

		}
		return visitedNodes;

	}





	public String toString(){
		StringBuffer a = new StringBuffer();
		for (String s :this.edges.keySet()) {
			Edge[]edgeA =this.edges.get(s);
			a.append( " \nSRC "+ s +" ");
			for (int i =0; i< edgeA.length; i++){
				if (edgeA[i]!=null){
					a.append(edgeA[i].toString());
				}
			}

		}
		return a.toString();
	}
}
