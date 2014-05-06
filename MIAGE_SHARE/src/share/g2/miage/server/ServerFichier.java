package share.g2.miage.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.dao.UtilisateurStat;
import share.g2.miage.server.outil.ParametreS;

/**
 * Lance le serveur, dans un nouveau Thread, qui va g�rer toutes les op�rations relatives � la gestion des fichiers.
 *
 */
public class ServerFichier   extends Thread {

	/**
	 * Socket sur lequel les clients vont pouvoir se connecter afin de communiquer avec le serveur de gestion de Fichier.
	 * Un Utilisateur, une fois connect�, va pouvoir Uploader, downloader, laisser un commentaire sur un fichier etc...
	 */
	private ServerSocket serverFichier = null;

	/**
	 * 
	 */
	private boolean demarre = true;

	/**
	 * Collection d'Utilisateurs qui sont connect�s sur le serveur.
	 * Chaque utilisateur est identifi� par son nom/pseudo.
	 * 
	 * @see Utilisateur
	 * @see Collection
	 * @see Map
	 */
	private static Map<String,Utilisateur> listeUser;
	private static Map<String,UtilisateurStat> listeUserStat;

	/**
	 * D�marre le serveur de Fichier.
	 * 
	 * @see Fichier
	 * @see Thread
	 */
	public ServerFichier(){
		start();
	}


	@Override
	public void run() { 
		listeUser = new HashMap<String,Utilisateur>();
		listeUserStat  = new HashMap<String,UtilisateurStat>();
		// lire le fichier de parametre
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("ipConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		int portFichier = Integer.valueOf(p.getProperty("portServerFichier"));




		chargerUtilisateur();


		try {

			serverFichier = new ServerSocket(portFichier);
			System.out.println("le serveur de fichier est bien démarré!");
			while (demarre) {
				Socket socketFichier = serverFichier.accept();
				new ServerThreadFichier(socketFichier);
			}
			serverFichier.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retourne une Map<String, Utilisateur> qui contient tous les Utilisateur connect� au serveur.
	 * 
	 * @return La Collection de tous les Utilisateur connect� au serveur.
	 * 
	 * @see Collection
	 * @see Utilisateur
	 */
	public static Map<String, Utilisateur> getListeUser() {
		return listeUser;
	}

	public static Map<String, UtilisateurStat> getListeUserStat() {
		return listeUserStat;
	}


	/**
	 * Permet de fermer la connection entre le serveur et le client.
	 */
	public void closeServer() {
		demarre = false;
	}

	/**
	 * Lors du lancement du serveur, celui-ci va aller chercher dans un fichier, stock� en m�moire, toutes les informations sur les utilisateurs inscrits.
	 * Ce fichier sert de sauvegarde en cas de d�faillance du serveur et �vite de tout perdre .
	 * 
	 * @see Utilisateur
	 */
	public static void chargerUtilisateur() {
		File filename = new File(ParametreS.fichiers_BD_utilisateurs); 
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(filename));

			BufferedReader br = new BufferedReader(reader); 
			String line = "";

			while ((line =br.readLine()) != null) {

				String uStr[] = line.split(";");
				Utilisateur u = new Utilisateur();
				u.setLoginName(uStr[0]);
				u.setPassword(uStr[1]);
				u.setLimite(uStr[2]);
				listeUser.put(uStr[0], u);


			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
