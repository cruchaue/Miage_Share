package share.g2.miage.clientJar.fonction.fichier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.outil.ParametreCJ;

/**
 * Permet a l'utilisateur d'uploader un fichier sur le serveur.
 * 
 * Il est preferable de definir des droits d'acces au fichier uploadé lors de la conception de l'application.
 * 
 * Il existe dans le package server une classe AccepterFichier qui fonctionne en complement de cette classe. 
 */
public class UploadFichier<T> extends FonctionClient<T> {

	/**
	 * 
	 * @param cheminEtNom
	 * @param fichierNom
	 */
	public UploadFichier(String cheminEtNom, String fichierNom,String userName) {
		super();
		parametre1 = cheminEtNom;
		parametre2 = fichierNom;
		parametre3 = userName;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {

			File file = new File(parametre1);

			FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();
			BufferedOutputStream bos = client.getBos();

			byte[] sendBytes = new byte[ParametreCJ.LENGTH_ENVOYER];
			int length = 0;

			dos.writeUTF(ParametreCJ.FICHIER_UPLOAD);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();

			dos.writeUTF(parametre3);
			dos.flush();

			while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
				bos.write(sendBytes, 0, length);
				bos.flush();

			}

			client.closeConnection();
			JOptionPane.showMessageDialog(null, "Fichier uploadé avec succès");

			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
