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

import share.g2.miage.connectionServer.ClientS;
import share.g2.miage.connectionServer.FonctionServerFichier;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.connectionServer.Utilisateur;
import share.g2.miage.util.ParametrePublique;

public class CreerUtilisateur implements FonctionServerFichier {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			//FileOutputStream fos = null;

			String infoUtilisateur;
		
			infoUtilisateur = dis.readUTF();
			System.out.println("Info util : " +infoUtilisateur);
			String[] lesInfosUtilisateur = infoUtilisateur.split(ParametrePublique.SPEPARER_INFO_UTILISATEUR);
			
			// login lesInfosUtilisateur[0]
			// mdp   lesInfosUtilisateur[1]
			// mail  lesInfosUtilisateur[3]
			StringBuffer sb =  new StringBuffer();
			sb.append(lesInfosUtilisateur[0]+";");
			sb.append(lesInfosUtilisateur[1]+";");
			sb.append("2;");
			sb.append(lesInfosUtilisateur[3]+";\n");
			
			
			File file = new File("Z://spaceTest_share_G2//server//BD//utilisateurs.txt");
			 
			
			
			
			
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			
		
			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
