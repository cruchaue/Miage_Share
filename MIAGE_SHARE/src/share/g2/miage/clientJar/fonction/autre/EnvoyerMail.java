package share.g2.miage.clientJar.fonction.autre;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;

/**
 * 
 *
 */

public  class EnvoyerMail<T> extends FonctionClient<T> {

	/**
	 * 
	 * @param mail
	 */
	public EnvoyerMail(String mail) {
		super();
		parametre1 = mail;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		final String username = "easy.share.miage@gmail.com";
		final String password = "123easy456";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("easy.share.miage@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(parametre1));
			message.setSubject("Easy share notification");
			message.setText("Chère collaborateur,"
					+ "\n\n Un document à été uplodadé sur le serveur !");

			Transport.send(message);



		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return 1;
	}
}