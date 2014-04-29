package share.g2.miage.client.fonction.utilisateur;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.generalite.Fonction;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class SupprimerUtilisateur implements
		Fonction {

	

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
