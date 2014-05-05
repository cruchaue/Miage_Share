package share.g2.miage.serverJar.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.util.Parametre;

public abstract class CommenterFichier extends FonctionServer {
	
	public CommenterFichier(ClientS clients){
		this.clients = clients;
		demarrer();
	}

	@Override
	public int commExecuter() {
		try {
			DataInputStream dis = clients.getDis();
			//FileOutputStream fos = null;

			

			String fichierNom = dis.readUTF();
			
			String commentaire = dis.readUTF();
			int lengthTemp;
			byte[] byteTemp = new byte[Parametre.LENGTH_ENVOYER];
			//StringBuffer sb = new StringBuffer();
			
			File file = new File(Parametre.fichiersConfigChemin+fichierNom+".txt");
			
			System.out.println(commentaire);
			
			
			StringBuffer sb = new StringBuffer();
			if(file.exists()){
				FileInputStream fis = new FileInputStream(file);
				while ((lengthTemp = fis.read(byteTemp, 0, byteTemp.length)) > 0) {
					String strRead = new String(byteTemp);
					sb.append(String.copyValueOf(strRead.toCharArray(), 0, lengthTemp));
				
				}
				sb.append(commentaire);
				
				FileOutputStream fos = new FileOutputStream(file);
				
				fos.write(sb.toString().getBytes());
				
				fos.close();
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
