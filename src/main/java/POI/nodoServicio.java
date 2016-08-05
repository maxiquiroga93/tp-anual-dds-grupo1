package POI;

import java.util.ArrayList;

public class nodoServicio {
	
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
	
	public ArrayList<Integer> getListaDias(){
		return this.listaDias;
	}
	
	public void setHoras(int inicio, int fin){
		this.horaInicio=inicio;
		this.horaFin = fin;
	}

	public boolean contiene(String busqueda) {
		return this.nombre.contains(busqueda);
	}
	
	public int getHoraInicio(){
		return this.horaInicio;
	}

	public int getHoraFin(){
		return this.horaFin;
	}
}
