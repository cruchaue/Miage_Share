package share.g2.miage.connectionClient.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.util.ParametrePublique;

public class LireFichierInfo implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Client client) {
		try {

			
			//FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

 
			dos.writeUTF(ParametrePublique.LIRE_FICHIER_INFO);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			byte[] sendBytes = new byte[ParametrePublique.LENGTH_ENVOYER];
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
