package share.g2.miage.connectionClient;

import java.io.IOException;
import java.io.InputStream;

import java.net.Socket;
import java.util.Properties;

public class Client {
	private Socket client = null;
	private String parametre1 = "";// la premier parametre
	private String parametre2 = "";

	public String getParametre1() {
		return parametre1;
	}

	public void setParametre1(String parametre1) {
		this.parametre1 = parametre1;
	}

	public void setParametre2(String parametre2) {
		this.parametre2 = parametre2;
	}

	public String getParametre2() {
		return parametre2;
	}

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
		int port = Integer.valueOf(p.getProperty("portClient"));
		client = null;

		System.out.println("ip:" + p.getProperty("serverIp") + ",port:"
				+ p.getProperty("portClient"));

		try {
			
			client = new Socket(serverIp, port);
			

		} catch (IOException e1) {
			System.out.println("����ʧ�ܣ�");
			e1.printStackTrace();
			return -1;
		}
		
		return 1;

	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
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
