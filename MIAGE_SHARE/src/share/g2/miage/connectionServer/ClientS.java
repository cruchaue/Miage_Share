package share.g2.miage.connectionServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientS {
	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	private InetAddress inetAdr;
	public InetAddress getInetAdr() {
		return inetAdr;
	}
	public void setInetAdr(InetAddress inetAdr) {
		this.inetAdr = inetAdr;
	}
	public Socket getClient() {
		return client;
	}
	public void setClient(Socket client) {
		this.client = client;
	}
	public DataInputStream getDis() {
		return dis;
	}
	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}
	public DataOutputStream getDos() {
		return dos;
	}
	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}
	
	public int closeConnection() {

		try {
			client.close();
			dis.close();
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
}
