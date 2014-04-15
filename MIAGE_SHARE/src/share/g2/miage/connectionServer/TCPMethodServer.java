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
			// 服务器端的输入流
			BufferedReader br;
			// 服务器端的输出流
			PrintStream ps;
			StringBuffer sb = new StringBuffer();

			br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			ps = new PrintStream(socket.getOutputStream());
			String msg;
			// 如果输入流不为空,将接受到的信息打印到相应的文本框中并反馈回收到的信息
			while ((msg = br.readLine()) != null) {
				sb.append("服务器端收到：" + msg + "\n");
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
