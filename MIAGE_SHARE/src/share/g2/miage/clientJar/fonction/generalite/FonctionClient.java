package share.g2.miage.clientJar.fonction.generalite;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

/**
 * Superclasse (qui impl�mente l'interface Fonction) dont toutes les fonctions utilisables par un client d�couleront.
 * Toutes fonctions nouvellement implement�es devra h�rit�e de cette classe afin d'assurer le bon fonctionnement de cette derni�re 
 * lors d'envoi ou la r�cuperation d'informations sur le serveur.  
 *
 */
public abstract class FonctionClient<T> implements
Communication {

	/**
	 * instanciation d'un nouvel objet ClientConnection qui permettra de communiquer avec le serveur.
	 * 
	 * @see ClientConnection
	 */
	protected ClientConnection client = new ClientConnection();

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
	protected String parametre3 = "";

	/**
	 * 
	 */
	protected String resultat1 = ""; 

	/**
	 * 
	 */
	protected String resultat2 = ""; 

	/**
	 * 
	 */
	protected T resultat3; 

	public T getResultat3() {
		return resultat3;
	}

	/**
	 * 
	 */
	public FonctionClient(){
		client.demarrer();
	}

	/**
	 * @return TODO
	 * 
	 * execution de la communication et la deconnection avec le serveur.
	 */
	public int demarrer(){
		int rs;
		rs = avantConnection();

		if(rs==1){
			rs = commExecuter1();
		}else{
			return rs;
		}

		if(rs==1){
			rs = pendantConnection();
		}else{
			return rs;
		}

		if(rs==1){
			rs = commExecuter2();
			client.closeConnection();
		}else{
			client.closeConnection();
			return rs;
		}

		if(rs==1){
			rs = apresConnection();
		}else{
			return rs;
		}

		return rs;
	}

	@Override
	public int commExecuter2(){return 1;}

	/**
	 * @return TODO
	 * 
	 */
	protected int avantConnection(){return 1;}

	protected int pendantConnection(){return 1;}

	protected int apresConnection(){return 1;}


	/**
	 * 
	 * @return
	 */
	public String getResultat1() {
		return resultat1;
	}

	/**
	 * 
	 * @return
	 */
	public String getResultat2() {
		return resultat2;
	}

}
