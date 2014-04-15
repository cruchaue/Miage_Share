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
			// �������˵�������
			BufferedReader br;
			// �������˵������
			PrintStream ps;
			StringBuffer sb = new StringBuffer();

			br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			ps = new PrintStream(socket.getOutputStream());
			String msg;
			// �����������Ϊ��,�����ܵ�����Ϣ��ӡ����Ӧ���ı����в��������յ�����Ϣ
			while ((msg = br.readLine()) != null) {
				sb.append("���������յ���" + msg + "\n");
				ps.println(msg);
				if (msg.equals("quit")) {
					sb.append("�ͻ��ˡ�2000�����˳���" + "\n");
					sb.append("�����������˳���");
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
