package share.g2.miage.clientJar.fonction.statistiques;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

import org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.User;
import share.g2.miage.clientJar.Outil.Outil;
import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.util.Parametre;

public class StatUpDownload extends FonctionClient<DefaultPieDataset> {
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

			if (resultat == 1) {
				List<String> list = Outil.StringToList(this.resultat2);
				/*
				 User olmail=new User();
				  olmail.setNbUp(list.get(0));
				  olmail.setNbDown(40);
				  olmail.setNbConnex(60);
				  
				  
				  DefaultPieDataset data= new DefaultPieDataset();
				  createStatUtil(olmail, "connexion",data);
				  createStatUtil(olmail, "upload",data);
				  createStatUtil(olmail, "download",data);
				  */
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
