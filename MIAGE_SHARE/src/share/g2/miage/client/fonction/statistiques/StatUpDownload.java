package share.g2.miage.client.fonction.statistiques;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import share.g2.miage.client.dao.ClientConnection;
import share.g2.miage.client.fonction.generalite.FonctionClient;
import share.g2.miage.util.Parametre;

public class StatUpDownload extends FonctionClient {
	public StatUpDownload(String userName) {

	}

	@Override
	public int executer() {
		try {

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.LOGIN);
			dos.flush();

			

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
