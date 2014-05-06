package share.g2.miage.serverJar.fonction.fichier;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;


/** 
 * Description: 
 * <br/>Cette classe réalise la fonction de base de l'upload d'un fichier 
 * cote serveur.
 * <br/><br/>
 * Data: 
 * <br/>(this.parametre1 et this.parametre2 seront utilisés par 
 * le developpeur.)<br/>
 * this.parametre1 = fichiername; <br/>this.parametre2 = username 
 * 
 * @author G2
 */
public abstract class AccepterFichierJar extends FonctionServer {
	
	
	private String fichierChemin;
	
	/** 
     * constructeur
     * @param fichierChemin chemin pour enregister le fichier 
     */ 
	public AccepterFichierJar(String fichierChemin){
		this.fichierChemin = fichierChemin;
	}
	
	@Override
	public int commExecuter1() {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			BufferedInputStream bis = clients.getBis();
			FileOutputStream fos = null;

			byte[] byteTemp = new byte[1024];
			int lengthTemp = 0;

			String fichierNom = dis.readUTF();
			String userName = dis.readUTF();

			fos = new FileOutputStream(new File(fichierChemin
					+ fichierNom));
			while ((lengthTemp = bis.read(byteTemp, 0, byteTemp.length)) > 0) {
				fos.write(byteTemp, 0, lengthTemp);
				fos.flush();
			}
			fos.close();
			this.parametre1 = fichierNom;
			this.parametre2 = userName;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}



}
