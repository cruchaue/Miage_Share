package share.g2.miage.connectionClient;

import java.io.IOException;
import java.io.InputStream;

import java.net.Socket;
import java.util.Properties;

public abstract class ConnectionClient {
	protected Socket client = null;

	public ConnectionClient() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("ipConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String serverIp = p.getProperty("serverIp");
		int port = Integer.valueOf(p.getProperty("portClient"));
		client = null;

		System.out.println("ip:" + p.getProperty("serverIp") + ",port:"
				+ p.getProperty("portClient"));

		try {
			
			client = new Socket(serverIp, port);
			

		} catch (IOException e1) {
			System.out.println("����ʧ�ܣ�");
			e1.printStackTrace();
		}

	}

	public int closeConnection() {

		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
