package ABMC;

import java.util.ArrayList;

import DB.DB_Server;
import POI.Banco;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.ParadaColectivo;
import POI.TiposPOI;

public class POI_ABMC {

	public boolean alta(POI_DTO dto){
		POI nuevoPOI = null;

		if(dto.getTipo().equals(TiposPOI.CGP)){
			nuevoPOI = new CGP(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
			((CGP)nuevoPOI).setDatos(dto);
		}
		else if (dto.getTipo().equals(TiposPOI.LOCAL_COMERCIAL)){
			nuevoPOI = new LocalComercial(dto.getNombre(), dto.getLatitud(), dto.getLongitud(), dto.getRubro());
			((LocalComercial)nuevoPOI).setDatos(dto, true);
		}
		else if (dto.getTipo().equals(TiposPOI.BANCO)){
			nuevoPOI = new Banco(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
		}
		else if (dto.getTipo().equals(TiposPOI.PARADA_COLECTIVO)){
			nuevoPOI = new ParadaColectivo(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
		} 

		if(nuevoPOI.equals(null)){
			return false;
		} else {
			DB_Server.agregarPOI(nuevoPOI);
			return true;
		}
	}

	public boolean delete(POI_DTO dto){
		if(DB_Server.getPOIbyId(dto.getId()) != null){
			return DB_Server.eliminarPOI(dto.getId());
		}
		else 
			return false;
	}

	public boolean modificar(POI_DTO dto){
		POI poi = null;
		poi = DB_Server.getPOIbyId(dto.getId());
		if(poi != null){
			poi.setDatos(dto);
		}
		return false;
	}

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
	
	public ArrayList<POI> busquedaExterna(String cadena1, String cadena2, TiposPOI tipo){
		if(tipo.equals(TiposPOI.CGP)){
			//ACA ADENTRO SE HACE LA BUSQUEDA DE CGP Y BANCO CON LA API, NO SE COMO SE HACE.
			
		}
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
