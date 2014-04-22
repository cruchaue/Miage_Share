package share.g2.miage.connectionClient.chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.util.ParametrePublique;

public class EnvoyerMessage implements FonctionClientFichier {

	@Override
	public int excuter(Client client) {
		
		try {
			DataOutputStream dos = client.getDos();
			BufferedInputStream bis = client.getBis();
			BufferedOutputStream bos = client.getBos();
			
			dos.writeUTF(ParametrePublique.ENVOYER_MESSAGE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}