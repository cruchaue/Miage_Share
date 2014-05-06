package share.g2.miage.serverJar.fonction.utilisateur;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;

/**
 * <b>Action de modifier le droit d'un utilisateur sur le serveur</b>
 * 
 * <p>Classe abstraite dont vont heriter les classes de création d'utilisateur</p>
 *
 * Data: 
 * <br/>(this.parametre1 et this.parametre2 seront utilisés par 
 * le developpeur.)<br/>
 * this.parametre1 = username; <br/>this.parametre2 = droit 
 * 
 */
public abstract class ModifierDroitUtilisateurJar extends FonctionServer {

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

}
