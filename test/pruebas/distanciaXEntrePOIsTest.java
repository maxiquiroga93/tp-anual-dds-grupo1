package pruebas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import POI.POI;


public class distanciaXEntrePOIsTest {
	private POI poiUno ;
	private POI poiDos;
	@Before
	public void init() {
		POI poiUno = new POI();
		POI poiDos = new POI();
		
		poiUno.setLatitud(-34.5664823);
		poiUno.setLongitud(-58.43407810000002) ;
		
		
		poiDos.setLatitud(-34.5658341);
		poiDos.setLongitud(-58.43519549999996) ;
		
	}
	@Test
	public void testeodistanciavenora3()
	{
		
		
		Assert.assertTrue(poiUno.estaXMetrosDePOI(2000000,poiDos));
	}

}
