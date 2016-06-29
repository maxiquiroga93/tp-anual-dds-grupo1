package POI;

import Geolocation.GeoLocation;

public class LocalComercial extends POI {

	String name = "LocalComercial";
	Rubro rubro; 
	
	
	public int getDistancia() {
		return rubro.getCercania();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public POI ConstructorLocalComercial(double latitud, double longitud, Rubro rubro){
		
		LocalComercial poi = new LocalComercial();
		poi.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
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