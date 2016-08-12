package POI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;

import ABMC.POI_DTO;
import DTOs.Banco_Converter;
import DTOs.CGP_Converter;

public class BusquedaDePOIsExternos {
	
	
	
	public static  List<POI_DTO> buscarPOIsExternos(String url,String textoLibre1,String textoLibre2) throws JSONException, MalformedURLException, IOException
	{
		String urlCreada;
		List<POI_DTO> listaResultado=null;
		
		//nombre de banco y servicio
		//http://trimatek.org/Consultas/banco?banco=Santander&servicio=Pagos
		urlCreada=url+"banco?banco="+textoLibre1+"&servicio="+textoLibre2;
		
		listaResultado=Banco_Converter.getBancos(urlCreada);
		
		
		return listaResultado;
	}


@SuppressWarnings("null")
public static  List<POI_DTO> buscarPOIsExternos(String url,String textoLibre1) throws JSONException, MalformedURLException, IOException{
	String urlCreada;
	List<POI_DTO> listaResultado=null;
	List<POI>	listaResultadoEnPOI=null;
	POI poi;
		//nombre calle o zona
		//http://trimatek.org/Consultas/centro?zona=Boedo
		//http://trimatek.org/Consultas/centro?domicilio=
		urlCreada=url+"centro?zona="+textoLibre1;
		listaResultado=CGP_Converter.getCGPs(urlCreada);
		if(listaResultado==null){
			urlCreada=url+"centro?domicilio="+textoLibre1;
			listaResultado=CGP_Converter.getCGPs(urlCreada);
			}
		
		System.out.println(urlCreada);
		
		//convertimos a lista de pois
		System.out.println(listaResultado.size());
		for (POI_DTO poi_dto:listaResultado){
			poi_dto.setTipo(TiposPOI.CGP);
			//probando como convierte
			poi=poi_dto.converttoPOI();
			
			System.out.println(poi.tipo);
			listaResultadoEnPOI.add(poi);
			System.out.println(listaResultadoEnPOI.size());
		}
		
		
		return listaResultado;
	}

}
