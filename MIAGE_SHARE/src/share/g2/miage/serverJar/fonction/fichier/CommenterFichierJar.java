package share.g2.miage.serverJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;


/** 
 * Description: 
 * <br/>Cette classe réalise la fonction de base du commentaire d'un fichier 
 * cote serveur. 
 * <br/><br/>
 * Data: 
 * <br/>(this.parametre1 et this.parametre2 seront utilisés par 
 * le developpeur.)<br/>
 * this.parametre1 = fichiername; <br/>this.parametre2 = commentaire 
 * 
 * @author G2
 */
public abstract class CommenterFichierJar extends FonctionServer {

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
