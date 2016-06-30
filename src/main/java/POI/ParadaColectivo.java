package POI;

import Geolocation.GeoLocation;

public class ParadaColectivo extends POI {

	int cercania = 100; //esta distancia es en referencia a qué?
	
	
	public int getDistancia() {
		return cercania;
	}
	public void setDistancia(int distancia) {
		this.cercania = distancia;
	}

	
	public boolean disponible(){//funcion para saber si la parada de colectivo está disponible
		return true;
	}
	
	public static POI ConstructorParadaColectivo(String nombre,double latitud, double longitud){
		
		ParadaColectivo poi = new ParadaColectivo();
		poi.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		poi.setNombre(nombre);
		
		return poi;
	}
}
