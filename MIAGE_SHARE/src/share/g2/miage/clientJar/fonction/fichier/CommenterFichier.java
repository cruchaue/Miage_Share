package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.interfaces.interne.ClientInterface;
import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.outil.ParametreCJ;
import share.g2.miage.server.ServerFichier;

/**
 * CommenterFichier est la classe qui va permettre à l'utilisateur de pouvoir commenter un fichier.
 * Comme toute les autres fonctions clients, elle redéfinit la méthode executer() pour communiquer avec le serveur.
 *
 * Il existe dans le package server une classe CommenterFichier qui fonctionne en complement de cette classe. 

 * 
 */
public class CommenterFichier<T> extends FonctionClient<T> {

	/**
	 * Le constructeur prend en parametre le nom du fichier a commenter ainsi que le contenu du commentaire.
	 * 
	 * @param nomFichier
	 * 					Le nom du fichier a commenter
	 * @param commentaire
	 * 					Le contenu du commentaire (String)
	 */
	public CommenterFichier(String nomFichier, String commentaire){
		super();
		parametre1 = nomFichier;
		parametre2 = commentaire;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {

			DataOutputStream dos = client.getDos();

			dos.writeUTF(ParametreCJ.FICHIER_COMMENTER);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
