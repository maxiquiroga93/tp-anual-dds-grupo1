package POI;

import Geolocation.GeoLocation;

public class LocalComercial extends POI {

	Rubro rubro; 
	
	
	public int getDistancia() {
		return rubro.getCercania();
	}

	
	public POI ConstructorLocalComercial(String nombre, double latitud, double longitud, Rubro rubro){
		
		LocalComercial poi = new LocalComercial();
		poi.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		poi.setNombre(nombre);
		poi.setRubro(rubro);
		
		
		return poi;
	}
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	
	
}