package share.g2.miage.server;

import java.io.*;
import java.net.*;

import share.g2.miage.server.Fonction.fichier.AccepterFichier;
import share.g2.miage.server.Fonction.fichier.CommenterFichier;
import share.g2.miage.server.Fonction.fichier.EnvoyerFichier;
import share.g2.miage.server.Fonction.fichier.EnvoyerFichierInfo;
import share.g2.miage.server.Fonction.fichier.EnvoyerFichierList;
import share.g2.miage.server.Fonction.fichier.SupprimerFichier;
import share.g2.miage.server.Fonction.statistiques.StatUpDownload;
import share.g2.miage.server.Fonction.utilisateur.CreerUtilisateur;
import share.g2.miage.server.Fonction.utilisateur.Login;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.util.Parametre;

/**
 * 
 *
 */
class ServerThreadFichier extends Thread {
	private ClientS clients;
	private FonctionServer fs;
	
	/**
	 * 
	 * @param s
	 * @throws IOException
	 */
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
	
	@Override
	public void run() {
		try {
			
			
				String strFonction = clients.getDis().readUTF();
				System.out.println("---  ---"+strFonction);
				if (Parametre.FICHIER_UPLOAD.equals(strFonction)) {
					fs = new AccepterFichier();
				}else if(Parametre.FICHIER_TELECHARGER.equals(strFonction)){
					fs = new EnvoyerFichier();
				}else if(Parametre.FICHIER_SUPPRIMER.equals(strFonction)){
					fs = new SupprimerFichier();
				}else if(Parametre.UTILISATEUR_LOGIN.equals(strFonction)){
					fs = new Login();
				}else if(Parametre.FICHIER_LIRE_INFO.equals(strFonction)){
					fs = new EnvoyerFichierInfo();
				}else if(Parametre.FICHIER_COMMENTER.equals(strFonction)){
					fs = new CommenterFichier();
				}else if(Parametre.UTILISATEUR_CREER.equals(strFonction)){
					fs = new CreerUtilisateur();
				}else if(Parametre.FICHIER_GET_LIST.equals(strFonction)){
					fs = new EnvoyerFichierList();
				}else if(Parametre.STATISTIQUE_NUM_UPDOWNLOAD.equals(strFonction)){
					fs = new StatUpDownload();
				}
				
				fs.demarrer(clients);
				
			
		} catch (IOException e) {
		}
	}

	
}
