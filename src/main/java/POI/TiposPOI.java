package POI;

public enum TiposPOI {
	BANCO ("BANCO"), CGP ("CGP"), LOCAL_COMERCIAL ("LOCAL_COMERCIAL"), PARADA_COLECTIVO ("PARADA_COLECTIVO");

	private String nombre;
	
	TiposPOI(String unNombre){
		this.nombre = unNombre;
	}
	
	public String nombre(){
		return this.nombre;
	}
	
	
}
