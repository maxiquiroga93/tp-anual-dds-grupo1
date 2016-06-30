package POI;

import java.util.ArrayList;

public class nodoServicioCGP {
	
	String nombre;
	ArrayList<Integer> listaDias = new ArrayList<Integer>();
	int horaInicio;
	int horaFin;
	
	public void setName(String nombre){
		this.nombre = nombre;
	}
	
	public String getName(){
		return this.nombre;
	}

	public void agregarDia(Integer numero){
		listaDias.add(numero);
	}
	
	public void setHoras(int inicio, int fin){
		this.horaInicio=inicio;
		this.horaFin = fin;
	}
}
