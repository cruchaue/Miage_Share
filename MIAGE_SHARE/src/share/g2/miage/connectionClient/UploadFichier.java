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

public class UploadFichier implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Socket client,String fichierNom) {
		try {
			File filename = new File(fichierNom); 
			// reçevoir les infos du serveur
			BufferedReader br1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader); 
			String msg;
			PrintStream ps =new PrintStream(client.getOutputStream()); 
			
				ps.println("<@uploadTXT>");
			
			
			if((msg=br1.readLine())!=null){
				ps.println(fichierNom);
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
			client.close();
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
