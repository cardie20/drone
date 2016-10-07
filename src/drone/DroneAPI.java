package drone;

import graph.Direction;

import java.util.List;

/**
 * @author erebper
 *
 */
public interface DroneAPI {
	/**
	 * Metodo que permite obtener la urbanizaci�n asociada a unas coordenadas
	 * @param coordendaX
	 * @param coordendaY
	 * @return Id urbanizacion
	 */
	public String obtenerIdentificadorUrbanizacion( double coordendaX, double coordendaY);
	
	/**
	 * Metodo que obtiene la urbanizaci�n adyacente en base a una direccion
	 * @param idUrbanizacion
	 * @param direccion 
	 * @return
	 */
	public String obtenerIdentificadorAdyacente( String idUrbanizacion, Direction direccion);
	public List <String> obtenerUrbanizaci�nes(double coordendaX, double coordendaY,int rango);

}
