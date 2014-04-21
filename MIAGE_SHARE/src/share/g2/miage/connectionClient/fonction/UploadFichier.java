package share.g2.miage.connectionClient.fonction;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.interfaces.ClientInterface;
import share.g2.miage.util.ParametrePublique;

public class UploadFichier implements FonctionClientFichier {

	@Override
	public int excuter(Client client) {
		try {

			File file = new File(client.getParametre1());
			
			FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			BufferedInputStream bis = client.getBis();
			BufferedOutputStream bos = client.getBos();

			byte[] sendBytes = new byte[ParametrePublique.LENGTH_ENVOYER];
			int length = 0;

			dos.writeUTF(ParametrePublique.UPLOAD_FICHIER);
			dos.flush();

			dos.writeUTF(client.getParametre2());
			dos.flush();
			
			dos.writeUTF(ClientInterface.getUser().getUserName());
			dos.flush();

			while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
				bos.write(sendBytes, 0, length);
				bos.flush();
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
