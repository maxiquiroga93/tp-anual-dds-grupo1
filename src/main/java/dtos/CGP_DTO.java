package dtos;

import java.util.ArrayList;
import java.util.List;

public class CGP_DTO {
	int comuna;
	String zonas;
	String director;
	String domicilio;
	String telefono;
	List<NodoServicioDTO> servicios = new ArrayList<NodoServicioDTO>();

	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}

	public String getZonas() {
		return zonas;
	}

	public void setZonas(String zonas) {
		this.zonas = zonas;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<NodoServicioDTO> getServicios() {
		return servicios;
	}

	public void setServicios(List<NodoServicioDTO> servicios) {
		this.servicios = servicios;
	}

}
