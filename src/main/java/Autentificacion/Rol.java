package Autentificacion;

public enum Rol {
	ADMIN ("admin",1), TERMINAL ("terminal",2);

	private String nombre;
	private long ID;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;	
	}
	
	Rol(String unNombre, long unID){
		this.nombre = unNombre;
		this.ID = unID;
	}
	
}
