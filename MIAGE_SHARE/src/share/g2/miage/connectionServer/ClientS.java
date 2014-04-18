
package share.g2.miage.connectionServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientS {
	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
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
	public BufferedInputStream getBis() {
		return bis;
	}
	public void setBis(BufferedInputStream bis) {
		this.bis = bis;
	}
	public BufferedOutputStream getBos() {
		return bos;
	}
	public void setBos(BufferedOutputStream bos) {
		this.bos = bos;
	}
	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}
	
	public int closeConnection() {

		try {
			client.close();
			dis.close();
			dos.close();
			bis.close();
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
}
