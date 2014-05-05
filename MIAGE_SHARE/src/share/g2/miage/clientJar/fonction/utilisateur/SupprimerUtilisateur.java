package share.g2.miage.clientJar.fonction.utilisateur;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

/**
 * <b>Represente l'action de supprimer un utilisateur du serveur</b>
 * 
 * <p>A la demande de l'utilisateur l'action de supprimer son compte va etre demander.
 * Cette classe va lancer l'execution qui va elle même demander au serveur de supprimer 
 * cet utilisateur.</p>
 *
 */
public class SupprimerUtilisateur extends FonctionClient {
	
	/**
	 * 
	 */
	public SupprimerUtilisateur() {
		super();
		// parametre1 = utilisateurNom;
		// parametre2 = fichierNom;
		demarrer();
	}

	@Override
	public int executer() {
		try {

			// FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.UTILISATEUR_CREER);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
