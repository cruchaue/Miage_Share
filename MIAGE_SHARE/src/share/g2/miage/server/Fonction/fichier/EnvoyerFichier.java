package share.g2.miage.server.Fonction.fichier;

import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.UtilisateurStat;
import share.g2.miage.server.outil.ParametreS;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.fichier.CommenterFichierJar;
import share.g2.miage.serverJar.fonction.fichier.EnvoyerFichierJar;
import share.g2.miage.serverJar.outil.ParametreSJ;

public class EnvoyerFichier extends EnvoyerFichierJar {

	
	public EnvoyerFichier(String fichierChemin) {
		super(fichierChemin);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int apresConnection() {
		// modifier le num de upload
		UtilisateurStat us;
		Map<String, UtilisateurStat> list = ServerFichier.getListeUserStat();
		if ((us = list.get(this.parametre1)) == null) {
			us = new UtilisateurStat();
			us.setLoginName(this.parametre1);
			us.setNumConnection(1);
			us.setNumUpload(0);
			us.setNumDowdload(1);
			list.put(this.parametre1, us);
		} else {
			us.setNumDowdload(us.getNumDowdload() + 1);
		}

		return 1;

	}

}
