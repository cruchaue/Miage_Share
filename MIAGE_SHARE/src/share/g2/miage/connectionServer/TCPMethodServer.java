package share.g2.miage.connectionServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMethodServer extends ConnectionServer implements
		FonctionShareServer {

	@Override
	public int demarrerServer() {
		try {
			// l'entrée de serveur
			BufferedReader br;
			// le sortie de serveur
			PrintStream ps;
			StringBuffer sb = new StringBuffer();

			br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			ps = new PrintStream(socket.getOutputStream());
			String msg;
			// accepter le fichier
			while ((msg = br.readLine()) != null) {
				sb.append("reçu：" + msg + "\n");
				ps.println(msg);
				if (msg.equals("quit")) {
					sb.append("客户端“2000”已退出！" + "\n");
					sb.append("服务器程序将退出！");
					System.out.print(sb.toString());
					break;
				}
			}
			ps.close();
			br.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
