package drone;

import graph.Direction;
import graph.Graph;

import java.util.List;

public class DroneImplementation<T> implements DroneAPI {
	private Graph<T> graph;
	

	public DroneImplementation( Graph<T>  graph) {		
		this.graph = new Graph<T>();
	}	

	
	
	@Override
	public String obtenerIdentificadorUrbanizacion(double coordenadaX,
			double coordenadaY) {
		
		 
	   return this.graph.getUrbanizacion(coordenadaX, coordenadaY);
	}


	@Override
	public List<String> obtenerUrbanizaciónes(double coordendaX,
			double coordendaY, int rango) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String obtenerIdentificadorAdyacente(String idUrbanizacion,
			Direction direccion) {
		// TODO Auto-generated method stub
		
		return (String) this.graph.getAdyacente(idUrbanizacion,direccion);
		    
	}

}
