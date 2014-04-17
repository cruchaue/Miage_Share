package share.g2.miage.connectionServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {

	private ServerSocket serverSocket = null;
	private static String fichierChemin;
	private boolean demarre = true;
	

	public static String getFichierChemin() {
		return fichierChemin;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public int demarrer() {
		
		//lire le fichier de parametre
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

		System.out.println("Port:"
				+ p.getProperty("portServer"));
		
		
		
		
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

	public void closeServer() {
		demarre = false;
	}

}
