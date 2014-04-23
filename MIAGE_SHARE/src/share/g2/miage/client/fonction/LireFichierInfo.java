package share.g2.miage.client.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.interfaces.FonctionClient;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class LireFichierInfo implements
		FonctionClient {

	

	@Override
	public int excuter(Client client) {
		try {

			
			//FileInputStream fis = new FileInputStream(file);

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
			
			//socket.close();
			//fos.close();
			//dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
