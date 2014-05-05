package share.g2.miage.clientJar.fonction.statistiques;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.User;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.fonction.statistiques.outil.StatIndiv;
import share.g2.miage.clientJar.outil.Outil;
import share.g2.miage.clientJar.outil.ParametreCJ;

public class StatUpDownloadJar<T> extends FonctionClient<T> {
	public StatUpDownloadJar(String userName) {
		super();
		this.parametre1 = userName;
		demarrer();
	}
	
	@Override
	public int commExecuter1() {
		try {
			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(ParametreCJ.STATISTIQUE_NUM_UPDOWNLOAD);
			dos.flush();
			
			dos.writeUTF(this.parametre1);
			dos.flush();

			this.resultat1 = dis.readInt()+"";
			this.resultat2 = dis.readUTF();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
