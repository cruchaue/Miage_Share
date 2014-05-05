package share.g2.miage.server.Fonction.fichier;

import java.util.Iterator;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.outil.Outil;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.fichier.EnvoyerFichierListJar;
import share.g2.miage.util.Parametre;


public class EnvoyerFichierList extends EnvoyerFichierListJar{

	public EnvoyerFichierList(ClientS clients) {
		super(clients);
	}


	@Override
	protected void pendantConnection(){
		String userName = this.parametre1;
		Map<String,Utilisateur> users = ServerFichier.getListeUser();
		String droitU = users.get(userName).getLimite();
		Map<String,String> fichierList = Outil.getDroitsFichier();
		StringBuffer sb = new StringBuffer();
		Iterator iter = fichierList.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry<String, String> entry = (Map.Entry) iter.next(); 
		    String key = entry.getKey(); 
		    String val = entry.getValue(); 
		    if(Outil.comparerDroit(droitU, val)){
		    	sb.append(key+Parametre.SEPARATEUR);
		    }
		    
		} 
		
		this.parametre2 = sb.toString();
	}

}
