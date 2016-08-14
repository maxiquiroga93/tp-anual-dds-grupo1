import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Helpers.LevDist;
import POI.POI;



public class levTest {
	String a,b,c,d;
	int resultado;
	@Before
	public void inicializar(){
		a = "Esto es una prueba";
		b = "Exto es una prueba";
		c = "Exto es una prueva";
	}
	
	
	@Test
	public void testSinDiferencias(){
		resultado = LevDist.calcularDistancia(a,a);
		Assert.assertEquals(resultado,0);
			
	}
	
	@Test
	public void test1Diferencia(){
		resultado = LevDist.calcularDistancia(a,b);
		Assert.assertEquals(resultado,1);
			
	}
	
	@Test
	public void test2Diferencias(){
		resultado = LevDist.calcularDistancia(a,c);
		Assert.assertEquals(resultado,2);
			
	}
	
	@Test
	public void testNull(){
		resultado = LevDist.calcularDistancia(a,d);
		Assert.assertEquals(resultado,10);
			
	}
}
