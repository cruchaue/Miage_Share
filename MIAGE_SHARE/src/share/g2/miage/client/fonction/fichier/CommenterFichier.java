package share.g2.miage.client.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.ClientConnection;
import share.g2.miage.client.fonction.generalite.Communication;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class CommenterFichier extends FonctionClient {
	
	public CommenterFichier(String nomFichier, String commentaire){
		super();
		parametre1 = nomFichier;
		parametre1 = commentaire;
		demarrer();
	}

	@Override
	public int executer() {
		try {

			// FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			// DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.COMMENTER_FICHIER);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();

			System.out.println("finir de commenter le fichier!");

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
