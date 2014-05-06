package share.g2.miage.clientJar.fonction.utilisateur;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.outil.ParametreCJ;

/**
 * <b>Login represente l'action de se logger sur le serveur</b>
 * 
 * <p>
 * Effectue l'action de se logger sur le serveur. Login va envoyer une demande de login au serveur 
 * qui effectuera toutes les verifications necessaires.
 * </p>
 * <p>
 * Il existe dans le package server une classe Login qui fonctionne en complement de cette classe.
 * </p>
 */
public class Login<T> extends FonctionClient<T> {
	
	/**
	 * 
	 * @param utilisateurNom
	 * @param fichierNom
	 */
	public Login(String utilisateurNom, String fichierNom) {
		super();
		parametre1 = utilisateurNom;
		parametre2 = fichierNom;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(ParametreCJ.UTILISATEUR_LOGIN);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();

			resultat1 = dis.readUTF();
			
			resultat2 = dis.readUTF();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
