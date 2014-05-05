package share.g2.miage.clientJar.fonction.statistiques;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.util.Parametre;

public class StatUpDownload extends FonctionClient {
	public StatUpDownload(String userName) {
		this.parametre1 = userName;
	}

	@Override
	public int executer() {
		try {
			
			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.STATISTIQUE_NUM_UPDOWNLOAD);
			dos.writeUTF(this.parametre1);
			
			int resultat = dis.readInt();
			this.resultat2 = dis.readUTF();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
