package share.g2.miage.server.Fonction.utilisateur;

import java.util.List;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.dao.UtilisateurStat;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.utilisateur.LoginJar;
import share.g2.miage.util.Parametre;

/**
 * <b>Login de l'utilisateur sur le serveur</b>
 * 
 * <p>Va permettre a un utilisateur de se logger sur le serveur apres avoir 
 * verifier les informations envoyees.</p>
 * 
 * @see LoginJar
 */
public class Login extends LoginJar{

	@Override
	protected void pendantConnection() {
		Utilisateur user;
		Map<String,Utilisateur> users = ServerFichier.getListeUser();
		if((user = users.get(this.parametre1))!=null){
			if(user.getPassword().equals(this.parametre2)){
				this.resultat1 = 1;
				this.parametre1 = user.getLoginName();
				this.parametre2 = user.getLimite();
				
				UtilisateurStat us;
				Map<String,UtilisateurStat> list = ServerFichier.getListeUserStat();
				if((us = list.get(user.getLoginName())) == null){
					us = new UtilisateurStat();
					us.setLoginName(user.getLoginName());
					us.setNumConnection(1);
					us.setNumUpload(0);
					us.setNumDowdload(0);
					list.put(user.getLoginName(), us);
				}else{
					us.setNumConnection(us.getNumConnection()+1);
				}
				
			}else{
				this.resultat1 = -1;
			}
		}else{
			this.resultat1 = 0;
		}
		
	}

}
