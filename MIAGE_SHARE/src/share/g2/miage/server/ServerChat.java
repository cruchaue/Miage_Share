package share.g2.miage.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.server.outil.ParametreS;

/**
 * Lance le serveur, dans un nouveau Thread, qui va g�rer un chat. 
 * <p>Cette classe contient toutes les informations n�cessaires aux chat.
 * <ul>
 * 	<li>Liste d'Utilisateurs connect�s au chat</li>
 * 	<li>Liste des sockets des utilisateurs</li>
 * 	<li> Le nombre d'utilisateurs connect�s</li>
 * </ul>
 *</p>
 */
public class ServerChat   extends Thread {
	
	/**
	 * Socket sur lequel les clients vont pouvoir se connecter afin de pouvoir communiquer avec le serveur Chat et donc avec d'autres Utilisateurs.
	 */
	private ServerSocket serverChat = null;
	
	/**
	 * 
	 */
	private boolean demarre = true;
	
	/**
	 * Liste des sockets de tout les utilisateurs pour que le serveur relai les messages 
	 * des utilisateurs ce qui permet une discution � plusieurs clients (type salon).
	 * 
	 *  Cette liste peut �tre vide.
	 */
	List<Socket> clientLinkList = new ArrayList<Socket>();  
	
	/**
	 * Nombre d'utilisateurs connecter au chat. 
	 * count >= 0.
	 */
    int count; 
	
    /**
     * Collection d'Utilisateurs qui sont connect�s sur le chat.
     * Chaque utilisateur est identifi� par son nom/pseudo.
     * 
     * @see Utilisateur
     * @see Collection
     * @see Map
     */
	private static Map<String,Utilisateur> listeUser;
	
	/**
	 * D�marre le serveur de Chat.
	 */
	public ServerChat(){
		start();
	}
	
	@Override
	public void run() { 
		listeUser = new HashMap<String,Utilisateur>();
		// lire le fichier de parametre

		try {

			serverChat = new ServerSocket(ParametreS.portServerChat);

			while (demarre) {
				
				Socket socketChat = serverChat.accept();
				clientLinkList.add(socketChat);  
                new ServerThreadChat(clientLinkList, socketChat);
			}
			serverChat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Retourne une Map<String, Utilisateur> qui contient tous les Utilisateur connect� au chat. Permet d'�tablir une liste de personne connect� par exemple. 
	 * @return La Collection de tous les Utilisateur connect� au chat.
	 * 
	 * @see Collection
	 * @see Utilisateur
	 */
	public static Map<String, Utilisateur> getListeUser() {
		return listeUser;
	}
	
	/**
	 * 
	 */
	public void closeServer() {
		demarre = false;
	}

}
