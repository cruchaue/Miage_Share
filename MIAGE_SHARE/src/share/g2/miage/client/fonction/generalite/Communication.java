package share.g2.miage.client.fonction.generalite;

import java.net.Socket;

import share.g2.miage.client.dao.ClientConnection;

/**
 * Permet au client de communiquer avec le serveur une fois la connection effectuée.
 * Cette classe définit la méthode executer() qui sera implementée dans chaque fonction utile au client.
 *   
 *
 */
public interface Communication {
	
	/**
	 * Lance la communication avec le serveur.
	 * Chaque fonction ayant un comportement spécifique, toutes devront redéfinir cette méthode.
	 *  
	 * @return -1 si une erreur c'est produite lors de l'éxécution d'une fonction.
	 */
	public int executer();
	
}
