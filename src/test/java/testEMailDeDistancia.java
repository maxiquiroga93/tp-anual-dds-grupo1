import javax.mail.MessagingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import EMail.EnviarEmail;


public class testEMailDeDistancia {
	boolean envio;
	EnviarEmail email;
	
	@Before
	public void init(){
		email =new EnviarEmail();
	
}
	
	@Test
	public void modificacionBanco() throws MessagingException{
		
		//PONER LA BUSQUEDA QUE SE REALIZO Y SU TIEMPO
		envio=email.mandarCorreoXSegundos("busquedaRubroAAAA", 3333.2);
		Assert.assertTrue(envio);
	}
}
