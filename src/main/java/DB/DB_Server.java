package DB;

import java.util.ArrayList;

import Helpers.LevenshteinDistance;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.POIcontroller;
 
public class DB_Server {

	private static ArrayList<POI> listadoPOI;
	
	public DB_Server(){
		listadoPOI = new ArrayList<POI>();
	}
	
	public ArrayList<POI> getListado(){
		return this.listadoPOI;
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
			if(poi.getTipo().equals("LocalComercial")){
				if(((LocalComercial)poi).getRubro().getNombre().toLowerCase().equals(busqueda)){
					respuesta.add(poi);
				}
			}
		}		
		return respuesta;
	}

	public static ArrayList<POI> getAllCGPsByServicio(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals("CGP")){
				if(((CGP)poi).Servicios.contains(busqueda))
					respuesta.add(poi);
			}
		}
		return respuesta;
	}

	public static ArrayList<POI> getAllPOIByNombre(String busqueda) {
		// TODO Auto-generated method stub
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(LevenshteinDistance.computeLevenshteinDistance(busqueda, poi.getNombre()) < 1 || poi.getNombre().contains(busqueda))
				respuesta.add(poi);
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
			if(poi.getTipo().equals("LocalComercial")){
				if(((LocalComercial)poi).getRubro().getNombre().toLowerCase().equals(str))
					return true;
			}
		}
		return false;
	}

	public static boolean existeServicio(String str) {
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals("CGP")){
				if(((CGP)poi).Servicios.contains(str))
					return true;
			}
		}
		return false;
	}

}
