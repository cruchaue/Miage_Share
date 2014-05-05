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

public abstract class EnvoyerFichierInfoJar extends FonctionServer {
	
	private String fichiersConfigChemin;
	public EnvoyerFichierInfoJar(String fichiersConfigChemin){
		this.fichiersConfigChemin = fichiersConfigChemin;
	}
	
	
	@Override
	public int commExecuter1() {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			FileInputStream fis;

			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");
			File file = new File(fichiersConfigChemin + strTemp
					+ ".txt");
			if (file.exists()) {
				fis = new FileInputStream(file);

				byte[] sendBytes = new byte[ParametreSJ.LENGTH_ENVOYER];
				int length = 0;

				while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
					dos.write(sendBytes, 0, length);
					dos.flush();
				}


				fis.close();

			} 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
