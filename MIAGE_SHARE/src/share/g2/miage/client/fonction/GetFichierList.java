package share.g2.miage.client.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.util.Parametre;

public class GetFichierList extends FonctionClient {

	public GetFichierList(String userName) {
		client.setParametre1(userName);
		client.demarrer();
	}

	@Override
	public int excuter(Client client) {

		return 1;
	}

	@Override
	public int excuter() {
		try {

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.GET_FICHIER_LIST);
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
