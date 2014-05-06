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
import share.g2.miage.serverJar.outil.ParametreSJ;

/**
 * <b>Action de logger un utilisateur sur le serveur</b>
 * 
 * <p>Classe abstraite dont vont heriter les classes de login</p>
 * 
 * Data: 
 * <br/>(this.parametre1 et this.parametre2 seront utilisés par 
 * le developpeur.)<br/>
 * this.parametre1 = userName; <br/>this.parametre2 = password 
 * 
 * 
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
				dos.writeUTF("1");
				dos.writeUTF(this.parametre1 + ParametreSJ.SEPARATEUR + this.parametre2);

			} else if (this.resultat1 == 0) {
				dos.writeUTF("0");
				dos.writeUTF("null");

			} else if (this.resultat1 == -1) {

				dos.writeUTF("-1");
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
