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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import share.g2.miage.server.dao.Utilisateur;
public class ServerChat   extends Thread {

	private ServerSocket serverChat = null;
	private boolean demarre = true;
	List<Socket> clientLinkList = new ArrayList<Socket>();  
    int count; 
	

	

	private static Map<String,Utilisateur> listeUser;
	
	public ServerChat(){
		start();
	}
	

	public void run() { 
		listeUser = new HashMap<String,Utilisateur>();
		// lire le fichier de parametre
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("ipConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		int portChat = Integer.valueOf(p.getProperty("portServerChat"));

		System.out.println("Port:" + p.getProperty("portServerChat"));

		try {

			serverChat = new ServerSocket(portChat);

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

	public static Map<String, Utilisateur> getListeUser() {
		return listeUser;
	}

	public void closeServer() {
		demarre = false;
	}

}
