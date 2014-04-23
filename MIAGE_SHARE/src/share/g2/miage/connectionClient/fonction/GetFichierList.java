package share.g2.miage.connectionClient.fonction;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.interfaces.ClientInterface;
import share.g2.miage.util.ParametrePublique;

public class GetFichierList implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Client client) {
		try {

			
			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();


			dos.writeUTF(ParametrePublique.GET_FICHIER_LIST);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			client.setResultat1(dis.readUTF());
			client.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
