package share.g2.miage.server.chat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import share.g2.miage.client.dao.User;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.fonction.interfaces.FonctionServer;

public class RecupererMessage implements FonctionServer {

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