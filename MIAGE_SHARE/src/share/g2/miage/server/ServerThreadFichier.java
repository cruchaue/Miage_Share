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
import share.g2.miage.server.Fonction.utilisateur.ModifierDroitUtilisateur;
import share.g2.miage.server.Fonction.utilisateur.SupprimerUtilisateur;
import share.g2.miage.server.outil.ParametreS;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.serverJar.outil.ParametreSJ;

/**
 * Lorqu'une demande d'action est effectue par un client sur le serveur de
 * fichier, un nouveau Thread est cree jusqu'a la fin de la demande.
 * 
 * exemple: telechargement ou upload de fichier.
 * 
 * @see Thread
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
			System.out.println("---  ---" + strFonction);
			if (ParametreSJ.FICHIER_UPLOAD.equals(strFonction)) {
				fs = new AccepterFichier(ParametreS.fichierChemin);
			} else if (ParametreSJ.FICHIER_TELECHARGER.equals(strFonction)) {
				fs = new EnvoyerFichier(ParametreS.fichierChemin);
			} else if (ParametreSJ.FICHIER_SUPPRIMER.equals(strFonction)) {
				fs = new SupprimerFichier(ParametreS.fichierChemin);
			} else if (ParametreSJ.UTILISATEUR_LOGIN.equals(strFonction)) {
				fs = new Login();
			} else if (ParametreSJ.FICHIER_LIRE_INFO.equals(strFonction)) {
				fs = new EnvoyerFichierInfo(ParametreS.fichiersConfigChemin);
			} else if (ParametreSJ.FICHIER_COMMENTER.equals(strFonction)) {
				fs = new CommenterFichier();
			} else if (ParametreSJ.UTILISATEUR_CREER.equals(strFonction)) {
				fs = new CreerUtilisateur();
			} else if (ParametreSJ.FICHIER_GET_LIST.equals(strFonction)) {
				fs = new EnvoyerFichierList();
			} else if (ParametreSJ.STATISTIQUE_NUM_UPDOWNLOAD
					.equals(strFonction)) {
				fs = new StatUpDownload();
			}else if (ParametreSJ.UTILISATEUR_SUPPRIMER
					.equals(strFonction)) {
				fs = new SupprimerUtilisateur(ParametreS.fichiers_BD_utilisateurs);
			}else if (ParametreSJ.UTILISATEUR_MODIFIER_DROIT
					.equals(strFonction)) {
				fs = new ModifierDroitUtilisateur(ParametreS.fichiers_BD_utilisateurs);
			}

			int result = fs.demarrer(clients);
			if (result == 1) {
				System.out.println("Operation " + strFonction + " "
						+ "est bien fait!");
			} else {
				System.out.println("Operation " + strFonction + " "
						+ "est raté!");
			}

		} catch (IOException e) {
		}
	}

}
