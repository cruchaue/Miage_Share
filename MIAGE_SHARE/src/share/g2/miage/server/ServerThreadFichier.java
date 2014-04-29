package share.g2.miage.server;

import java.io.*;
import java.net.*;

import share.g2.miage.server.fonction.*;
import share.g2.miage.server.fonction.generalite.FonctionServer;
import share.g2.miage.server.apresFonction.*;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.util.Parametre;

//--- CreateServerThread
class ServerThreadFichier extends Thread {
	private ClientS clients;
	private FonctionServer fs;

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
					fs = new ApresAccepterFichier(clients);
				}else if(Parametre.TELECHARGER_FICHIER.equals(strFonction)){
					fs = new ApresEnvoyerFichier(clients);
				}else if(Parametre.SUPPRIMER_FICHIER.equals(strFonction)){
					fs = new ApresSupprimerFichier(clients);
				}else if(Parametre.LOGIN.equals(strFonction)){
					fs = new ApresLogin(clients);
				}else if(Parametre.LIRE_FICHIER_INFO.equals(strFonction)){
					fs = new ApresEnvoyerFichierInfo(clients);
				}else if(Parametre.COMMENTER_FICHIER.equals(strFonction)){
					fs = new ApresCommenterFichier(clients);
				}else if(Parametre.CREER_UTILISATEUR.equals(strFonction)){
					fs = new ApresCreerUtilisateur(clients);
				}else if(Parametre.GET_FICHIER_LIST.equals(strFonction)){
					fs = new ApresEnvoyerFichierList(clients);
				}
				
				
			
		} catch (IOException e) {
		}
	}

	
}
