package share.g2.miage.server.Fonction.fichier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.outil.Outil;
import share.g2.miage.server.outil.ParametreS;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.fichier.EnvoyerFichierListJar;

/**
 * Envoie la liste de tout les fichiers stockes sur le serveur lorsqu'une demande a ete faite.
 *
 */
public class EnvoyerFichierList extends EnvoyerFichierListJar{

	@Override
	protected int pendantConnection(){
		String userName = this.parametre1;
		Map<String,Utilisateur> users = ServerFichier.getListeUser();
		String droitU = users.get(userName).getLimite();
		Map<String,String> fichierList = Outil.getDroitsFichier();
		List<String> fichierListList = new ArrayList<String>();
		Iterator iter = fichierList.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry<String, String> entry = (Map.Entry) iter.next(); 
		    String key = entry.getKey(); 
		    String val = entry.getValue(); 
		    if(Outil.comparerDroit(droitU, val)){
		    	fichierListList.add(key);
		    }
		    
		} 
		
		this.parametre2 = share.g2.miage.serverJar.outil.Outil.ListToString(fichierListList);
		return 1;
	}

}
