package POI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import Geolocation.GeoLocation;

public class LocalComercial extends POI {

	Rubro rubro; 
	public ArrayList<Integer> dias = new ArrayList<Integer>();
	public ArrayList<Integer> horas = new ArrayList<Integer>();
	
	public int getDistancia() {
		return rubro.getCercania();
	}

	
	public static POI ConstructorLocalComercial(String nombre, double latitud, double longitud, Rubro rubro){
		
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
	
	public boolean disponible(){
		Calendar calendario = Calendar.getInstance();
		Iterator<Integer> iteradorDias = dias.iterator(); //obtengo los dias
		while(iteradorDias.hasNext()){ //recorro los dias
			int dia = iteradorDias.next(); //elijo un dia en particular
			if(calendario.get(Calendar.DAY_OF_WEEK) == dia){ //comparo si el dia de hoy es ese dia
				Iterator<Integer> iteradorHoras = horas.iterator(); //obtengo las horas
				while(iteradorHoras.hasNext()){ //recorro las horas
					int hora = iteradorHoras.next(); //elijo una hora en particular 
					if(calendario.get(Calendar.HOUR_OF_DAY) == hora){ //comparo si la hora de ahora es esa hora
						return true;
					} //sino paso a la siguiente hora
				}//sino paso al siguiente dia
			}
		}//sino es falso
		return false;
		
	}
	
}