package share.g2.miage.connectionClient.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.connectionClient.Client;
import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.util.ParametrePublique;

public class TelechargerFichier implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Client client) {
		try {

			File file = new File(client.getParametre1());
			
			//FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			byte[] sendBytes = new byte[ParametrePublique.LENGTH_ENVOYER];
			int length = 0;

			dos.writeUTF(ParametrePublique.TELECHARGER_FICHIER);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			
			FileOutputStream fos = new FileOutputStream(new File(Server.getFichierChemin()
					+ strTemp));
			while ((lengthTemp = dis.read(byteTemp, 0, byteTemp.length)) > 0) {
				fos.write(byteTemp, 0, lengthTemp);
				fos.flush();
			}

			fos.close();
			
			

			while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
				dos.write(sendBytes, 0, length);
				dos.flush();
				System.out.println("envoyer le fichier!");
			}

			System.out.println("finir d'envoyer le fichier!");
			//socket.close();
			fis.close();
			//dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
