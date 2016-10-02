package drone;

public class Urbanizacion {
	private double _coordenadaX;
	private double _coordenadaY;
	private String _id;

	public Urbanizacion( double coordenadaX, double coordendadaY, String id){
		this._coordenadaX = coordenadaX;
		this._coordenadaY = coordendadaY;
		this._id = id;
	}
	public double get_coordenadaX() {
		return _coordenadaX;
	}
	public void set_coordenadaX(double _coordenadaX) {
		this._coordenadaX = _coordenadaX;
	}
	public double get_coordenadaY() {
		return _coordenadaY;
	}
	public void set_coordenadaY(double _coordenadaY) {
		this._coordenadaY = _coordenadaY;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
    
	@Override 
	 public int hashCode() {
		System.out.println("nuevo has");
		
		return this._id.hashCode();		
	}
	
	
	@Override
	public boolean equals(Object obj){
		System.out.println("PASAMOS POR AQUI");
		if (obj != null){
			System.out.println( "AQUII");
			Urbanizacion other = (Urbanizacion)obj;
			
			if ( ((other.get_coordenadaX() == this._coordenadaX) && 
					(other.get_coordenadaY() == this._coordenadaY))  
				  || this._id.equals(other.get_id())){
					return true;
			}
			
		}
		return false;
		
	}


}

