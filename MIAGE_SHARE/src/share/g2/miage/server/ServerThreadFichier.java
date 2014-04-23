package share.g2.miage.server;

import java.io.*;
import java.net.*;

import share.g2.miage.server.fonction.*;
import share.g2.miage.server.chat.DistribuerMessage;
import share.g2.miage.server.chat.RecupererMessage;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.fonction.AccepterFichier;
import share.g2.miage.server.fonction.CommenterFichier;
import share.g2.miage.server.fonction.CreerUtilisateur;
import share.g2.miage.server.fonction.EnvoyerFichier;
import share.g2.miage.server.fonction.EnvoyerFichierInfo;
import share.g2.miage.server.fonction.EnvoyerFichierList;
import share.g2.miage.server.fonction.Login;
import share.g2.miage.server.fonction.SupprimerFichier;
import share.g2.miage.server.fonction.interfaces.FonctionServer;
import share.g2.miage.util.Parametre;

//--- CreateServerThread
class ServerThreadFichier extends Thread {
	private ClientS clients;
	private FonctionServer fsf;

	public ServerThreadFichier(Socket s) throws IOException {
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
				if (Parametre.UPLOAD_FICHIER.equals(strFonction)) {
					fsf = new AccepterFichier();
					fsf.excuter(clients);
					
				}else if(Parametre.TELECHARGER_FICHIER.equals(strFonction)){
					fsf = new EnvoyerFichier();
					fsf.excuter(clients);
				}else if(Parametre.SUPPRIMER_FICHIER.equals(strFonction)){
					fsf = new SupprimerFichier();
					fsf.excuter(clients);
				}else if(Parametre.LOGIN.equals(strFonction)){
					fsf = new Login();
					fsf.excuter(clients);
				}else if(Parametre.LIRE_FICHIER_INFO.equals(strFonction)){
					fsf = new EnvoyerFichierInfo();
					fsf.excuter(clients);
				}else if(Parametre.COMMENTER_FICHIER.equals(strFonction)){
					fsf = new CommenterFichier();
					fsf.excuter(clients);
				}else if(Parametre.DISTRIBUER_MESSAGE.equals(strFonction)){
					fsf = new DistribuerMessage();
					fsf.excuter(clients);
				}else if(Parametre.ENVOYER_MESSAGE.equals(strFonction)){
					fsf = new RecupererMessage();
					fsf.excuter(clients);
				}else if(Parametre.CREER_UTILISATEUR.equals(strFonction)){
					fsf = new CreerUtilisateur();
					fsf.excuter(clients);
				}else if(Parametre.GET_FICHIER_LIST.equals(strFonction)){
					fsf = new EnvoyerFichierList();
					fsf.excuter(clients);
				}
				
				
			
		} catch (IOException e) {
		}
	}

	
}
