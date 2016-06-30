package POI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import Geolocation.GeoLocation;

public class CGP extends POI {


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
		Calendar calendario = Calendar.getInstance();
		Iterator<nodoServicioCGP> iterador = Servicios.iterator();
		while(iterador.hasNext()){
			nodoServicioCGP nodo = iterador.next(); //Agarro el proximo nodo
			if (nodo.nombre==servicio || ""==servicio){ //busco un nodo especifico o recorro todo con ""
				if(nodo.listaDias.contains(calendario.get(Calendar.DAY_OF_WEEK))){ //chequear si el dia esta en la lista de dias disponibles
					if(nodo.horaInicio<= calendario.get(Calendar.HOUR_OF_DAY) && calendario.get(Calendar.HOUR_OF_DAY) < nodo.horaFin){ //chequear que el horario actual este disponible
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
