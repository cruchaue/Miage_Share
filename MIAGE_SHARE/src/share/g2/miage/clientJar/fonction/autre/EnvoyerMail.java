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
 * Permet l'envoi de mail depuis le serveur jusqu'a un ou des clients cibles.
 * 
 * Cette classse peut etre utilisé dans le cas d'envoi de notifications lors de 
 * changement sur un fichier par exemple.
 *
 */

public  class EnvoyerMail<T> extends FonctionClient<T> {
	
	/**
	 * lance l'envoie de mail depuis le serveur vers un client cible
	 * 
	 * @param mail
	 * 			mail du client cible
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
			message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return 1;
	}
}