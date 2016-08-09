package DB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import ABMC.POI_ABMC;
import POI.Banco;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.TiposPOI;
import userInterface.Buscador;
 
public class DB_Server {

	private static ArrayList<POI> listadoPOI;
	private static DB_Server instance = null;
	
	public DB_Server(){
		listadoPOI = new ArrayList<POI>();
	}
	
	public static ArrayList<POI> getListado(){
		return DB_Server.listadoPOI;
	}
	
	public DB_Server getInstance() {
		if(instance == null)
			instance = new DB_Server();
		return instance;
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
			if(Buscador.isNumeric(str) && poi.getNombre().equals(str));
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

	public static boolean eliminarPOI(double d){

		return listadoPOI.remove(d);
	}

	public static boolean agregarPOI(POI nuevoPOI) {
		try{
			//testear
			Long e = new Long(listadoPOI.size()+1);
			nuevoPOI.setId(e);
			listadoPOI.add(nuevoPOI);
			return true;
		} catch(Exception ex){
			return false;
		}
	}

	public static POI getPOIbyId(double d) {
		for(POI poi : listadoPOI){
			if(poi.getId().equals(d))
				return poi;
		}
		return null;
	}
	

}
