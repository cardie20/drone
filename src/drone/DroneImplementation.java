package drone;

import graph.Direction;
import graph.Graph;

import java.util.List;

public class DroneImplementation implements DroneAPI {
	private Graph graph;
	

	public DroneImplementation( Graph  graph) {		
		this.graph = graph;
		
	}	
	
	@Override
	public String obtenerIdentificadorUrbanizacion(double coordenadaX,
			double coordenadaY) {
		
	   return this.graph.getUrbanizacion(coordenadaX, coordenadaY);
	}


	@Override
	public List<String> obtenerUrbanizaciónes(double coordendaX,
			double coordendaY, int rango) {
	
		return this.graph.obtenerUrbanizaciónes(coordendaX, coordendaY, rango);
	}



	@Override
	public String obtenerIdentificadorAdyacente(String idUrbanizacion,
			Direction direccion) {
		// TODO Auto-generated method stub
		
		return (String) this.graph.getAdyacente(idUrbanizacion,direccion);
		    
	}

}
