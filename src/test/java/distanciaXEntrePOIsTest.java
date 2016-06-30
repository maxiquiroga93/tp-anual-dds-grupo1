import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import POI.POI;


public class distanciaXEntrePOIsTest {
	public POI poiUno ;
	public POI poiDos;
	
	@Before
	public void init() {
		 poiUno = POI.construirPOI(-34.5664823, -58.43407810000002);
		 poiDos = POI.construirPOI(-34.5658341, -58.43519549999996);
		
		
	}
	@Test
	public void testeodistanciavenora3()
	{
		
		
		Assert.assertTrue(poiUno.estaXMetrosDePOI(2000000,poiDos));
		}
	

}
