package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.util.Parametre;

public class LireFichierInfo extends FonctionClient {
	
	public LireFichierInfo(String filename){
		super();
		parametre1 = filename;
		demarrer();
	}

	@Override
	public int executer() {
		try {

			// FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.FICHIER_LIRE_INFO);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			byte[] sendBytes = new byte[Parametre.LENGTH_ENVOYER];
			int length = 0;

			StringBuffer sb = new StringBuffer();
			while ((length = dis.read(sendBytes, 0, sendBytes.length)) > 0) {
				String strRead = new String(sendBytes);
				strRead = String.copyValueOf(strRead.toCharArray(), 0, length);
				sb.append(strRead);

			}

			resultat1 = sb.toString();
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
