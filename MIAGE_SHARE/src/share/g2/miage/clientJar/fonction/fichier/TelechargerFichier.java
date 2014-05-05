package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.clientJar.Outil.ParametreCJ;

/**
 * Permet à l'utilisateur de Telecharger un fichier stocké sur le serveur.
 * 
 * Il est preferable de definir des droits d'acces aux fichiers 
 * lors de la conception de l'application.
 *
 */
public class TelechargerFichier<T> extends FonctionClient<T> {
	
	/**
	 * 
	 * @param chemin
	 * @param fichierNom
	 */
	public TelechargerFichier(String chemin, String fichierNom, String userNom){
		super();
		parametre1 = chemin;
		parametre2 = fichierNom;
		parametre3 = userNom;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {
			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			byte[] sendBytes = new byte[ParametreCJ.LENGTH_ENVOYER];
			int length = 0;

			dos.writeUTF(ParametreCJ.FICHIER_TELECHARGER);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();
			
			dos.writeUTF(parametre3);
			dos.flush();

			FileOutputStream fos = new FileOutputStream(new File(
					parametre1 + parametre2));
			while ((length = dis.read(sendBytes, 0, sendBytes.length)) > 0) {
				fos.write(sendBytes, 0, length);
				fos.flush();
			}
			
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
