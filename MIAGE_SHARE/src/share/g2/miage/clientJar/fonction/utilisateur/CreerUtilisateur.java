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
 * <b>Represente l'action de creer un utilisateur sur le serveur.</b>
 * 
 * <p>
 * Permet, lors de l'inscription de l'utilisateur sur le reseau, de creer son profil sur le serveur.
 * </p>
 * <p>
 * Il existe dans le package server une classe CreerUtilisateur qui fonctionne en complement de cette classe.
 * </p>
 */
public class CreerUtilisateur<T> extends FonctionClient<T> {

	/**
	 * 
	 * @param utilisateurInfo
	 */
	public CreerUtilisateur(String utilisateurInfo) {
		super();
		parametre1 = utilisateurInfo;
		demarrer();
	}

	@Override
	public int commExecuter1() {
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
