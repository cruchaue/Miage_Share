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
import share.g2.miage.util.Parametre;
public class ServerFichier   extends Thread {

	private ServerSocket serverFichier = null;
	private boolean demarre = true;


	private static Map<String,Utilisateur> listeUser;
	
	public ServerFichier(){
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

		int portFichier = Integer.valueOf(p.getProperty("portServerFichier"));
		
		
		
		
		chargerUtilisateur();


		try {

			serverFichier = new ServerSocket(portFichier);

			while (demarre) {
				Socket socketFichier = serverFichier.accept();
				new ServerThreadFichier(socketFichier);
			}
			serverFichier.close();

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

	public static void chargerUtilisateur() {
		File filename = new File(Parametre.fichiers_BD_utilisateurs); // è¦�è¯»å�–ä»¥ä¸Šè·¯å¾„çš„inputã€‚txtæ–‡ä»¶
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(filename));

			BufferedReader br = new BufferedReader(reader); // å»ºç«‹ä¸€ä¸ªå¯¹è±¡ï¼Œå®ƒæŠŠæ–‡ä»¶å†…å®¹è½¬æˆ�è®¡ç®—æœºèƒ½è¯»æ‡‚çš„è¯­è¨€
			String line = "";

			while ((line =br.readLine()) != null) {
				System.out.println(line);
				String uStr[] = line.split(";");
				Utilisateur u = new Utilisateur();
				u.setLoginName(uStr[0]);
				u.setPassword(uStr[1]);
				u.setLimite(uStr[2]);
				listeUser.put(uStr[0], u);
				
				System.out.println(uStr[0]+","+uStr[1]+","+uStr[2]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
