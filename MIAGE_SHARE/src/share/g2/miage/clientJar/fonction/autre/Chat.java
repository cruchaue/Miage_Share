package share.g2.miage.clientJar.fonction.autre;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.autre.interne.FenetreChat;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;

/**
 * Permet l'envoi de mail depuis le serveur jusqu'a un ou des clients cibles.
 * 
 * Cette classse peut etre utilis� dans le cas d'envoi de notifications lors de 
 * changement sur un fichier par exemple.
 *
 */

public  class Chat extends FonctionClient<FenetreChat> {
	
	private String userNom;
	
	/**
	 * demarre l'action "suppression d'un utilisateur"
	 */
	public Chat() {
		super();
		demarrer();
	}
	
	/**
	 * lance l'envoie de mail depuis le serveur vers un client cible
	 * 
	 * @param mail
	 * 			mail du client cible
	 */
	public Chat(String userNom){
		this.userNom = userNom;
	}

	@Override
	public int commExecuter1() {
		this.resultat3 = new FenetreChat(userNom);
		return 1;
	}
}
