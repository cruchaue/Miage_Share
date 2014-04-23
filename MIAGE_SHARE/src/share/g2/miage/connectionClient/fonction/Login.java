package share.g2.miage.connectionClient.fonction;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.connectionClient.fonction.interfaces.FonctionClient;
import share.g2.miage.connectionServer.Server.ServerFichier;
import share.g2.miage.interfaces.ClientInterface;
import share.g2.miage.util.ParametrePublique;

public class Login implements
		FonctionClient {

	

	@Override
	public int excuter(Client client) {
		try {

			
			//FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();


			dos.writeUTF(ParametrePublique.LOGIN);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			dos.writeUTF(client.getParametre2());
			dos.flush();
			
			client.setResultat1(dis.readUTF());
			client.setResultat2(dis.readUTF());

			System.out.println("finir de supprimer le fichier!");
			//socket.close();
			//fos.close();
			//dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
