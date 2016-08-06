package DTOs;

public class nodoServicioDTO {
	String nombre;
	HorariosDTO horarios;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HorariosDTO getHorarios() {
		return horarios;
	}

	public void setHorarios(HorariosDTO horarios) {
		this.horarios = horarios;
	}

}
