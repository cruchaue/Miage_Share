package share.g2.miage.connectionServer;

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

public class Server {

	private ServerSocket serverSocket = null;
	private static String fichierChemin;
	private boolean demarre = true;
	private static Map<String,Utilisateur> listeUser;

	public static String getFichierChemin() {
		return fichierChemin;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public int demarrer() {
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

		int port = Integer.valueOf(p.getProperty("portServer"));
		this.fichierChemin = p.getProperty("fichierChemin");
		
		chargerUtilisateur(p.getProperty("BD_utilisateurs"));

		System.out.println("Port:" + p.getProperty("portServer"));

		try {

			serverSocket = new ServerSocket(port);

			while (demarre) {
				Socket socket = serverSocket.accept();
				new CreateServerThread(socket);
			}
			serverSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 1;

	}

	public static Map<String, Utilisateur> getListeUser() {
		return listeUser;
	}

	public void closeServer() {
		demarre = false;
	}

	private void chargerUtilisateur(String cheminBDUtilisateur) {
		File filename = new File(cheminBDUtilisateur); // 要读取以上路径的input。txt文件
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(filename));

			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			String line = "";

			while ((line =br.readLine()) != null) {
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
