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

public class SupprimerFichier implements
		Fonction {

	

	@Override
	public int excuter(Client client) {
		try {


			DataOutputStream dos = client.getDos();
 
			dos.writeUTF(Parametre.SUPPRIMER_FICHIER);
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
