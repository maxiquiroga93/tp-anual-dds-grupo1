package EMail;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class EnviarEmail {
	// Enviar correo
	// * 
	// * @Dirección de correo electrónico, correo Param
	// * @Param title título Correo
	// * @Param Content mensajes de texto
	// * @param nickName
	// *  El apodo de visualización
	
	public void sendMail(String email, String title, String content, String nickName) {
		 String correoEnvia = "SistemasDDSGrupo1@gmail.com";
		  String claveCorreo = "nhxnogsxyobwwbzl";
		  String correoRecibe=email;
		try {
			// El correo sesión
			Properties props = new Properties();
			// Información del servidor de correo de almacenamiento
			props.put("mail.smtp.host", correoEnvia);
			// Al mismo tiempo, a través de la verificación
			props.put("mail.smtp.auth", "true");
			// Según la naturaleza de la construcción de un nuevo correo sesión
			Session mailSession = Session.getInstance(props);
			// Nueva sesión un mensaje por correo de objetos
			MimeMessage message = new MimeMessage(mailSession);
			// Configuración de correo
			String nick = javax.mail.internet.MimeUtility.encodeText(nickName);
			// Preferencias de la dirección del remitente
			message.setFrom(new InternetAddress(nick + "<" + correoRecibe + ">"));
			// Preferencias de los beneficiarios, y fijar su tipo de recepción para to
			InternetAddress to = new InternetAddress(email);
			message.setRecipient(Message.RecipientType.TO, to);
			// Preferencias de la partida
			message.setSubject(title);
			// Establecer el contenido de la Carta,
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			// Contenido
			mbp1.setText(content);
			mp.addBodyPart(mbp1);
			// Preferencias del Anexo
			message.setContent(mp, "text/html;charset=UTF-8");
			// Está escrito
			message.setSentDate(new Date());
			// El almacenamiento electrónico de la información
			message.saveChanges();
			// Enviar correo
			Transport transport = mailSession.getTransport("smtp");
			// A modo de registro SMTP buzón, el primer parámetro es enviar un correo con la dirección de correo del servidor SMTP. El segundo parámetro para el nombre de usuario y contraseña para el tercer parámetro
			transport.connect(correoEnvia, correoRecibe, claveCorreo);
			// Enviar mensajes de correo electrónico, de los cuales el segundo parámetro es todo lo que se ha establecido en virtud de la buena dirección del destinatario
			transport.sendMessage(message, message.getAllRecipients());
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
