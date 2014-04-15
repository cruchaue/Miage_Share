package share.g2.miage.connectionServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public abstract class ConnectionServer {

	protected ServerSocket serverSocket = null;
	protected Socket socket = null;

	public ConnectionServer() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("ipConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		int port = Integer.valueOf(p.getProperty("portServer"));
	

		System.out.println(",port:"
				+ p.getProperty("portServer"));
		
		
		try {
			// cr��er la connection
			serverSocket = new ServerSocket(port);
			// saisir la connection de client
			socket = serverSocket.accept();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int closeConnection() {

		try {

			socket.close();
			serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
