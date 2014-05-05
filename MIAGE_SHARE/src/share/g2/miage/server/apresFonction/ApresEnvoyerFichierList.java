package share.g2.miage.server.apresFonction;

import java.util.Iterator;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.outil.Outil;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.EnvoyerFichierList;
import share.g2.miage.util.Parametre;


public class ApresEnvoyerFichierList extends EnvoyerFichierList{

	public ApresEnvoyerFichierList(ClientS clients) {
		super(clients);
	}


	@Override
	protected void avantConnection(){
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
	}
	
	protected void pendantConnection(){
		
	}

}
