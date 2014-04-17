package share.g2.miage.connectionServer;

import java.io.*;
import java.net.*;

import share.g2.miage.util.ParametrePublique;

//--- CreateServerThread
class CreateServerThread extends Thread {
	private ClientS clients;
	private FonctionServerFichier fsf;

	public CreateServerThread(Socket s) throws IOException {
		clients = new ClientS();
		clients.setClient(s);
		clients.setDis(new DataInputStream(s.getInputStream()));
		clients.setDos(new DataOutputStream(s.getOutputStream()));
		clients.setInetAdr(s.getInetAddress());
		
		start();
	}

	public void run() {
		try {
			
			
				String strFonction = clients.getDis().readUTF();
				System.out.println("---  ---"+strFonction);
				if (ParametrePublique.UPLOAD_FICHIER.equals(strFonction)) {
					fsf = new AccepterFichier();
					fsf.excuter(clients);
					
				}
			
		} catch (IOException e) {
		}
	}

	
}
