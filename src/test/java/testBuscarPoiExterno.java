import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import ABMC.POI_DTO;
import POI.BusquedaDePOIsExternos;
import POI.POI;
import POI.TiposPOI;



public class testBuscarPoiExterno {

	
	
	@Test
	public void testBuscarPOIsExternosBanco() throws JSONException, MalformedURLException, IOException{
		String var1 = "Santander";
		String var2 = "Pagos";
		List<POI> listaResultado1=null;
		List<POI> listaResultado2=null;
		listaResultado1=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		listaResultado2=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var2,var1);
		Assert.assertTrue(listaResultado1.size()==1);
		Assert.assertTrue(listaResultado2.size()==1);
		Assert.assertTrue( listaResultado1.size()==listaResultado2.size());
		
		
	}
	@Test
	public void testBuscarPOIsExternosBancoNull() throws JSONException, MalformedURLException, IOException{
		String var1 = null;
		String var2 = null;
		List<POI> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		Assert.assertTrue(listaResultado.size()==0);
	}
	@Test
	public void testBuscarPOIsExternosCGP() throws JSONException, MalformedURLException, IOException{
		String var1 = "Boedo";
		
		List<POI> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1);
		
		Assert.assertTrue(listaResultado.size()==16);
	}
	@Test
	public void testBuscarPOIsExternosCGPNull() throws JSONException, MalformedURLException, IOException{
		String var1 = null;
		
		List<POI> listaResultado=null;
		listaResultado=BusquedaDePOIsExternos.buscarPOIsExternos("http://trimatek.org/Consultas/",var1);
		
		Assert.assertTrue(listaResultado.size()==0);
	}
}
