package drone;

import graph.Direction;
import graph.Edge;
import graph.Graph;


public class DroneFlight<T> {

	private Graph <T> grafo = new Graph<T>();

	public void setUrbanizaions(){
		double X = 35.5;
		double Y = 40.511111;
		Urbanizacion ur1,ur2,ur3,ur4 ;

		for ( int i = 1; i < 26; i= i+4){
			grafo.addVertex(X+0.000001,Y +0.000001,"id"+i);
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


		System.out.println(grafo.toString());
	}


	public static void main(String [] args){
		DroneFlight d = new DroneFlight();
		d.setUrbanizaions();

		DroneAPI drone= new DroneImplementation(d.grafo);
		drone.obtenerIdentificadorUrbanizacion( 35.5,40.511111);
		drone.obtenerUrbanizaciónes( 35.5,40.511111, 1);

	}

}
