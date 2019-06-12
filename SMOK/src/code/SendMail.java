package code;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main (String[] args) {
		
		final String username ="smok.unipr@gmail.com";
		final String password = "Knk20192019";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smok.unipr@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("smok.unipr@gmail.com"));
			message.setSubject("REGJISTRIMI ");
			message.setText("Ckemiiiiiii!");
			
			Transport.send(message);
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
			
		}
		
		
		
		
		
		
		
		
	}
}
