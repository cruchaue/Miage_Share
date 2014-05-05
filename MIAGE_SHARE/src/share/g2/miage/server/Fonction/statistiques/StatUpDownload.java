package share.g2.miage.server.Fonction.statistiques;

import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.utilisateur.LoginJar;
import share.g2.miage.util.Parametre;


public class StatUpDownload extends LoginJar{

	@Override
	protected void pendantConnection() {
		Utilisateur user;
		Map<String,Utilisateur> users = ServerFichier.getListeUser();
		if((user = users.get(this.parametre1))!=null){
			if(user.getPassword().equals(this.parametre2)){
				this.resultat1 = "1";
				this.parametre1 = user.getLoginName();
				this.parametre2 = user.getLimite();
			}else{
				this.resultat1 = "-1";
			}
		}else{
			this.resultat1 = "-2";
		}
		
	}

}
