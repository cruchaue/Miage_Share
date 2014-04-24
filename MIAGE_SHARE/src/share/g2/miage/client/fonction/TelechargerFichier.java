package share.g2.miage.client.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.interfaces.Fonction;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public class TelechargerFichier implements
		Fonction {

	

	@Override
	public int excuter(Client client) {
		try {

			
			//FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			byte[] sendBytes = new byte[Parametre.LENGTH_ENVOYER];
			int length = 0;

			dos.writeUTF(Parametre.TELECHARGER_FICHIER);
			dos.flush();

			dos.writeUTF(client.getParametre2());
			dos.flush();
			
			
			FileOutputStream fos = new FileOutputStream(new File(client.getParametre1()+ client.getParametre2()));
			while ((length = dis.read(sendBytes, 0, sendBytes.length)) > 0) {
				fos.write(sendBytes, 0, length);
				fos.flush();
			}

			fos.close();
			
			

			JOptionPane.showMessageDialog(null, "Fichier telecharger avec succès");
			//socket.close();
			fos.close();
			//dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
