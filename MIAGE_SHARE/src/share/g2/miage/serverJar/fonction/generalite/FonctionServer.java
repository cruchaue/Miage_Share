package share.g2.miage.serverJar.fonction.generalite;

import share.g2.miage.serverJar.dao.ClientS;

/**
 * Superclasse (qui impl�mente l'interface Communication) dont toutes les actions demand�es par un client et executable par le serveur d�couleront.
 * Toutes fonctions nouvellement implement�es devra h�rit�e de cette classe afin d'assurer le bon fonctionnement de cette derni�re 
 * lors d'envoi ou la r�cuperation d'informations par le serveur.  
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
		avantConnection();
		commExecuter1();
		pendantConnection();
		commExecuter2();
		clients.closeConnection();
		apresConnection();
	}
	
	
	/** ????? pas forcement realiser
	 * Lance la communication avec le client.
	 * Chaque fonction ayant un comportement sp�cifique, toutes devront red�finir cette m�thode.
	 *  
	 * @return -1 si une erreur c'est produite lors de l'�x�cution d'une fonction.
	 */
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