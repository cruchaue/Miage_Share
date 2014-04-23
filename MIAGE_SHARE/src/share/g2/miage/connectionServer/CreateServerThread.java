package share.g2.miage.connectionServer;

import java.io.*;
import java.net.*;

import share.g2.miage.connectionClient.chat.EnvoyerMessage;
import share.g2.miage.connectionServer.chat.DistribuerMessage;
import share.g2.miage.connectionServer.chat.RecupererMessage;
import share.g2.miage.connectionServer.fonction.*;
import share.g2.miage.util.ParametrePublique;

//--- CreateServerThread
class CreateServerThread extends Thread {
	private ClientS clients;
	private FonctionServerFichier fsf;

	public CreateServerThread(Socket s) throws IOException {
		clients = new ClientS();
		clients.setClient(s);
		clients.setDis(new DataInputStream(s.getInputStream()));
		clients.setDos(new DataOutputStream(s.getOutputStream()));
		clients.setBis(new BufferedInputStream(s.getInputStream()));
		clients.setBos(new BufferedOutputStream(s.getOutputStream()));
		clients.setInetAdr(s.getInetAddress());
		
		start();
	}

	public void run() {
		try {
			
			
				String strFonction = clients.getDis().readUTF();
				System.out.println("---  ---"+strFonction);
				if (ParametrePublique.UPLOAD_FICHIER.equals(strFonction)) {
					fsf = new AccepterFichier();
					fsf.excuter(clients);
					
				}else if(ParametrePublique.TELECHARGER_FICHIER.equals(strFonction)){
					fsf = new EnvoyerFichier();
					fsf.excuter(clients);
				}else if(ParametrePublique.SUPPRIMER_FICHIER.equals(strFonction)){
					fsf = new SupprimerFichier();
					fsf.excuter(clients);
				}else if(ParametrePublique.LOGIN.equals(strFonction)){
					fsf = new Login();
					fsf.excuter(clients);
				}else if(ParametrePublique.LIRE_FICHIER_INFO.equals(strFonction)){
					fsf = new EnvoyerFichierInfo();
					fsf.excuter(clients);
				}else if(ParametrePublique.COMMENTER_FICHIER.equals(strFonction)){
					fsf = new CommenterFichier();
					fsf.excuter(clients);
				}else if(ParametrePublique.DISTRIBUER_MESSAGE.equals(strFonction)){
					fsf = new DistribuerMessage();
					fsf.excuter(clients);
				}else if(ParametrePublique.ENVOYER_MESSAGE.equals(strFonction)){
					fsf = new RecupererMessage();
					fsf.excuter(clients);
				}else if(ParametrePublique.CREER_UTILISATEUR.equals(strFonction)){
					fsf = new CreerUtilisateur();
					fsf.excuter(clients);
				}else if(ParametrePublique.GET_FICHIER_LIST.equals(strFonction)){
					fsf = new EnvoyerFichierList();
					fsf.excuter(clients);
				}
				
				
			
		} catch (IOException e) {
		}
	}

	
}
