package poi;

public class Etiqueta implements IFlyweightEtiqueta {
	public String nombre;
	
	public Etiqueta(String nombre){
		this.nombre=nombre;
		
	}
	public String getNombre(){
		return this.nombre;
	}
}
