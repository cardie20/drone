package drone;

import graph.Direction;

import java.util.List;

public interface DroneAPI {
	public String obtenerIdentificadorUrbanizacion( double coordendaX, double coordendaY);
	public String obtenerIdentificadorAdyacente( String idUrbanizacion, Direction direccion);
	public List <String> obtenerUrbanizaciónes(double coordendaX, double coordendaY,int rango);

}
