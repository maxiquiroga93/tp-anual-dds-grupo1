package DB;

import java.util.ArrayList;
import POI.POI;
 
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
