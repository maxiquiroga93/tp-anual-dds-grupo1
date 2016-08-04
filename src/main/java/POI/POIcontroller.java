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
		} else if (isServicio(busqueda)){
			//Si encuentra un servicio = textoLibre
			//Buca todos los POI con con servicio LIKE '%busqueda%'
			resultado = DB_Server.getAllCGPsByServicio(busqueda);
		} else {
			//Traigo todos los POI que tengan nombre LIKE '%busqueda%'
			resultado = DB_Server.getAllPOIByNombre(busqueda);
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
