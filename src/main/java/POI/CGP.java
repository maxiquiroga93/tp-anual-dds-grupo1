package POI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import ABMC.POI_DTO;
import Geolocation.GeoLocation;
import Helpers.LevDist;

public class CGP extends POI {
	String director;// 3
	String telefono;// 5
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setServicios(ArrayList<nodoServicio> servicios) {
		Servicios = servicios;
	}
	
	public ArrayList<nodoServicio> Servicios = new ArrayList<nodoServicio>();// 6

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

	public long getDistancia() {
		return cercania;
	}

	public void setDistancia(long distancia) {
		this.cercania = distancia;
	}

	// Se le pregunta a un POI si es cercano.
	@Override
	public boolean esCercano(POI poi) {

		long comuna1 = this.getComuna();
		long comuna2 = poi.getComuna();
		if (comuna1 == comuna2)
			return true;
		else
			return false;
	}

	public CGP(String nombre, double latitud, double longitud) {
		this.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		this.setNombre(nombre);
	}

	@Override
	public boolean busquedaEstandar(String filtros[]) {
//		List<String> filtros = new ArrayList<String>();
//		filtros.add(texto1);
//		filtros.add(texto2);

		if (super.busquedaEstandar(filtros))
			return true;

		for (String filtro : filtros) {
			if (LevDist.calcularDistancia(filtro, this.director)) {
				return true;
			} else if (LevDist.calcularDistancia(filtro, this.telefono)) {
				return true;
			} else {
				this.compararServicios(filtro);
			}
		}

		return false;
	}
	
	@Override
	public boolean compararPOI(POI poi) {
		if (!super.compararPOI(poi)){
			return false;
			}
		CGP cgp = (CGP)poi;

			if (cgp.director == this.director &&
				cgp.telefono == this.telefono)
//			this.compararServicios(filtro);
				return true;
			else
				return false;
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
