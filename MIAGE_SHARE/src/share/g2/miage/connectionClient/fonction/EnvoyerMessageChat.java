package share.g2.miage.connectionClient.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.util.ParametrePublique;

public class EnvoyerMessageChat {

	public int excuter(Client client,String message) {
		try {


			DataInputStream dis = client.getDis();

			byte[] sendBytes = new byte[ParametrePublique.LENGTH_ENVOYER];


			int length = 0;

			FileOutputStream fos = new FileOutputStream(message);

			fos.write(sendBytes, 0, length);
			fos.flush();
			fos.close();



			JOptionPane.showMessageDialog(null, "Message envoyé");
			//socket.close();
			fos.close();
			//dos.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return 1;

	}
}
