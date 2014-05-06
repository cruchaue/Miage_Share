package share.g2.miage.serverJar.fonction.fichier;

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
 * Description: 
 * <br/>Cette classe réalise la fonction de base de modifier le droit d'un fichier 
 * cote serveur.
 * <br/><br/>
 * Data: 
 * <br/>(this.parametre1 et this.parametre2 seront utilisés par 
 * le developpeur.)<br/>
 * this.parametre1 = fichiername; <br/>this.parametre2 = droit 
 * 
 * @author G2
 */
public abstract class ModifierDroitFichierJar extends FonctionServer {

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
