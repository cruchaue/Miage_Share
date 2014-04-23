package share.g2.miage.connectionServer.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import share.g2.miage.connectionServer.Server.ServerFichier;
import share.g2.miage.connectionServer.dao.ClientS;
import share.g2.miage.connectionServer.dao.Utilisateur;
import share.g2.miage.connectionServer.fonction.interfaces.FonctionServer;
import share.g2.miage.util.ParametrePublique;

public class Login implements FonctionServer {

	@Override
	public int excuter(ClientS clients) {
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
					dos.writeUTF(ParametrePublique.OK);
					System.out.println("login ok");
					
					dos.writeUTF(user.getLoginName()+"<@>"+user.getLimite());
					System.out.println("login ok");
				}else{
					dos.writeUTF(ParametrePublique.USER_PW_PAS_CORRECTE);
					dos.writeUTF("null");
					System.out.println("faut pw");
				}
			}else{
				dos.writeUTF(ParametrePublique.USER_EXISTE_PAS);
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
