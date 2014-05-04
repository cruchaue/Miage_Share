package share.g2.miage.client.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
/**
 * La classe ClientConnection contient toutes les méthodes qui permettent
 * de se connecter et de communiquer grâce a un système de sockets et d'envoyer ou de récuperer 
 * des données sur un flux bufferisé.
 * 
 */
public class ClientConnection {
	
	/**
	 * socket du client
	 */
	private Socket client = null;
	
	/**
	 * flux de données entrant de type primitifs
	 */
	private DataInputStream dis;
	
	/**
	 * flux de données sortant de type primitifs
	 */
	private DataOutputStream dos;
	
	/**
	 * flux de données entrant bufferisé
	 */
	private BufferedInputStream bis;
	
	/**
	 * flus de données sortant bufférisé
	 */
	private BufferedOutputStream bos;
	
	/**
	 * Renvoie le flux entrant bufferisé afin recupérer les données contenues dans le buffer.
	 * @return Le flux entrant bufferisé
	 */
	public BufferedInputStream getBis() {
		return bis;
	}
	
	/**
	 * Renvoi le flux entrant bufferisé afin de lui insérer les données à envoyer.
	 * @return Le flux sortant bufferisé
	 */
	public BufferedOutputStream getBos() {
		return bos;
	}

	/**
	 * 
	 * @return Le flux de données entrant 
	 */
	public DataInputStream getDis() {
		return dis;
	}
	
	/**
	 * 
	 * @return Le flux de données sortant 
	 */
	public DataOutputStream getDos() {
		return dos;
	}
	
	/**
	 * Méthode permettant de lancer la séquence de connection du client à un serveur.
	 *
	 * @return -1 si une erreur c'est produite durant la connection.
	 */
	public int demarrer() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("ipConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String serverIp = p.getProperty("serverIp");
		int port = Integer.valueOf(p.getProperty("portClientFichier"));
		client = null;

		System.out.println("ip:" + p.getProperty("serverIp") + ",port:"
				+ p.getProperty("portClientFichier"));

		try {

			client = new Socket(serverIp, port);
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());

			bis = new BufferedInputStream(client.getInputStream());
			bos = new BufferedOutputStream(client.getOutputStream());
		} catch (IOException e1) {
			System.out.println("ï¿½ï¿½ï¿½ï¿½Ê§ï¿½Ü£ï¿½");
			e1.printStackTrace();
			return -1;
		}

		return 1;

	}
	
	/**
	 * 
	 * @return le socket du client.
	 */
	public Socket getClient() {
		return client;
	}
	
	/**
	 * Met à jour le socket du client.
	 * @param client
	 * 			Le nouveau socket du client
	 */
	public void setClient(Socket client) {
		this.client = client;
	}
	
	/**
	 * Fermeture de la connection entre le client et le serveur.
	 * @return -1 si une erreur c'est produite durant la fermeture de la connection.
	 */
	public int closeConnection() {

		try {
			client.close();
			dis.close();
			dos.close();
			bis.close();
			bos.close();
			System.out.println("connexion fermÃ©e");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
