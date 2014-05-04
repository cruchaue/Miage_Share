package share.g2.miage.client.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import share.g2.miage.client.dao.ClientConnection;
import share.g2.miage.client.fonction.generalite.Communication;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class TelechargerFichier extends FonctionClient {

	public TelechargerFichier(String chemin, String fichierNom){
		super();
		parametre1 = chemin;
		parametre2 = fichierNom;
		demarrer();
	}

	@Override
	public int executer() {
		try {
			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			byte[] sendBytes = new byte[Parametre.LENGTH_ENVOYER];
			int length = 0;

			dos.writeUTF(Parametre.FICHIER_TELECHARGER);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();

			FileOutputStream fos = new FileOutputStream(new File(
					parametre1 + parametre2));
			while ((length = dis.read(sendBytes, 0, sendBytes.length)) > 0) {
				fos.write(sendBytes, 0, length);
				fos.flush();
			}
			fos.close();

			JOptionPane.showMessageDialog(null,
					"Fichier telecharger avec succès");
			// socket.close();
			fos.close();
			// dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
