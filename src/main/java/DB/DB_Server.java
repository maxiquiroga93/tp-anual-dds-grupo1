package DB;

import java.util.ArrayList;

import Helpers.LevenshteinDistance;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.ParadaColectivo;
import POI.Rubro;
 
public class DB_Server {

	private static ArrayList<POI> listadoPOI;
	
	public DB_Server(){
		listadoPOI = new ArrayList<POI>();
		Rubro unRubro = new Rubro();
		POI cgpUno = CGP.ConstructorCGP("cgpUno",-34.5664823, -58.43407810000002);
		POI cgpDos = CGP.ConstructorCGP("cgpDos",-34.5658341, -58.43519549999996);
		POI localUno = LocalComercial.ConstructorLocalComercial("localUno", -34.5658341, -58.43519549999996, unRubro);
		POI localDos = LocalComercial.ConstructorLocalComercial("localDos", -34.5658341, -58.43519549999996, unRubro);
		POI pColUno = ParadaColectivo.ConstructorParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColDos = ParadaColectivo.ConstructorParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColTres = ParadaColectivo.ConstructorParadaColectivo("107",-34.5658341, -58.43519549999996);
		POI pColCuatro = ParadaColectivo.ConstructorParadaColectivo("35",-34.5658341, -58.43519549999996);
		
		cgpUno.setTipo("CGP");
		cgpDos.setTipo("CGP");
		localUno.setTipo("LocalComercial");
		localDos.setTipo("LocalComercial");
		pColUno.setTipo("ParadaColectivo");
		pColDos.setTipo("ParadaColectivo");
		pColTres.setTipo("ParadaColectivo");
		pColCuatro.setTipo("ParadaColectivo");
		
		listadoPOI.add(cgpUno);
		listadoPOI.add(cgpDos);
		listadoPOI.add(localUno);
		listadoPOI.add(localDos); 
		listadoPOI.add(pColUno);
		listadoPOI.add(pColDos); 
		listadoPOI.add(pColTres); 
		listadoPOI.add(pColCuatro); 
	}
	
	public static ArrayList<POI> getAllParadasColectivoByLinea(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(busqueda.equals(poi.getNombre())){
				respuesta.add(poi);
			}
		}
		return respuesta;
	}

	public static ArrayList<POI> getAllLocalesByRubro(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		ArrayList<LocalComercial> locales = new ArrayList<LocalComercial>();
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals("LocalComercial")){
				locales.add((LocalComercial) poi);
				for(LocalComercial local : locales ){
					if(local.getRubro().equals(busqueda))
						respuesta.add(local);
				}
			}
		}
		return respuesta;
	}

	public static ArrayList<POI> getAllCGPsByServicio(String busqueda) {
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(poi.getTipo().equals("CGP")){
			}
		}
		return respuesta;
	}

	public static ArrayList<POI> getAllPOIByNombre(String busqueda) {
		// TODO Auto-generated method stub
		ArrayList<POI> respuesta = new ArrayList<POI>();
		for(POI poi : listadoPOI){
			if(LevenshteinDistance.computeLevenshteinDistance(busqueda, poi.getNombre()) < 1){
				respuesta.add(poi);
			}
		}
		return respuesta;
	}

}
