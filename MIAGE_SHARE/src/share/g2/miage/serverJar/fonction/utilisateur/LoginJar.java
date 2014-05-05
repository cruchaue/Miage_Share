package share.g2.miage.serverJar.fonction.utilisateur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.util.Parametre;

/**
 * <b>Action de logger un utilisateur sur le serveur</b>
 * 
 * <p>Classe abstraite dont vont heriter les classes de login</p>
 */
public abstract class LoginJar extends FonctionServer {

	@Override
	public int commExecuter1() {
		try {
			DataInputStream dis = clients.getDis();

			this.parametre1 = dis.readUTF();
			this.parametre2 = dis.readUTF();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

	@Override
	public int commExecuter2() {
		try {
			DataOutputStream dos = clients.getDos();
			if (this.resultat1 == 1) {
				dos.writeUTF(Parametre.OK);
				dos.writeUTF(this.parametre1 + Parametre.SEPARATEUR + this.parametre2);


			} else if (this.resultat1 == 0) {
				dos.writeUTF(Parametre.UTILISATEUR_EXISTE_PAS);
				dos.writeUTF("null");

			} else if (this.resultat1 == -1) {

				dos.writeUTF(Parametre.UTILISATEUR_PW_PAS_CORRECTE);
				dos.writeUTF("null");

			} else {

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
