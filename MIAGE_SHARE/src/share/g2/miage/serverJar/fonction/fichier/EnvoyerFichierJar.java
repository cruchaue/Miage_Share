package share.g2.miage.serverJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.serverJar.outil.ParametreSJ;

public abstract class EnvoyerFichierJar extends FonctionServer {
	
	private String fichierChemin;
	public EnvoyerFichierJar(String fichierChemin){
		this.fichierChemin = fichierChemin;
	}
	
	@Override
	public int commExecuter1() {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();

			byte[] byteTemp = new byte[ParametreSJ.LENGTH_ENVOYER];
			int lengthTemp = 0;
			String fichierNom  = dis.readUTF();

			//utilisateurNom
			this.parametre1  = dis.readUTF();
			
			File file = new File(fichierChemin+fichierNom);

			FileInputStream fis = new FileInputStream(file);

			while ((lengthTemp = fis.read(byteTemp, 0, byteTemp.length)) > 0) {
				dos.write(byteTemp, 0, lengthTemp);
				dos.flush();

			}



			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
