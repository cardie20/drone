package drone;

import java.util.List;

import graph.Direction;
import graph.Edge;
import graph.Graph;


public class DroneFlight<T> {

	public Graph  grafo = new Graph();
	
	public void setUrbanizaions(){
		double X = 26.5;
		double Y = 28.5;
		Urbanizacion ur1,ur2,ur3,ur4 ;

		for ( int i = 1; i < 26; i= i+1){
			if (i == 13){
				System.out.println("X vale" + X + "Y VALE  "+ Y);
			}
			grafo.addVertex(X,Y,"id"+i);
			X = X+1;
			Y= Y+1;
		}


		Edge e;
		int weight1 =1;
		int weight2 =2;
		int weight3 =3;
		int down, right,up,left;
		int N =5;
		int size = N*N;
		int id =1;
		for (int i =1; i <= N; i++){
			for (int j= 1; j<= N; j++) {

				System.out.println("ID" +id);
				down = id+5;
				if (id ==6){
					System.out.println("a");
				}
				if (i<N){
					System.out.println(" D - "+ down);
					//if (down % N > 1 && down %N < (N-1)  && i >1 && i <N-1){
					if (down % N > 1 && down %N < (N-1) ){

						if (down %N ==3){
							grafo.addEdge("id"+id, "id"+down, weight3, Direction.DOWN);
						}else{

							grafo.addEdge("id"+id, "id"+down, weight1, Direction.DOWN);
						}
					}else{
						grafo.addEdge("id"+id, "id"+down, weight2, Direction.DOWN);

					}

				}
				right = id+1;//rigth +4
				if (id % N !=0){
					System.out.println(" R - "+ right);
					if (right % N > 1 && right %N < (N-1)){
						if (right %N ==3){
							grafo.addEdge("id"+id, "id"+right, weight3, Direction.DOWN);
						}else{
							grafo.addEdge("id"+id, "id"+right, weight2, Direction.RIGTH);
						}
					}else{
						grafo.addEdge("id"+id, "id"+right, weight1, Direction.RIGTH);

					}

				}

				//up -5

				up = id-5;
				if (up>N && up<=N*N ){
					System.out.println(" U - "+ up);
					if (up % N > 1 && up %N < (N-1)  ){
						if (up %N ==3){
							grafo.addEdge("id"+id, "id"+up, weight3, Direction.DOWN);
						}else{
							grafo.addEdge("id"+id, "id"+up, weight2, Direction.UP);
						}
					}else{
						grafo.addEdge("id"+id, "id"+up, weight1, Direction.UP);

					}

				}

				left = id -1;
				if ( id !=1 && (id %N !=1) ){
					System.out.println(" L - "+ left);
					if (left % N > 1 && left %N < (N-1) && i ==1 && i == N-1){
						if (left %N ==3){
							grafo.addEdge("id"+id, "id"+left, weight3, Direction.DOWN);
						}else{
							grafo.addEdge("id"+id, "id"+left, weight2, Direction.LEFT);
						}
					}else{
						grafo.addEdge("id"+id, "id"+left, weight1, Direction.LEFT);

					}

				}
				//leftg -1
				id = id +1;
			}
		}


		
	}


	public static void main(String [] args){
		DroneFlight d = new DroneFlight();
		d.setUrbanizaions();

		DroneAPI drone= new DroneImplementation(d.grafo);
		System.out.println("ENCONTRADO "+ drone.obtenerIdentificadorUrbanizacion( 38.5,40.5));
		
		System.out.println("ENCONTRADO DERECHA "+drone.obtenerIdentificadorAdyacente("id13", Direction.RIGTH));
		
		System.out.println("ENCONTRADO UP "+drone.obtenerIdentificadorAdyacente("id13", Direction.UP));
		System.out.println("ENCONTRADO LEFT "+drone.obtenerIdentificadorAdyacente("id13", Direction.LEFT));
		System.out.println("ENCONTRADO DOWN "+drone.obtenerIdentificadorAdyacente("id13", Direction.DOWN));
		//no existe
     	List <String>  urbs= drone.obtenerUrbanizaciónes( 35.500001,40.511112, 1);
     	
     	List <String>  urbs2= drone.obtenerUrbanizaciónes(38.5,40.5, 1);
     	
     	
     	
		System.out.println(urbs.toString());
	}

}
