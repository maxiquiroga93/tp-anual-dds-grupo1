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
		System.out.println(urlCreada);
		listaResultado=Banco_Converter.getBancos(urlCreada);
		
		//busqueda calle y zona
		return listaResultado;
	}

public static  List<POI_DTO> buscarPOIsExternos(String url,String textoLibre1) throws JSONException, MalformedURLException, IOException{
	String urlCreada;
	List<POI_DTO> listaResultado=null;
		
		//nombre calle o zona
		//http://trimatek.org/Consultas/centro?zona=Boedo
		//http://trimatek.org/Consultas/centro?domicilio=
		urlCreada=url+"centro?zona="+textoLibre1;
		System.out.println(urlCreada);
		listaResultado=CGP_Converter.getCGPs(urlCreada);
		if(listaResultado==null){
			urlCreada=url+"centro?domicilio="+textoLibre1;
			System.out.println(url);
			listaResultado=CGP_Converter.getCGPs(urlCreada);
			}
		return listaResultado;
	}

}
