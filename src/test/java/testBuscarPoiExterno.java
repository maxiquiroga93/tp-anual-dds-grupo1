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
import POI.TiposPOI;


public class testBuscarPoiExterno {
	Banco unBanco;
	CGP unCGP;
	@Before
	public void init() throws JSONException, MalformedURLException, IOException{
	unBanco = new Banco("unBanco", 1, 1); 
	unBanco.setTipo(TiposPOI.BANCO);
	unCGP = new CGP("unCGP", 1, 1); 
	unCGP.setTipo(TiposPOI.CGP);	
		
	}
	
	
	@Test
	public void testBuscarPOIsExternosBanco() throws JSONException, MalformedURLException, IOException{
		String var1 = "Santander";
		String var2 = "Pagos";
		List<POI_DTO> listaResultado=null;
		listaResultado=unBanco.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		System.out.println(listaResultado.size());
		Assert.assertTrue(listaResultado.size()==1);
	}
	@Test
	public void testBuscarPOIsExternosCGP() throws JSONException, MalformedURLException, IOException{
		String var1 = "Boedo";
		String var2 = "";
		List<POI_DTO> listaResultado=null;
		listaResultado=unCGP.buscarPOIsExternos("http://trimatek.org/Consultas/",var1,var2);
		System.out.println(listaResultado.size());
		Assert.assertTrue(listaResultado.size()==1);
	}
}
