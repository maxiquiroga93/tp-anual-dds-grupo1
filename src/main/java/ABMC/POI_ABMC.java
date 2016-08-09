package ABMC;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DB.DB_Server;
import POI.Banco;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.ParadaColectivo;
import POI.TiposPOI;
import userInterface.Buscador;

public class POI_ABMC {

	private ArrayList<POI> resultado;

	public boolean alta(POI_DTO dto) {
		POI nuevoPOI = null;

		if (dto.getTipo().equals(TiposPOI.CGP)) {
			nuevoPOI = new CGP(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
			((CGP) nuevoPOI).setDatos(dto);
		} else if (dto.getTipo().equals(TiposPOI.LOCAL_COMERCIAL)) {
			nuevoPOI = new LocalComercial(dto.getNombre(), dto.getLatitud(), dto.getLongitud(), dto.getRubro());
			((LocalComercial) nuevoPOI).setDatos(dto, true);
		} else if (dto.getTipo().equals(TiposPOI.BANCO)) {
			nuevoPOI = new Banco(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
		} else if (dto.getTipo().equals(TiposPOI.PARADA_COLECTIVO)) {
			nuevoPOI = new ParadaColectivo(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
		}

		if (nuevoPOI.equals(null)) {
			return false;
		} else {
			DB_Server.agregarPOI(nuevoPOI);
			return true;
		}
	}

	public boolean delete(double ID) {
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
		}
		return false;
	}

	public ArrayList<POI> consultaLocal(String busqueda) {
		resultado = new ArrayList<POI>();
		ArrayList<POI> listado = DB_Server.getListado();
		for (int i = 0; i < listado.size(); i++) {
			POI nodo = listado.get(i);
			POI match = cumple(nodo,busqueda,nodo.getTipo());
			if(!(match == null)){
				resultado.add(match);
			}
		}
		return resultado;

	}

	public POI cumple(POI nodo, String busqueda, TiposPOI tipo) {
		if (busqueda == nodo.getBarrio() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getCalleLateral() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getCallePrincipal() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getDepartamento() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getLocalidad() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getNombre() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getPais() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getProvincia() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (busqueda == nodo.getUnidad() && tipo == nodo.getTipo()) {
			return nodo;
		} else if (Buscador.isNumeric(busqueda)){
			if(Integer.parseInt(busqueda) == nodo.getCercania() && tipo == nodo.getTipo()) {
				return nodo;
			} else if (Integer.parseInt(busqueda) == nodo.getCodigoPostal() && tipo == nodo.getTipo()) {
				return nodo;
			} else if (Integer.parseInt(busqueda) == nodo.getComuna() && tipo == nodo.getTipo()) {
				return nodo;
			} else if (Integer.parseInt(busqueda) == nodo.getNumeracion() && tipo == nodo.getTipo()) {
				return nodo;
			} else if (Integer.parseInt(busqueda) == nodo.getPiso() && tipo == nodo.getTipo()) {
				return nodo;
			}
		}
		return null;
	}


}
