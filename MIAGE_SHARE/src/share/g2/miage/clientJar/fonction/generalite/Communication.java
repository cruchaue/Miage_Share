package share.g2.miage.clientJar.fonction.generalite;

import java.net.Socket;

import share.g2.miage.clientJar.dao.ClientConnection;

/**
 * Permet au client de communiquer avec le serveur une fois la connection effectu�e.
 * Cette classe d�finit la m�thode executer() qui sera implement�e dans chaque fonction utile au client.
 *   
 *
 */
public interface Communication {
	
	/**
	 * Lance la communication avec le serveur.
	 * Chaque fonction ayant un comportement sp�cifique, toutes devront red�finir cette m�thode.
	 *  
	 * @return -1 si une erreur c'est produite lors de l'�x�cution d'une fonction.
	 */
	public int commExecuter1();
	
	/**
	 * Lance la communication avec le serveur.
	 * Chaque fonction ayant un comportement sp�cifique, toutes devront red�finir cette m�thode.
	 *  
	 * @return -1 si une erreur c'est produite lors de l'�x�cution d'une fonction.
	 */
	public int commExecuter2();
	
}
