package POI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import ABMC.POI_DTO;
import Geolocation.GeoLocation;

public class CGP extends POI {
	String director;//3
	String telefono;//5
	public ArrayList<nodoServicio> Servicios = new ArrayList<nodoServicio>();//6

	public void agregarServicio(String nombre, ArrayList<Integer> dias, int horaInicio, int horaFin) {
		nodoServicio nuevoNodo = new nodoServicio();
		nuevoNodo.nombre = nombre;
		nuevoNodo.listaDias = dias;
		nuevoNodo.horaInicio = horaInicio;
		nuevoNodo.horaFin = horaFin;
		Servicios.add(nuevoNodo);
	}

	public boolean disponible(String servicio) {
		Calendar calendario = Calendar.getInstance();
		Iterator<nodoServicio> iterador = Servicios.iterator();
		while (iterador.hasNext()) {
			// Agarro el proximo nodo, busco un nodo especifico o recorro todo
			// con ""
			nodoServicio nodo = iterador.next();
			if (nodo.getName() == servicio || "" == servicio) {

				if (nodo.listaDias.contains(calendario.get(Calendar.DAY_OF_WEEK))) {
					// chequear si el dia esta en la lista de dias disponibles
					// que el horario actual este disponible
					if (nodo.horaInicio <= calendario.get(Calendar.HOUR_OF_DAY)
							&& calendario.get(Calendar.HOUR_OF_DAY) < nodo.horaFin) { // chequear

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
	public boolean esCercano(POI poi) {

		Integer comuna1 = this.getComuna();
		int comuna2 = poi.getComuna();
		if (comuna1.equals(comuna2))
			return true;
		else
			return false;
	}

	public CGP(String nombre, double latitud, double longitud) {
		this.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		this.setNombre(nombre);
	}
	
	public CGP busqueda(String texto1, String texto2){
		POI nodo = busquedaEstandar(texto1,texto2);
		if(nodo != null){
			return this;
		}
		
		String[] cadena = new String[2];
		for(int i=0;i<2;i++){
			if(director == cadena[i]){
				return this;
			}else if(telefono == cadena[i]){
				return this;
			}else{
				compararServicios(cadena);
			}
		}
		return null;
		
	}
	
	
	@Override
	public void setDatos(POI_DTO dto) {
		super.setDatos(dto);
		for (nodoServicio servicio : dto.getServicios()) {
			this.agregarServicio(servicio.getName(), servicio.getListaDias(), servicio.getHoraInicio(),
					servicio.getHoraFin());
		}
	}

	public ArrayList<nodoServicio> getServicios() {
		return Servicios;
	}

	public void setServicio(nodoServicio servicio) {
		Servicios.add(servicio);
	}

}
