package share.g2.miage.serverJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;


/** 
 * Description: 
 * <br/>Cette classe réalise la fonction de base de supprimer d'un fichier 
 * cote serveur.
 * <br/><br/>
 * Data: 
 * <br/>(this.parametre1  sera utilisé par 
 * le developpeur.)<br/>
 * this.parametre1 = fichiername;  
 * 
 * @author G2
 */
public abstract class SupprimerFichierJar extends FonctionServer {
	private String fichierChemin;
	public SupprimerFichierJar(String fichierChemin){
		this.fichierChemin = fichierChemin;
	}
	@Override
	public int commExecuter1() {
		try {
			DataInputStream dis = clients.getDis();

			this.parametre1 = dis.readUTF();
			System.out.println(this.parametre1 + ",");

			// Supprimer fichier
			File file = new File(fichierChemin + this.parametre1);
			if (file.exists()) {
				file.delete();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
