package share.g2.miage.client.fonction;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.interfaces.FonctionClient;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.connectionServer.Server.ServerFichier;
import share.g2.miage.util.Parametre;

public class CreerUtilisateur implements
		FonctionClient {

	

	@Override
	public int excuter(Client client) {
		try {

			
			//FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();


			dos.writeUTF(Parametre.CREER_UTILISATEUR);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
