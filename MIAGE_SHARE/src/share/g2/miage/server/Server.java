package share.g2.miage.server;

import share.g2.miage.server.ServerChat;
import share.g2.miage.server.ServerFichier;

/**
 * Server est la classe contenant la m�thode main permettant de mettre en route 
 * les serveurs de gestions des fichiers ainsi que celui du chats.
 *
 */
public class Server {

	/**
	 * Constructeur qui permet de mettre en route les serveurs de fichiers et de chats.
	 
	 * 
	 * @throws Exception Si un probl�me est apparu lors du lancement du serveur
	 */
	public Server(){
		new ServerFichier();
		new ServerChat();
		
	}

}
