package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

/**
 * Permet à l'utilisateur de supprimer un fichier sur le serveur.
 * 
 * Il est preferable de definir quels utilisateurs 
 * peuvent effectuer cette action lors de la concetption de l'application.
 *
 * Il existe, dans le package server, une classe SupprimerFichier qui fonctionne en complement de cette classe. 
 */
public class SupprimerFichier extends
		FonctionClient {
	
	/**
	 * 
	 * @param fichierNom
	 */
	public SupprimerFichier(String fichierNom){
		super();
		parametre1 = fichierNom;
		demarrer();
	}

	@Override
	public int executer() {
		try {


			DataOutputStream dos = client.getDos();
 
			dos.writeUTF(Parametre.FICHIER_SUPPRIMER);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			System.out.println("finir de supprimer le fichier!");

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
