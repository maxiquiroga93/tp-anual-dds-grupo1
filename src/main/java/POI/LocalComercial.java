package POI;

public class LocalComercial extends POI {

	String name = "LocalComercial";
	Rubro rubro; 
	
	
	public int getDistancia() {
		return rubro.getCercania();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//TODO builder debe crear el rubro y agregar el nuevo LocalComercial a la
	// lista de "tpoi" en la clase TipoPOI
}