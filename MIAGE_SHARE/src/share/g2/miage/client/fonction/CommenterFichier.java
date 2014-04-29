package share.g2.miage.client.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.generalite.Fonction;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class CommenterFichier extends FonctionClient {
	
	public CommenterFichier(String nomFichier, String commentaire){
		client.demarrer();
		client.setParametre1(nomFichier);
		client.setParametre2(commentaire);
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
			// DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.COMMENTER_FICHIER);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();

			dos.writeUTF(client.getParametre2());
			dos.flush();

			System.out.println("finir de commenter le fichier!");

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
