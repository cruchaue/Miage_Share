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

public class SupprimerFichier implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Client client) {
		try {

			
			//FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			//DataInputStream dis = client.getDis();


			dos.writeUTF(ParametrePublique.SUPPRIMER_FICHIER);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			
			
			
			

			System.out.println("finir de supprimer le fichier!");
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
