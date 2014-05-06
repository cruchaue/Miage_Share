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
 * <br/>Cette classe réalise la fonction de base d'envoyer une liste des fichier 
 * cote serveur.(comparer le droit de fichier avec le droit d'utilisateur)
 * <br/><br/>
 * Data: 
 * <br/>(this.parametre1 sera utilisé par 
 * le developpeur.)<br/>
 * this.parametre1 = username;  
 * 
 * @author G2
 */
public abstract class EnvoyerFichierListJar extends FonctionServer {

	@Override
	public int commExecuter1() {
		try {
			DataInputStream dis = clients.getDis();
			this.parametre1 = dis.readUTF();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

	@Override
	public int commExecuter2(){
		try {
			DataOutputStream dos = clients.getDos();
			dos.writeUTF(this.parametre2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
