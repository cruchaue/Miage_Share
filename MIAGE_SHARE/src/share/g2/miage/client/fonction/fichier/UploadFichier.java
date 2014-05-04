package share.g2.miage.client.fonction.fichier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import share.g2.miage.client.dao.ClientConnection;
import share.g2.miage.client.fonction.generalite.Communication;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.util.Parametre;

public class UploadFichier extends FonctionClient {

	public UploadFichier(String cheminEtNom, String fichierNom) {
		super();
		parametre1 = cheminEtNom;
		parametre2 = fichierNom;
		demarrer();
	}

	@Override
	public int executer() {
		try {

			File file = new File(parametre1);

			FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();
			BufferedOutputStream bos = client.getBos();

			byte[] sendBytes = new byte[Parametre.LENGTH_ENVOYER];
			int length = 0;

			dos.writeUTF(Parametre.UPLOAD_FICHIER);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();

			dos.writeUTF(ClientInterface.getUser().getUserName());
			dos.flush();

			while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
				bos.write(sendBytes, 0, length);
				bos.flush();
				System.out.println("upload en cours!");
			}
			// client.setResultat1(dis.readUTF());
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
