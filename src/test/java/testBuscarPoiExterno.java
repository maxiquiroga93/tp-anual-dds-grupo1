import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import ABMC.POI_DTO;
import POI.BusquedaDePOIsExternos;



public class testBuscarPoiExterno {

	
	
	@Test
	public void testBuscarPOIsExternosBanco() throws JSONException, MalformedURLException, IOException{
		String var1 = "Santander";
		String var2 = "Pagos";
		List<POI_DTO> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		System.out.println(listaResultado.size());
		Assert.assertTrue(listaResultado.size()==1);
	}
	@Test
	public void testBuscarPOIsExternosCGP() throws JSONException, MalformedURLException, IOException{
		String var1 = "Boedo";
		
		List<POI_DTO> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1);
		System.out.println(listaResultado.size());
		Assert.assertTrue(listaResultado.size()==1);
	}
}
