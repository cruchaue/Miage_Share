package share.g2.miage.connectionServer.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import share.g2.miage.connectionServer.Server.ServerFichier;
import share.g2.miage.connectionServer.dao.ClientS;
import share.g2.miage.connectionServer.fonction.interfaces.FonctionServer;
import share.g2.miage.util.Parametre;

public class CommenterFichier implements FonctionServer {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			//FileOutputStream fos = null;

			

			String fichierNom = dis.readUTF();
			
			String commentaire = dis.readUTF();
			int lengthTemp;
			byte[] byteTemp = new byte[Parametre.LENGTH_ENVOYER];
			//StringBuffer sb = new StringBuffer();
			
			File file = new File(ServerFichier.getFichiersConfigChemin()+fichierNom+".txt");
			
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
			/*
			Fichier fichier = new Fichier(sb.toString());
			List<Commentaire> comms = fichier.getComms();
			if(comms==null){
				comms = new ArrayList<Commentaire>();
			}
			
			String[] commTable = commentaire.split(ParametrePublique.SPEPARER_FICHIER_COMMENTAIRE2);
			Commentaire comm = new Commentaire();
			comm.setUser(commTable[0]);
			comm.setDate(commTable[1]);
			comm.setContenu(commTable[2]);
			comms.add(comm);
			*/
			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
