package share.g2.miage.connectionServer.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import share.g2.miage.connectionServer.Server.ServerFichier;
import share.g2.miage.connectionServer.dao.ClientS;
import share.g2.miage.connectionServer.fonction.interfaces.FonctionServer;
import share.g2.miage.util.Parametre;

public class EnvoyerFichierInfo implements FonctionServer {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			FileInputStream fis;

			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");
			File file = new File(ServerFichier.getFichiersConfigChemin()+strTemp+".txt");
			if(file.exists()){
				fis = new FileInputStream(file);
				
				
				
				
				byte[] sendBytes = new byte[Parametre.LENGTH_ENVOYER];
				int length = 0;

				while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
					dos.write(sendBytes, 0, length);
					dos.flush();
				}

				System.out.println("Fichier envoyé avec succès");
				//socket.close();
				fis.close();
				
				
				
				
			}else{
				System.out.println("Le fichier n'existe pas!");
			}

			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
