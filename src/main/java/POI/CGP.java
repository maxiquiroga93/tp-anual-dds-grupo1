package POI;

import Geolocation.GeoLocation;

public class CGP extends POI {

	int cercania = 0;
	String name = "CGP";
	
	
	public int getDistancia() {
		return cercania;
	}
	public void setDistancia(int distancia) {
		this.cercania = distancia;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Se le pregunta a un POI si es cercano.
	boolean esCercano(POI poi){
		
	if (this.getComuna() == poi.getComuna())
		return true;
	else
		return false;
	}
	
	public POI ConstructorCGP(double latitud, double longitud){
		
		POI poi = new CGP();
		poi.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		
		
		return poi;
	}
	
}
