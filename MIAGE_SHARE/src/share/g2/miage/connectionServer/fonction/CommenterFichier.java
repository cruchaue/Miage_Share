package share.g2.miage.connectionServer.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import share.g2.miage.connectionClient.dao.Fichier;
import share.g2.miage.connectionServer.ClientS;
import share.g2.miage.connectionServer.FonctionServerFichier;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.util.ParametrePublique;

public class CommenterFichier implements FonctionServerFichier {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			//FileOutputStream fos = null;

			

			String fichierNom = dis.readUTF();
			
			String commentaire = dis.readUTF();
			int lengthTemp;
			byte[] byteTemp = new byte[ParametrePublique.LENGTH_ENVOYER];
			StringBuffer sb = new StringBuffer();
			
			File file = new File(Server.getFichierChemin()+fichierNom);
			
			if(file.exists()){
				FileInputStream fis = new FileInputStream(file);
				
				while ((lengthTemp = fis.read(byteTemp, 0, byteTemp.length)) > 0) {
					sb.append(new String(byteTemp));
				}
				
				fis.close();
			}
			
			Fichier fichier = new Fichier(sb.toString());
			
			
			

			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
