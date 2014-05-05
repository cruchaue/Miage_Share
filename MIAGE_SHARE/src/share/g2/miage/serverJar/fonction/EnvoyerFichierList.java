package share.g2.miage.serverJar.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.util.Outil;
import share.g2.miage.util.Parametre;

public abstract class EnvoyerFichierList extends FonctionServer {
	
	public EnvoyerFichierList(ClientS clients){
		this.clients = clients;
		demarrer();
	}

	@Override
	public int commExecuter() {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();

			String userName = dis.readUTF();
			Map<String,Utilisateur> users = ServerFichier.getListeUser();
			String droitU = users.get(userName).getLimite();
			Map<String,String> fichierList = Outil.getDroitsFichier();
			StringBuffer sb = new StringBuffer();
			Iterator iter = fichierList.entrySet().iterator(); 
			while (iter.hasNext()) { 
			    Map.Entry<String, String> entry = (Map.Entry) iter.next(); 
			    String key = entry.getKey(); 
			    String val = entry.getValue(); 
			    if(Outil.comparerDroit(droitU, val)){
			    	sb.append(key+";");
			    }
			    
			} 
			
			dos.writeUTF(sb.toString());
			
			
			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
