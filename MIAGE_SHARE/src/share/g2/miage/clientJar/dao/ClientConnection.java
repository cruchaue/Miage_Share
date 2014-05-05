package share.g2.miage.clientJar.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
/**
 * La classe ClientConnection contient toutes les m�thodes qui permettent
 * de se connecter et de communiquer gr�ce a un syst�me de sockets et d'envoyer ou de r�cuperer 
 * des donn�es sur un flux bufferis�.
 * 
 */
public class ClientConnection {

	/**
	 * socket du client
	 */
	private Socket client = null;

	/**
	 * flux de donn�es entrant de type primitifs
	 */
	private DataInputStream dis;

	/**
	 * flux de donn�es sortant de type primitifs
	 */
	private DataOutputStream dos;

	/**
	 * flux de donn�es entrant bufferis�
	 */
	private BufferedInputStream bis;

	/**
	 * flus de donn�es sortant buff�ris�
	 */
	private BufferedOutputStream bos;

	/**
	 * Renvoie le flux entrant bufferis� afin recup�rer les donn�es contenues dans le buffer.
	 * @return Le flux entrant bufferis�
	 */
	public BufferedInputStream getBis() {
		return bis;
	}

	/**
	 * Renvoi le flux entrant bufferis� afin de lui ins�rer les donn�es � envoyer.
	 * @return Le flux sortant bufferis�
	 */
	public BufferedOutputStream getBos() {
		return bos;
	}

	/**
	 * 
	 * @return Le flux de donn�es entrant 
	 */
	public DataInputStream getDis() {
		return dis;
	}

	/**
	 * 
	 * @return Le flux de donn�es sortant 
	 */
	public DataOutputStream getDos() {
		return dos;
	}

	/**
	 * M�thode permettant de lancer la s�quence de connection du client � un serveur.
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
	 * Met � jour le socket du client.
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
			System.out.println("connexion fermée");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
