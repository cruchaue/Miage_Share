package share.g2.miage.connectionServer.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import share.g2.miage.connectionServer.ClientS;
import share.g2.miage.connectionServer.FonctionServerFichier;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.util.ParametrePublique;

public class SupprimerFichier implements FonctionServerFichier {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			//FileOutputStream fos = null;

			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");
			File file = new File(Server.getFichierChemin()+strTemp);
			file.deleteOnExit();

			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
