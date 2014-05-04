package share.g2.miage.server.fonction.generalite;

import java.net.Socket;

import share.g2.miage.server.dao.ClientS;

/**
 * Permet au serveur de communiquer avec le client une fois la connection effectuée.
 * Cette classe définit la méthode executer() qui sera implementée dans chaque fonction utile au serveur.
 *   
 *
 */
public interface Communication {
	
	/**
	 * Lance la communication avec le client.
	 * Chaque fonction ayant un comportement spécifique, toutes devront redéfinir cette méthode.
	 *  
	 * @return -1 si une erreur c'est produite lors de l'éxécution d'une fonction.
	 */
	public int commExecuter();
}
