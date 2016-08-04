package POI;
import java.util.ArrayList;

import DB.DB_Server;

public class POIcontroller {
	
	public ArrayList<POI> getPOIs(String textoLibre){
		
		String busqueda = textoLibre.toLowerCase();
		ArrayList<POI> resultado = new ArrayList<POI>();
		
		if(isColectivo(busqueda)){
			//Traigo ParadaColectivo por busqueda
			resultado = DB_Server.getAllParadasColectivoByLinea(busqueda);
		} else if (isRubro(busqueda)){
			//Si encuentra un rubro = textoLibre
			//Busca todos los POI con ese rubro
			resultado = DB_Server.getAllLocalesByRubro(busqueda);
		} else if (isEtiqueta(busqueda)){
			//Si encuentra una etiqueta entre la lista de cada POI 
			//Busca todos los POI con esa etiqueta
			resultado = DB_Server.getAllLocalesByEtiqueta(busqueda);
		
		} else if (isServicio(busqueda)){
			//Si encuentra un servicio = textoLibre
			//Buca todos los POI con con servicio LIKE '%busqueda%'
			resultado = DB_Server.getAllCGPsByServicio(busqueda);
		} 
		
		return resultado;
	}
	
	private boolean isColectivo(String str){
		// Agregar si encuentra algun colectivo con ese str
		if(isNumeric(str) && DB_Server.existeLinea(str))
			return true;
		
		return false;
	}
	
	private boolean isRubro(String str){
		return (DB_Server.existeRubro(str));
	}
	public boolean isEtiqueta(String str){
	return DB_Server.existeConEtiquetaNombre(str);
	}
	
	
	private boolean isServicio(String str){
		return (DB_Server.existeServicio(str));
	}
	
	public static boolean isNumeric(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	    	return false;
	    }
	}

	
}
