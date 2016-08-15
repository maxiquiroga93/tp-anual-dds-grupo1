package DB;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import POI.POI;

public class DB_HistorialBusquedas {

	private Map<Long,registroHistorico> listadoRegistros = new HashMap<Long,registroHistorico>();
	
	private static DB_HistorialBusquedas instance = null;

	public DB_HistorialBusquedas() {
		listadoRegistros = new HashMap<Long,registroHistorico>();
	}

	public Map<Long,registroHistorico> getListado() {
		return instance.listadoRegistros;
	}

	public DB_HistorialBusquedas getInstance() {
		if (instance == null)
			instance = new DB_HistorialBusquedas();
		return instance;
	}


	public void agregarHistorialBusqueda(registroHistorico registro){
		// TODO revisar
		listadoRegistros.put(Long.parseLong(Integer.toString(listadoRegistros.size())),registro);
	}

// Reporte de busquedas por fecha y cantidad de todo el sistema	
	public ArrayList<registroHistorico> reporteBusquedas(String criterioConsulta) {

	}
	
	
}
