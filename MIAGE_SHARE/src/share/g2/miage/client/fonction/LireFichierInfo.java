package share.g2.miage.client.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.interfaces.Fonction;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class LireFichierInfo extends FonctionClient {
	
	public LireFichierInfo(String filename){
		client = new Client();
		client.demarrer();
		client.setParametre1(filename);
		excuter();
		client.closeConnection();
	}

	@Override
	public int excuter(Client client) {
		return 1;
	}

	@Override
	public int excuter() {
		try {

			// FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.LIRE_FICHIER_INFO);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();

			byte[] sendBytes = new byte[Parametre.LENGTH_ENVOYER];
			int length = 0;

			StringBuffer sb = new StringBuffer();
			while ((length = dis.read(sendBytes, 0, sendBytes.length)) > 0) {
				String strRead = new String(sendBytes);
				strRead = String.copyValueOf(strRead.toCharArray(), 0, length);
				sb.append(strRead);

			}

			client.setResultat1(sb.toString());
			System.out.println(sb.toString());

			// socket.close();
			// fos.close();
			// dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
