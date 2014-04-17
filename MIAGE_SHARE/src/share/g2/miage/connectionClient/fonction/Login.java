package share.g2.miage.connectionClient.fonction;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.connectionClient.Client;
import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.interfaces.ClientInterface;
import share.g2.miage.util.ParametrePublique;

public class Login implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Client client) {
		try {

			
			//FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();


			dos.writeUTF(ParametrePublique.LOGIN);
			dos.flush();

			dos.writeUTF(client.getParametre1());
			dos.flush();
			
			dos.writeUTF(client.getParametre2());
			dos.flush();
			
			String resultat = dis.readUTF();
			if(ParametrePublique.OK.equals(resultat)){
				System.out.println("login ok");
				
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClientInterface frame = new ClientInterface();
							frame.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
			}else if(ParametrePublique.USER_EXISTE_PAS.equals(resultat)){
				System.out.println("pas de user");
			}else if(ParametrePublique.USER_PW_PAS_CORRECTE.equals(resultat)){
				System.out.println("faute pw");
			}
			
			
			

			System.out.println("finir de supprimer le fichier!");
			//socket.close();
			//fos.close();
			//dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
