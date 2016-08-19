package EMail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class EMail {

	
	
 
	
	
		//Cuenta creada Gmail
		//Usuario:SistemasDDSGrupo1@gmail.com Contraseña:DDSGrupo1 ContraseñaDeAplicacion:nhxnogsxyobwwbzl	
		//
		
	
	public boolean mandarCorreo(String texto) {
		  // El correo gmail de envío
		  String correoEnvia = "SistemasDDSGrupo1@gmail.com";
		  String claveCorreo = "nhxnogsxyobwwbzl";
		  String correoRecibe="lag21392@gmail.com";
		 
		  // La configuración para enviar correo
		  Properties properties = new Properties();
		  properties.put("mail.smtp.host", "smtp.gmail.com");
		  properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.port", "589");
		  properties.put("mail.smtp.auth", "true");
		  properties.put("mail.user", correoEnvia);
		  properties.put("mail.password", claveCorreo);
		 
		  // Obtener la sesion
		  try {Session session = Session.getInstance(properties, null);
	
		 
		 
		   // Crear el cuerpo del mensaje
		   MimeMessage mimeMessage = new MimeMessage(session);
		 
		   // Agregar quien envía el correo
		   mimeMessage.setFrom(new InternetAddress(correoEnvia, "DDS Grupo 1"));
		    
		   // Los destinatarios
		   InternetAddress[] internetAddresses = {
		     new InternetAddress(correoRecibe)/*,
		     new InternetAddress("correo2@gmail.com"),
		     new InternetAddress("correo3@gmail.com") */};
		 
		   // Agregar los destinatarios al mensaje
		   mimeMessage.setRecipients(Message.RecipientType.TO,
		     internetAddresses);
		 
		   // Agregar el asunto al correo
		   mimeMessage.setSubject("Demora En Segundos");
		 
		   // Creo la parte del mensaje
		   MimeBodyPart mimeBodyPart = new MimeBodyPart();
		   mimeBodyPart.setText( texto);
		 
		   // Crear el multipart para agregar la parte del mensaje anterior
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(mimeBodyPart);
		 
		   // Agregar el multipart al cuerpo del mensaje
		   mimeMessage.setContent(multipart);
		 
		   // Enviar el mensaje
		   Transport transport = session.getTransport("smtp");
		   transport.connect(correoEnvia, claveCorreo);
		   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		   transport.close();
		 
		  } catch (Exception ex) {
		   ex.printStackTrace();
		   return false;
		  }
		  System.out.println("Correo enviado");
		return true;
		 }
		 
		/* public static void main(String[] args) {
		  EMail correoTexto = new EMail();
		  correoTexto.mandarCorreo();
		   
		 }*/
		}