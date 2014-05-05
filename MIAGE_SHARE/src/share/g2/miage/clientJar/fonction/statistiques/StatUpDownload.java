package share.g2.miage.clientJar.fonction.statistiques;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.User;
import share.g2.miage.clientJar.Outil.Outil;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.fonction.statistiques.outil.StatIndiv;
import share.g2.miage.util.Parametre;

public class StatUpDownload extends FonctionClient<ChartFrame> {
	public StatUpDownload(String userName) {
		this.parametre1 = userName;
	}

	@Override
	public int executer() {
		try {
			System.out.println("ttttttt111111");
			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(Parametre.STATISTIQUE_NUM_UPDOWNLOAD);
			dos.writeUTF(this.parametre1);

			int resultat = dis.readInt();
			this.resultat2 = dis.readUTF();
			System.out.println("ttttttt"+this.resultat2);
			if (resultat == 1) {
				List<String> list = Outil.StringToList(this.resultat2);
				
				 User user = new User();
				 user.setNbUp(Integer.valueOf(list.get(0)));
				 user.setNbDown(Integer.valueOf(list.get(1)));
				 user.setNbConnex(Integer.valueOf(list.get(2)));
				  
				  
				  DefaultPieDataset data= new DefaultPieDataset();
				  StatIndiv.createStatUtil(user, "connexion",data);
				  StatIndiv.createStatUtil(user, "upload",data);
				  StatIndiv.createStatUtil(user, "download",data);
				  
				  this.resultat3 =  StatIndiv.statUt(data,"titrediag","titrfen");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
