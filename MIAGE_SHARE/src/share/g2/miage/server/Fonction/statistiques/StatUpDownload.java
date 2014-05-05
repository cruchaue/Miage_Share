package share.g2.miage.server.Fonction.statistiques;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.dao.UtilisateurStat;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.statistiques.StatUpDownloadJar;
import share.g2.miage.serverJar.fonction.utilisateur.LoginJar;
import share.g2.miage.serverJar.outil.Outil;
import share.g2.miage.util.Parametre;

/**
 * 
 *
 */
public class StatUpDownload extends StatUpDownloadJar{

	@Override
	protected int pendantConnection() {
		Map<String,UtilisateurStat> userStats = ServerFichier.getListeUserStat();
		UtilisateurStat userStat;
		if((userStat = userStats.get(this.parametre1))!=null){
			this.resultat1 = 1;
			List<String> lists = new ArrayList<String>();
			lists.add(userStat.getNumUpload()+"");
			lists.add(userStat.getNumDowdload()+"");
			lists.add(userStat.getNumConnection()+"");
			this.resultat2 = Outil.ListToString(lists);
		}else{
			this.resultat1 = -1;
			this.resultat2 = "pas d'information de cet utilisateur!";
		}
		
		return 1;
		
	}

}
