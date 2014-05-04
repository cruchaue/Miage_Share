package share.g2.miage.server.fonction.generalite;

import java.net.Socket;

import share.g2.miage.server.dao.ClientS;

/**
 * Permet au serveur de communiquer avec le client une fois la connection effectu�e.
 * Cette classe d�finit la m�thode executer() qui sera implement�e dans chaque fonction utile au serveur.
 *   
 *
 */
public interface Communication {
	
	/**
	 * Lance la communication avec le client.
	 * Chaque fonction ayant un comportement sp�cifique, toutes devront red�finir cette m�thode.
	 *  
	 * @return -1 si une erreur c'est produite lors de l'�x�cution d'une fonction.
	 */
	public int commExecuter();
}
