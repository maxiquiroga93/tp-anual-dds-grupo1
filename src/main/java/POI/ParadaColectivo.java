package POI;

public class ParadaColectivo extends POI {

	int distancia = 1; //esta distancia es en referencia a qué?
	String name = "paradaColectivo";
	
	
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean disponible(){//funcion para saber si la parada de colectivo está disponible
		return true;
	}
}
