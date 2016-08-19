import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import EMail.EMail;


public class testEMailDeDistancia {
	boolean envio;
	EMail email;
	
	@Before
	public void init(){
		email =new EMail();
	
}
	
	@Test
	public void modificacionBanco(){
		
		//envio=email.enviarEmailDemoraDeXSegundos(2);
		envio=email.mandarCorreo("Hola");
		Assert.assertTrue(envio);
	}
}
