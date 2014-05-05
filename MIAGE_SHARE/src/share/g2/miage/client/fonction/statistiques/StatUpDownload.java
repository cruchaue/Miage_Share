package share.g2.miage.client.fonction.statistiques;

import java.util.List;

import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.User;
import share.g2.miage.clientJar.fonction.statistiques.StatUpDownloadJar;
import share.g2.miage.clientJar.fonction.statistiques.outil.StatIndiv;
import share.g2.miage.clientJar.outil.Outil;

public class StatUpDownload extends StatUpDownloadJar<ChartFrame> {

	public StatUpDownload(String userName) {
		super(userName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int apresConnection() {
		if ("1".equals(this.resultat1)) {
			List<String> list = Outil.StringToList(this.resultat2);

			User user = new User();
			user.setNbUp(Integer.valueOf(list.get(0)));
			user.setNbDown(Integer.valueOf(list.get(1)));
			user.setNbConnex(Integer.valueOf(list.get(2)));

			DefaultPieDataset data = new DefaultPieDataset();
			StatIndiv.createStatUtil(user, "connexion", data);
			StatIndiv.createStatUtil(user, "upload", data);
			StatIndiv.createStatUtil(user, "download", data);

			this.resultat3 = StatIndiv.statUt(data, this.parametre1,
					"Statistique de num de upload/download/connection");
			return 1;
		} else {
			return -1;
		}

	}

}
