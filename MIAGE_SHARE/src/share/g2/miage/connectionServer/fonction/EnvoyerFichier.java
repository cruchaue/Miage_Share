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

public class EnvoyerFichier implements FonctionServerFichier {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			//FileOutputStream fos = null;

			byte[] byteTemp = new byte[1024];
			int lengthTemp = 0;
			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");

			System.out.println(lengthTemp + ", " + strTemp);

			File file = new File(Server.getFichierChemin()+strTemp);

			FileInputStream fis = new FileInputStream(file);
			
			while ((lengthTemp = fis.read(byteTemp, 0, byteTemp.length)) > 0) {
				dos.write(byteTemp, 0, lengthTemp);
				dos.flush();
				System.out.println("envoyer le fichier!");
			}
			
			

			fis.close();
			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
