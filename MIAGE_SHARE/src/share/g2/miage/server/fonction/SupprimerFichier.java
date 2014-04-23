package share.g2.miage.server.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.fonction.interfaces.FonctionServer;
import share.g2.miage.util.Parametre;

public class SupprimerFichier implements FonctionServer {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			//FileOutputStream fos = null;

			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");
			File file = new File(ServerFichier.getFichierChemin()+strTemp);
			if(file.exists()){
				file.delete();
				System.out.println("Le fichier a été supprimé avec succès");
			}else{
				System.out.println("Aucun fichier selectionné");
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
