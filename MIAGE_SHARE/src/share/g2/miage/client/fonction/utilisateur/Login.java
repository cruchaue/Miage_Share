package share.g2.miage.client.fonction.utilisateur;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.ClientConnection;
import share.g2.miage.client.fonction.generalite.Fonction;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class Login extends FonctionClient {

	public Login(String utilisateurNom, String fichierNom) {
		super();
		parametre1 = utilisateurNom;
		parametre2 = fichierNom;
		demarrer();
	}

	@Override
	public int excuter() {
		try {

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.LOGIN);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			dos.writeUTF(parametre2);
			dos.flush();

			resultat1 = dis.readUTF();
			resultat2 = dis.readUTF();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
