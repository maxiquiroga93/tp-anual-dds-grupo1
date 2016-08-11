import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ABMC.POI_DTO;
import POI.Banco;
import POI.CGP;
import POI.POI;


public class testBuscarPoiExterno {
	Banco unBanco;
	@Before
	public void init() throws JSONException, MalformedURLException, IOException{
	unBanco = new Banco("unBanco", 1, 1); 
		
		
	}
	
	
	@Test
	public void testBuscarPOIsExternos() throws JSONException, MalformedURLException, IOException{
		String var1 = "Santander";
		String var2 = "Pagos";
		List<POI_DTO> listaResultado=null;
		listaResultado=unBanco.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		
		Assert.assertTrue(listaResultado.size()==1);
	}
}
