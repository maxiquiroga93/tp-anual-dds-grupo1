import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import ABMC.POI_ABMC;
import POI.Banco;

public class testABMC {
	
	POI_ABMC abmc = new POI_ABMC();
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void altaBanco(){
		
	}
	
	@Test
	public void altaCGP(){
		
	}
	
	@Test
	public void altaLocalComercial(){
		
	}
	
	@Test
	public void altaParadaColectivo(){
		
	}

	@Test
	public void modificarBanco(){
		
	}
	
	@Test
	public void modificarCGP(){
		
	}
	
	@Test
	public void modificarLocalComercial(){
		
	}
	
	@Test
	public void modificarParadaColectivo(){
		
	}

	@Test
	public void borrarBanco(){
		
	}
	
	@Test
	public void borrarCGP(){
		
	}
	
	@Test
	public void borrarLocalComercial(){
		
	}
	
	@Test
	public void borrarParadaColectivo(){
		
	}

	@Test
	public void consultarBanco() throws JSONException, MalformedURLException, IOException{
		//Banco bancoEsperado = new Banco("Santander Rio", 1234.0, 1234.0);
		List<Banco> bancos = abmc.consultarBancos("http://trimatek.org/Consultas/banco?banco=Santander&servicio=Pagos");
		assertTrue(bancos.size() == 1);
		//assertTrue(bancos.get(0).equals(bancoEsperado));
	}
	
	@Test
	public void consultarCGP(){
		
	}
	
	@Test
	public void consultarLocalComercial(){
		
	}
	
	@Test
	public void consultarParadaColectivo(){
		
	}
}
