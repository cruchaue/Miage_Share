package share.g2.miage.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 * Lorqu'une demande d'action est effectue par un client sur le serveur Chat,
 * un nouveau Thread est cree jusqu'a la fin de la demande. 
 *
 * @see Thread
 */
public class ServerThreadChat extends Thread {
	List<Socket> clientLinkList;
	Socket clientLink;
	BufferedReader br;
	PrintStream ps;
	String msg;
	String ip;

	/**
	 * 
	 * @param clientLinkList
	 * @param clientLink
	 */
	public ServerThreadChat(List<Socket> clientLinkList, Socket clientLink) {
		this.clientLinkList = clientLinkList;
		this.clientLink = clientLink;
		start();
	}

	@Override
	public void run() {

		try {
			br = new BufferedReader(new InputStreamReader(
					clientLink.getInputStream()));
			// ip=clientLink.getInetAddress().getHostAddress();
			while (!clientLink.isClosed()) {
				while (null != (msg = br.readLine())) {
					for (int i = 0; i < clientLinkList.size(); i++) {
						ps = new PrintStream(clientLinkList.get(i)
								.getOutputStream());
						ps.println(msg);

						ps.flush();
					}
				}
			}

			

			clientLink.close();
			br.close();
			ps.close();

		} catch (IOException e) {
			//e.printStackTrace();
			
			//supprimer socket fermé de la liste des sockets
			int indexRemove = 0;
			for(int i = 0; i < clientLinkList.size();i++){
				if(clientLinkList.get(i).equals(clientLink)){
					indexRemove = i;

				}
			}
			clientLinkList.remove(indexRemove);
			System.out.println("Un utilisateur est parti de Chatroom!");
		} 

	}

}
