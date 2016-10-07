package drone;

import java.util.List;
import graph.Direction;
import graph.Graph;


public class DroneFlight<T> {

	public Graph  grafo = new Graph();

	public void setUrbanizaions(){
		double X = 26.5;
		double Y = 28.5;
		for ( int i = 1; i < 26; i= i+1){			
			grafo.addVertex(X,Y,"id"+i);
			X = X+1;
			Y= Y+1;
		}
		grafo.addEdge("id1", "id2",2,Direction.RIGTH);
		grafo.addEdge("id2", "id3",2,Direction.RIGTH);
		grafo.addEdge("id3", "id4",2,Direction.RIGTH);
		grafo.addEdge("id4", "id5",2,Direction.RIGTH);

		//row 2
		grafo.addEdge("id6", "id7",2,Direction.RIGTH);
		grafo.addEdge("id6", "id1",2,Direction.UP);		
		grafo.addEdge("id7", "id8",1,Direction.RIGTH);
		grafo.addEdge("id7", "id2",2,Direction.UP);		

		grafo.addEdge("id8", "id9",1,Direction.RIGTH);
		grafo.addEdge("id8", "id3",2,Direction.UP);		

		grafo.addEdge("id9", "id10",2,Direction.RIGTH);
		grafo.addEdge("id9", "id4",2,Direction.UP);

		grafo.addEdge("id10", "id5",2,Direction.UP);

		//row 3
		grafo.addEdge("id11", "id12",2,Direction.RIGTH);
		grafo.addEdge("id11", "id6",2,Direction.UP);		
		grafo.addEdge("id12", "id13",1,Direction.RIGTH);
		grafo.addEdge("id12", "id7",1,Direction.UP);		

		grafo.addEdge("id13", "id14",1,Direction.RIGTH);
		grafo.addEdge("id13", "id8",1,Direction.UP);		

		grafo.addEdge("id14", "id15",2,Direction.RIGTH);
		grafo.addEdge("id14", "id9",1,Direction.UP);

		grafo.addEdge("id15", "id10",1,Direction.UP);


		//row 4
		grafo.addEdge("id16", "id17",2,Direction.RIGTH);
		grafo.addEdge("id16", "id11",2,Direction.UP);		
		grafo.addEdge("id17", "id18",1,Direction.RIGTH);
		grafo.addEdge("id17", "id12",1,Direction.UP);		

		grafo.addEdge("id18", "id19",1,Direction.RIGTH);
		grafo.addEdge("id18", "id13",1,Direction.UP);		

		grafo.addEdge("id19", "id20",2,Direction.RIGTH);
		grafo.addEdge("id19", "id14",1,Direction.UP);

		grafo.addEdge("id20", "id15",2,Direction.UP);

		//row 
		grafo.addEdge("id21", "id22",2,Direction.RIGTH);
		grafo.addEdge("id21", "id16",2,Direction.UP);		
		grafo.addEdge("id22", "id23",1,Direction.RIGTH);
		grafo.addEdge("id22", "id17",2,Direction.UP);		

		grafo.addEdge("id23", "id24",2,Direction.RIGTH);
		grafo.addEdge("id23", "id18",2,Direction.UP);		

		grafo.addEdge("id24", "id25",2,Direction.RIGTH);
		grafo.addEdge("id24", "id19",2,Direction.UP);

		grafo.addEdge("id25", "id20",2,Direction.UP);


	}


	public static void main(String [] args){
		DroneFlight d = new DroneFlight();
		d.setUrbanizaions();

		DroneAPI drone= new DroneImplementation(d.grafo);
		System.out.println("Urbanizacion "+ drone.obtenerIdentificadorUrbanizacion( 38.5,40.5));
		System.out.println("Urbanizacion DERECHA "+drone.obtenerIdentificadorAdyacente("id13", Direction.RIGTH));
		System.out.println("Urbanizacion UP "+drone.obtenerIdentificadorAdyacente("id13", Direction.UP));
		System.out.println("Urbanizacion LEFT "+drone.obtenerIdentificadorAdyacente("id13", Direction.LEFT));
		System.out.println("Urbanizacion DOWN "+drone.obtenerIdentificadorAdyacente("id13", Direction.DOWN));
		//no existe
		List <String>  urbs= drone.obtenerUrbanizaciónes( 35.500001,40.511112, 1);
		System.out.println("Recorrido1 "+  35.500001+","+ 40.511112 + " "+ urbs.toString());
		List <String>  urbs2= drone.obtenerUrbanizaciónes(38.5,40.5, 1);
		System.out.println("Recorrido2 "+  38.5 +","+ 40.5 + " "+ urbs2.toString());
		
	}

}
