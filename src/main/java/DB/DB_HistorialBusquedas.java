package DB;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import POI.POI;

public class DB_HistorialBusquedas {

	private Map<Long, registroHistorico> listadoRegistros = new HashMap<Long, registroHistorico>();

	private static DB_HistorialBusquedas instance = null;

	public DB_HistorialBusquedas() {
		listadoRegistros = new HashMap<Long, registroHistorico>();
	}

	public Map<Long, registroHistorico> getListado() {
		return instance.listadoRegistros;
	}

	public DB_HistorialBusquedas getInstance() {
		if (instance == null)
			instance = new DB_HistorialBusquedas();
		return instance;
	}

	public void agregarHistorialBusqueda(registroHistorico registro) {
		String registroStr = Integer.toString(listadoRegistros.size());
		listadoRegistros.put(Long.parseLong(registroStr), registro);
	}

	// Reporte de busquedas por fecha y cantidad de todo el sistema
	public Map<String, Long> reporteBusquedas(String criterioConsulta) {
		Map<String, Long> resumen = new HashMap<String, Long>();
		String fechaPrevia = "";
		Long cantParcial = 0L;
		for (Map.Entry<Long, registroHistorico> registro : listadoRegistros.entrySet()) {
			String fechaActual = registro.getValue().getTime().toString();
			if (fechaPrevia.equals(fechaActual)) {
				cantParcial += registro.getValue().getCantResultados();
			} else {
				resumen.put(fechaPrevia, cantParcial);
				fechaPrevia = fechaActual;
				cantParcial = registro.getValue().getCantResultados();
				
			}

		}

		return resumen;
	}

}
