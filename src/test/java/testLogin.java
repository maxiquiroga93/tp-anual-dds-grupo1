import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import Autentificacion.AuthAPI;
import Autentificacion.Usuario;

public class testLogin {
	
	Usuario prueba;
	AuthAPI Autenticador;
	
	@Before
	public void init(){
		prueba = new Usuario();
		prueba.setID(1);
		prueba.setPassword("password");
		prueba.setUsername("usuario");
		
		Autenticador = new AuthAPI();
		
	}
	
	@Test
	public void probarHasherLongitud() throws NoSuchAlgorithmException{
		String hash = Autenticador.hashear(prueba.getPassword());
		Assert.assertEquals(64, hash.length());
	}
	
	@Test
	public void probarHasherIgualdad() throws NoSuchAlgorithmException{
		String hash = Autenticador.hashear(prueba.getPassword());
		
		Assert.assertTrue(hash.equals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8".toUpperCase()));
	}
	
	@Test
	public void probarTokenLongitud() throws NoSuchAlgorithmException{
		String token = Autenticador.generarToken(prueba.getUsername(),Autenticador.hashear(prueba.getPassword()));
		
		Assert.assertEquals(64, token.length());
	}
	
	@Test
	public void probarRandomToken() throws NoSuchAlgorithmException, InterruptedException{
		String token1 = Autenticador.generarToken(prueba.getUsername(), Autenticador.hashear(prueba.getPassword()));
		TimeUnit.SECONDS.sleep(3); // espero a que cambie la hora
		String token2 = Autenticador.generarToken(prueba.getUsername(), Autenticador.hashear(prueba.getPassword()));
		
		Assert.assertFalse(token1.equals(token2));
	}
	
	

}