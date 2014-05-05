package share.g2.miage.serverJar.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.util.Parametre;

public abstract class Login extends FonctionServer {
	
	public Login(ClientS clients){
		this.clients = clients;
		demarrer();
	}

	@Override
	public int commExecuter() {
		try {
			DataInputStream dis = clients.getDis();
			DataOutputStream dos = clients.getDos();
			//FileOutputStream fos = null;

			String userName;
			String pw;

			userName = dis.readUTF();
			pw = dis.readUTF();
			
			
			Utilisateur user;
			Map<String,Utilisateur> users = ServerFichier.getListeUser();
			if((user = users.get(userName))!=null){
				if(user.getPassword().equals(pw)){
					dos.writeUTF(Parametre.OK);
					System.out.println("login ok");
					
					dos.writeUTF(user.getLoginName()+"<@>"+user.getLimite());
					System.out.println("login ok");
				}else{
					dos.writeUTF(Parametre.UTILISATEUR_PW_PAS_CORRECTE);
					dos.writeUTF("null");
					System.out.println("faut pw");
				}
			}else{
				dos.writeUTF(Parametre.UTILISATEUR_EXISTE_PAS);
				dos.writeUTF("null");
				System.out.println("pas existe");
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
