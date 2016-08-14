import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import POI.BusquedaDePOIsExternos;
import POI.POI;



public class testBuscarPoiExterno {

	
	
	@Test
	public void testBuscarPOIsExternosBanco() throws JSONException, MalformedURLException, IOException{
		String var1 = "Santander";
		String var2 = "Pagos";
		List<POI> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		
		Assert.assertNotNull(listaResultado);
		
		
	}
	@Test
	public void testBuscarPOIsExternosBancoNull() throws JSONException, MalformedURLException, IOException{
		String var1 = "";
		String var2 = "";
		List<POI> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		Assert.assertTrue(listaResultado.isEmpty());
	}
	@Test
	public void testBuscarPOIsExternosCGP() throws JSONException, MalformedURLException, IOException{
		String var1 = "Boedo";
		
		List<POI> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1);
		
		Assert.assertNotNull(listaResultado);
	}
	@Test
	public void testBuscarPOIsExternosCGPNull() throws JSONException, MalformedURLException, IOException{
		String var1 = "";
		
		List<POI> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1);
		
		Assert.assertTrue(listaResultado.isEmpty());
	}
}
