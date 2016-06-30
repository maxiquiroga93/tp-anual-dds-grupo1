package POI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import Geolocation.GeoLocation;

public class CGP extends POI {
	int cercania = 0;
	public static ArrayList <nodoServicioCGP> Servicios = new ArrayList<nodoServicioCGP>();
	
	public void agregarServicio(String nombre, ArrayList<Integer> dias, int horaInicio, int horaFin){
		nodoServicioCGP nuevoNodo = new nodoServicioCGP();
		nuevoNodo.nombre=nombre;
		nuevoNodo.listaDias = dias;
		nuevoNodo.horaInicio=horaInicio;
		nuevoNodo.horaFin = horaFin;
		Servicios.add(nuevoNodo);
	}
	
	public boolean disponible(String servicio){
		Iterator<nodoServicioCGP> iterador = Servicios.iterator();
		while(iterador.hasNext()){
			nodoServicioCGP nodo = iterador.next(); //Agarro el proximo nodo
			if (nodo.nombre==servicio || ""==servicio){ //busco un nodo especifico o recorro todo con ""
				if(nodo.listaDias.contains(Calendar.DAY_OF_WEEK)){ //chequear si el dia esta en la lista de dias disponibles
					if(nodo.horaInicio<= Calendar.HOUR_OF_DAY && Calendar.HOUR_OF_DAY < nodo.horaFin){ //chequear que el horario actual este disponible
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public int getDistancia() {
		return cercania;
	}
	public void setDistancia(int distancia) {
		this.cercania = distancia;
	}

	
	// Se le pregunta a un POI si es cercano.
	boolean esCercano(POI poi){
		
	if (this.getComuna() == poi.getComuna())
		return true;
	else
		return false;
	}
	
	public POI ConstructorCGP(double latitud, double longitud, String nombre){
		
		POI poi = new CGP();
		poi.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		poi.setNombre(nombre);
		
		return poi;
	}
	
}
