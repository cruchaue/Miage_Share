package share.g2.miage.serverJar.fonction.generalite;

import share.g2.miage.serverJar.dao.ClientS;

/**
 * <p>Superclasse (qui implemente l'interface Communication) dont 
 * toutes les actions demandees par un client et executable par le serveur decouleront.</p>
 * 
 * <p>Toutes fonctions nouvellement implementees devra heritee de cette classe afin d'assurer le bon fonctionnement de cette derniere 
 * lors d'envoi ou la recuperation d'informations par le serveur. </p>
 *
 * <p>C'est cette classe qui sera chargé d'executer toutes les differentes fonctions permettant le 
 * bon deroulement de l'action</p>
 * 
 * <p>Le deroulement s'effectue en plusieurs etapes: 
 * 	<ul>
 * 		<li>une action avant la connection</li>
 * 		<li>une action une fois la connection effectuee</li>
 * 		<li>une derniere action apres la connection</li>
 * 	</ul>
 * </p>
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
	protected String resultat1 = "";
	
	/**
	 * 
	 */
	protected String resultat2 = "";
	
	/**
	 * Lance la séquence d'execution de l'action demandee.
	 */
	public void demarrer(ClientS clients){
		this.clients = clients;
		avantConnection();
		commExecuter1();
		pendantConnection();
		commExecuter2();
		clients.closeConnection();
		apresConnection();
	}
	
	
	@Override
	public int commExecuter2(){
		return 1;
	}
	
	/**
	 * 
	 */
	protected void avantConnection(){}
	
	protected void pendantConnection(){}
	
	protected void apresConnection(){}
}
