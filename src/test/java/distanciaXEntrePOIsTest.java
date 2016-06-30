import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DB.DB_Server;
import POI.CGP;
import POI.POI;


public class distanciaXEntrePOIsTest {
	public POI poiUno ;
	public POI poiDos;
	
	@Before
	public void init() {
		 poiUno = CGP.ConstructorCGP("poiUno", -34.5664823, -58.43407810000002);
		 poiDos = CGP.ConstructorCGP("poiDos", -34.5658341, -58.43519549999996);
	}
	
	/*
	 Dado que todos los hijos de POI utilizan la misma definicion para el metodo 
	  "estaXMetrosDePOI()" solo se realizo test unitario con una sola clase
	*/
	@Test
	public void testeodistanciavenora3()
	{
		Assert.assertTrue(poiUno.estaXMetrosDePOI(2000000,poiDos));
	}
	
	@Test
	public void testRapiditoComoVos_Gil(){
		DB_Server server = new DB_Server();
		server.getAllLocalesByRubro("unStringGato");
	}
}
