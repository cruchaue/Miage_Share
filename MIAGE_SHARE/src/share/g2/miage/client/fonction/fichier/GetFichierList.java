package share.g2.miage.client.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import share.g2.miage.client.dao.ClientConnection;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.util.Parametre;

public class GetFichierList extends FonctionClient {

	public GetFichierList(String userName) {
		super();
		parametre1 = userName;
		demarrer();
	}

	@Override
	public int executer() {
		try {

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.FICHIER_GET_LIST);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			resultat1 = dis.readUTF();
			client.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
