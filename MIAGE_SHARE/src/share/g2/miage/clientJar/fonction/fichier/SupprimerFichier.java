package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.clientJar.Outil.ParametreCJ;

/**
 * <b>Permet à l'utilisateur de supprimer un fichier sur le serveur.</b>
 * 
 * <p>Il est preferable de definir au prealable quels utilisateurs 
 * peuvent effectuer cette action lors de la concetption de l'application.</p>
 *
 * <p>Il existe, dans le package server, une classe SupprimerFichier qui fonctionne en complement de cette classe.</p> 
 */
public class SupprimerFichier<T> extends
FonctionClient<T> {

	/**
	 * Demarre la suppression du fichier sur le serveur
	 * @param fichierNom Le nom du fichier a supprimer.
	 * 
	 * @see share.g2.miage.server.Fonction.fichier.SupprimerFichier
	 * @see Fichier
	 */
	public SupprimerFichier(String fichierNom){
		super();
		parametre1 = fichierNom;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {


			DataOutputStream dos = client.getDos();
 
			dos.writeUTF(ParametreCJ.FICHIER_SUPPRIMER);
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
