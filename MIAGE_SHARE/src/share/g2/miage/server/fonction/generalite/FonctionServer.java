package share.g2.miage.server.fonction.generalite;

import share.g2.miage.server.dao.ClientS;

/**
 * Superclasse (qui implémente l'interface Communication) dont toutes les actions demandées par un client et executable par le serveur découleront.
 * Toutes fonctions nouvellement implementées devra héritée de cette classe afin d'assurer le bon fonctionnement de cette dernière 
 * lors d'envoi ou la récuperation d'informations par le serveur.  
 *
 */
public  abstract class FonctionServer implements
Communication {
	
	/**
	 * 
	 */
	protected ClientS clients;
	
	/**
	 * 
	 */
	protected String parametre1 = "";
	
	/**
	 * 
	 */
	protected String parametre2 = "";
	
	/**
	 * 
	 */
	protected void demarrer(){
		commExecuter();
		clients.closeConnection();
		apresConnection();
	}
	
	/**
	 * 
	 */
	protected abstract void apresConnection();
}
