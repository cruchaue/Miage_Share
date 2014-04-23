package share.g2.miage.server.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.fonction.interfaces.FonctionServer;
import share.g2.miage.util.Parametre;

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
					dos.writeUTF(Parametre.OK);
					System.out.println("login ok");
					
					dos.writeUTF(user.getLoginName()+"<@>"+user.getLimite());
					System.out.println("login ok");
				}else{
					dos.writeUTF(Parametre.USER_PW_PAS_CORRECTE);
					dos.writeUTF("null");
					System.out.println("faut pw");
				}
			}else{
				dos.writeUTF(Parametre.USER_EXISTE_PAS);
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
