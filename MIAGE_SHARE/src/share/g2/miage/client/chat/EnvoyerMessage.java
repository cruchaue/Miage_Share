package share.g2.miage.client.chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.interfaces.Fonction;
import share.g2.miage.util.Parametre;

public class EnvoyerMessage implements Fonction {

	@Override
	public int excuter(Client client) {
		
		try {
			DataOutputStream dos = client.getDos();
			BufferedInputStream bis = client.getBis();
			BufferedOutputStream bos = client.getBos();
			
			dos.writeUTF(Parametre.ENVOYER_MESSAGE);
			dos.flush();
			
			//message
			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			//user
			dos.writeUTF(client.getParametre2());
			dos.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
