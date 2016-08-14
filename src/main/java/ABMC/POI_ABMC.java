package ABMC;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

import DB.DB_Server;
//import POI.Banco;
import POI.POI;
import POI.BusquedaDePOIsExternos;
//import POI.CGP;
//import POI.ParadaColectivo;
//import POI.LocalComercial;

public class POI_ABMC {

	private ArrayList<POI> resultado;

	public boolean alta(POI_DTO dto) {

		POI nuevoPOI = dto.converttoPOI();
		if (nuevoPOI.equals(null)) {
			return false;
		} else {
			DB_Server.agregarPOI(nuevoPOI);
			return true;
		}
	}

	public boolean delete(int ID) {
		if (DB_Server.getPOIbyId(ID) != null) {
			return DB_Server.eliminarPOI(ID);
		} else
			return false;
	}

	public boolean modificar(POI_DTO dto) {
		POI poi = null;
		poi = DB_Server.getPOIbyId(dto.getId());
		if (poi != null) {
			poi.setDatos(dto);
			return true;
		}
		return false;
	}
	
	public ArrayList<POI> buscar(String url,String texto1, String texto2) throws JSONException, MalformedURLException, IOException{
		resultado = new ArrayList<POI>();
		ArrayList<POI> listaLocal = DB_Server.getListado();
		for(POI nodo : listaLocal){
			if(nodo.busquedaEstandar(texto1, texto2)){
				resultado.add(nodo);
			}
		}
		if(url != ""){
			List<POI> listaExterna = new ArrayList<POI>();
			if(texto1 != ""){
				listaExterna = BusquedaDePOIsExternos.buscarPOIsExternos(url, texto1);//cgp con 1er string
				if(!(listaExterna.isEmpty())){
					resultado.addAll(listaExterna);
				}
			}
			if(texto2 != ""){
				listaExterna = BusquedaDePOIsExternos.buscarPOIsExternos(url, texto2);//cgp con 2do string
				if(!(listaExterna.isEmpty())){
					resultado.addAll(listaExterna);
				}
			}
			
			
			listaExterna = BusquedaDePOIsExternos.buscarPOIsExternos(url, texto1, texto2);//bancos
			if(!(listaExterna.isEmpty())){
				resultado.addAll(listaExterna);
			}
		}
		
		
		return resultado;
	}
}
