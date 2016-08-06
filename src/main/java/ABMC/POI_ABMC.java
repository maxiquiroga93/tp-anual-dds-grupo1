package ABMC;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class POI_ABMC {

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

	public boolean delete(POI_DTO dto) {
		if (DB_Server.getPOIbyId(dto.getId()) != null) {
			return DB_Server.eliminarPOI(dto.getId());
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
	
	public ArrayList<POI> consultaLocal(String busqueda){
		ArrayList<POI> resultado;
		for(int i = 0; i < DB_Server.getListado().size(); i++){
			
		}
		return resultado;
		
	}

	public List<Banco> consultarBancos(String url) throws JSONException, MalformedURLException, IOException {
		// Obtengo el array que me devuelve el JSON
		JSONArray jsonArray = new JSONArray(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
		List<Banco> listadoBancos = new ArrayList<Banco>();

		// Recorro el array obtenido
		for (int i = 0, size = jsonArray.length(); i < size; i++) {
			JSONObject objetoInterno = jsonArray.getJSONObject(i);

			// obtengo los componentes y sus valores.
//					String valor = objetoInterno.getString(nombre);
					System.out.println("banco: " + objetoInterno.getString("banco"));
					System.out.println("sucursal: " + objetoInterno.getString("sucursal"));
					System.out.println("gerente: " + objetoInterno.getString("gerente"));
					System.out.println("x: " + objetoInterno.getDouble("x"));
					System.out.println("y: " + objetoInterno.getDouble("y"));
					System.out.println("servicios: " + objetoInterno.getJSONArray("servicios"));
					
					Banco nuevoBanco = new Banco(objetoInterno.getString("banco"),objetoInterno.getDouble("x"),
							objetoInterno.getDouble("y"));
					
					listadoBancos.add(nuevoBanco);

			}
			// Creo POI y lo guardo en el listado que devuelvo
			// nombre, latitud y longitud.
//			Banco banco = new Banco(valores.get("banco"), Long.parseLong(valores.get("x")),
//					Long.parseLong(valores.get("y")));
//			listadoBancos.add(banco);


		return listadoBancos;
	}

	// TODO Falta crear servicios y agregarlos al CGP si corresponde. (ver comuna 1)
	
	public List<CGP> consultarCentros(String url) throws JSONException, MalformedURLException, IOException {
		// Obtengo el array que me devuelve el JSON
		JSONArray jsonArray = new JSONArray(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
		List<CGP> listadoCGP = new ArrayList<CGP>();

		// Recorro el array obtenido
		for (int i = 0, size = jsonArray.length(); i < size; i++) {
			JSONObject objetoInterno = jsonArray.getJSONObject(i);

			// obtengo los componentes y sus valores.
//					String valor = objetoInterno.getString(nombre);
					System.out.println("comuna: " + objetoInterno.getInt("comuna"));
					System.out.println("zonas: " + objetoInterno.getString("zonas"));
					System.out.println("director: " + objetoInterno.getString("director"));
					System.out.println("domicilio: " + objetoInterno.getString("domicilio"));
					System.out.println("telefono: " + objetoInterno.getString("telefono"));
					System.out.println("servicios: " + objetoInterno.getJSONArray("servicios"));
					
				//	Creamos el CGP usando latitud y longitud hardcodeada por faltar en servicios API
					CGP nuevoCGP = new CGP(String.valueOf(objetoInterno.getInt("comuna")),-34,-58);
					
					listadoCGP.add(nuevoCGP);

			}

		return listadoCGP;
	}
	
}
