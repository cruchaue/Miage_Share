package share.g2.miage.connectionServer.chat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import share.g2.miage.connectionClient.dao.User;
import share.g2.miage.connectionServer.ClientS;
import share.g2.miage.connectionServer.FonctionServerFichier;

public class RecupererMessage implements FonctionServerFichier {

	@Override
	public int excuter(ClientS clients) {
		
		try {
			DataInputStream dis = clients.getDis();
			BufferedInputStream bis = clients.getBis();
			
			String message = dis.readUTF();
			String userName = dis.readUTF();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
