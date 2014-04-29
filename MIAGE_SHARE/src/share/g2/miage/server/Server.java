package share.g2.miage.server;

import share.g2.miage.server.ServerChat;
import share.g2.miage.server.ServerFichier;

public class Server {


	public static void main(String[] args) throws Exception {
		new ServerFichier();
		new ServerChat();
		
		//FonctionServerFichier fsf = new AccepterFichier();
		//fsf.excuter(server);
		
	}

}
