package POI;

import Geolocation.GeoLocation;

public class CGP extends POI {


	
	
	public int getDistancia() {
		return cercania;
	}
	public void setDistancia(int distancia) {
		this.cercania = distancia;
	}

	
	// Se le pregunta a un POI si es cercano.
	@Override
	public boolean esCercano(POI poi){

	Integer comuna1 = this.getComuna();
	int comuna2 = poi.getComuna();
	if (comuna1.equals(comuna2))
		return true;
	else
		return false;
	}
	
	public static POI ConstructorCGP(String nombre,double latitud, double longitud){
		
		POI poi = new CGP();
		poi.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		poi.setNombre(nombre);
		
		return poi;
	}
	
}
