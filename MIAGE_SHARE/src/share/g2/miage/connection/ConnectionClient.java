package share.g2.miage.connection;

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
		int port = Integer.valueOf(p.getProperty("port"));
		client = null;

		System.out.println("ip:" + p.getProperty("serverIp") + ",port:"
				+ p.getProperty("port"));

		try {
			// 当触发连接按钮时，实例化一个客户端
			client = new Socket(serverIp, port);
			// 隐藏连接界面，显示通信界面

		} catch (IOException e1) {
			System.out.println("链接失败！");
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
