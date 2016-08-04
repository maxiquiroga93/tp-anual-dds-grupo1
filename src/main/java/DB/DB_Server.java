package DB;

import java.util.ArrayList;

import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.POIcontroller;
import POI.TiposPOI;
 
public class DB_Server {

	private static ArrayList<POI> listadoPOI;
	
	public DB_Server(){
		listadoPOI = new ArrayList<POI>();
	}
	
	public ArrayList<POI> getListado(){
		return DB_Server.listadoPOI;
	}
	
	public static ArrayList<POI> getAllParadasColectivoByLinea(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(busqueda.equals(poi.getNombre()))
				respuesta.add(poi);
		}
		return respuesta;
	}

	public static ArrayList<POI> getAllLocalesByRubro(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals(TiposPOI.LOCAL_COMERCIAL)){
				if(((LocalComercial)poi).getRubro().getNombre().toLowerCase().equals(busqueda)){
					respuesta.add(poi);
				}
			}
		}		
		return respuesta;
	}
	
	public static ArrayList<POI> getAllLocalesByEtiqueta(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(poi.buscarEtiqueta(busqueda)){
				respuesta.add(poi);
			}
		}		
		return respuesta;
	}

	public static ArrayList<POI> getAllCGPsByServicio(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals("CGP")){
				if(((CGP)poi).contieneServicio(busqueda))
					respuesta.add(poi);
			}
		}
		return respuesta;
	}

	

	public static boolean existeLinea(String str) {
		for(POI poi : listadoPOI){
			if(POIcontroller.isNumeric(str) && poi.getNombre().equals(str));
				return true;
		}
		return false;
	}

	public static boolean existeRubro(String str) {
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals(TiposPOI.LOCAL_COMERCIAL)){
				if(((LocalComercial)poi).getRubro().getNombre().toLowerCase().equals(str))
					return true;
			}
		}
		return false;
	}
	
	/*busca en las etiquetas que tiene cada poi en una lista de pois*/
	public static boolean existeConEtiquetaNombre(String str) {
		for(POI poi : listadoPOI){
			if(poi.buscarEtiqueta(str)){
				
					return true;
			}
		}
		return false;
	}

	public static boolean existeServicio(String str) {
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals(TiposPOI.CGP)){
				if(((CGP)poi).Servicios.contains(str))
					return true;
			}
		}
		return false;
	}

	public static boolean eliminarPOI(Long id){

		return listadoPOI.remove(id);
	}

	public static boolean agregarPOI(POI nuevoPOI) {
		try{
			listadoPOI.add(nuevoPOI);
			return true;
		} catch(Exception ex){
			return false;
		}
	}

	public static POI getPOIbyId(Long id) {
		for(POI poi : listadoPOI){
			if(poi.getId().equals(id))
				return poi;
		}
		return null;
	}
}
