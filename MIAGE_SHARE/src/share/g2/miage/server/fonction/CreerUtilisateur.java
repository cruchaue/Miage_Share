package share.g2.miage.server.fonction;

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

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.fonction.generalite.Communication;
import share.g2.miage.server.fonction.generalite.FonctionServer;
import share.g2.miage.util.Parametre;

public abstract class CreerUtilisateur extends FonctionServer {
	
	public CreerUtilisateur(ClientS clients){
		this.clients = clients;
		demarrer();
	}

	@Override
	public int commExecuter() {
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
			
			
			File file = new File(Parametre.fichiers_BD_utilisateurs);
			 
			
			
			
			
			
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
