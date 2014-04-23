package share.g2.miage.connectionServer.fonction;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import share.g2.miage.connectionServer.Server.ServerFichier;
import share.g2.miage.connectionServer.dao.ClientS;
import share.g2.miage.connectionServer.dao.Utilisateur;
import share.g2.miage.connectionServer.fonction.interfaces.FonctionServer;
import share.g2.miage.util.Parametre;

public class CreerUtilisateur implements FonctionServer {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			//FileOutputStream fos = null;

			String infoUtilisateur;
		
			infoUtilisateur = dis.readUTF();
			System.out.println("Info util : " +infoUtilisateur);
			String[] lesInfosUtilisateur = infoUtilisateur.split(Parametre.SPEPARER_INFO_UTILISATEUR);
			
			// login lesInfosUtilisateur[0]
			// mdp   lesInfosUtilisateur[1]
			// mail  lesInfosUtilisateur[3]
			StringBuffer sb =  new StringBuffer();
			sb.append(lesInfosUtilisateur[0]+";");
			sb.append(lesInfosUtilisateur[1]+";");
			sb.append(Parametre.UTILISATEUR_DROIT_DEFAULT+";");
			sb.append(lesInfosUtilisateur[3]+";\r\n");
			
			
			File file = new File(ServerFichier.getFichiers_BD_utilisateurs());
			 
			
			
			
			
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			
		
			clients.closeConnection();
			ServerFichier.chargerUtilisateur();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
