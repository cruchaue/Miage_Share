package share.g2.miage.connection;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Connection {
	protected ServerSocket serverSocket = null;
	protected Socket socket = null;
	protected OutputStream os = null;
	protected InputStream is = null;

	public Connection() {
		// �����˿ں�
		int port = 10000;
		try {
			// ��������
			serverSocket = new ServerSocket(port);
			// �������
			socket = serverSocket.accept();
			// ���տͻ��˷�������
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);
			// ���
			System.out.println("�ͻ��˷�������Ϊ��" + new String(b, 0, n));
			// ��ͻ��˷��ͷ�������
			os = socket.getOutputStream();
			os.write(b, 0, n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر���������
				os.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (Exception e) {
			}
		}
	}

}
