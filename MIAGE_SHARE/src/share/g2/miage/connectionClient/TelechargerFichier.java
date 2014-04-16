package share.g2.miage.connectionClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TelechargerFichier implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Client client) {
		try {
			String msg;
			Socket socket = client.getClient();
			PrintStream ps =new PrintStream(client.getClient().getOutputStream()); 
			ps.println("<@uploadTXT>");
			
			
			File filename = new File(client.getParametre1()+client.getParametre2()); 
			// reçevoir les infos du serveur
			BufferedReader br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader); 
			
			
			
			if((msg=br1.readLine())!=null){
				ps.println(client.getParametre2());
			}else{
				return -1;
			}
			
			
			while ((msg=br.readLine())!=null) {
				ps.println(msg); //envoyer une ligne de text au serveur.
				System.out.println(msg);
				//System.out.println(br1.readLine());;
				
				//ps.println(msg);   
				
			}
			
			
			ps.println("<@finit>"); // dire au serveur que c'est finit d'envoyer le fichier
			System.out.println("finir d'envoyer le fichier!");
			System.out.println(br1.readLine());;
			br1.close();
			ps.close();
			socket.close();
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
