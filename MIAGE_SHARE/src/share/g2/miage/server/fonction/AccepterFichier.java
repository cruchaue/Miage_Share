package share.g2.miage.server.fonction;

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
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.fonction.generalite.Fonction;
import share.g2.miage.server.fonction.generalite.FonctionServer;
import share.g2.miage.util.Parametre;

/**
 * 
 *
 */
public abstract class AccepterFichier extends FonctionServer {
	
	/**
	 * 
	 * @param clients
	 */
	public AccepterFichier(ClientS clients){
		this.clients = clients;
		demarrer();
	}
	
	@Override
	public int excuter() {
		try {

			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			BufferedInputStream bis = clients.getBis();
			FileOutputStream fos = null;

			byte[] byteTemp = new byte[1024];
			int lengthTemp = 0;
			
			String fichierNom = dis.readUTF();
			String userName = dis.readUTF();

			fos = new FileOutputStream(new File(Parametre.fichierChemin
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
