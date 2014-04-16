package share.g2.miage.connectionClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import share.g2.miage.util.FonctionPublique;
import share.g2.miage.util.ParametrePublique;

public class UploadFichier implements FonctionClientFichier {

	@Override
	public int excuter(Client client) {
		try {

			Socket socket = client.getClient();
			File filename = new File(client.getParametre1());

			// reçevoir les infos du serveur
			// BufferedReader br1 = new BufferedReader(new
			// InputStreamReader(client.getInputStream()));
			FileInputStream fis = new FileInputStream(filename);
			// BufferedReader br = new BufferedReader(reader);
			String msg;
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());

			byte[] sendBytes = new byte[ParametrePublique.LENGTH_ENVOYER];
			int length = 0;

			dos.write(ParametrePublique.UPLOAD_FICHIER.getBytes());
			length = dis.read(sendBytes, 0, sendBytes.length);
			if ("ok".equals(FonctionPublique.byteTableauToString(sendBytes,
					length))) {
				dos.write(client.getParametre2().getBytes());
				if ("ok".equals(FonctionPublique.byteTableauToString(sendBytes,
						length))) {
					while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
						dos.write(sendBytes, 0, length);
						dos.flush();
						System.out.println("envoyer le fichier!");
					}
				}
			}

			// ps.println("<@finit>"); // dire au serveur que c'est finit
			// d'envoyer le fichier
			System.out.println("finir d'envoyer le fichier!");

			// System.out.println(br1.readLine());;
			// br1.close();
			// ps.close();
			socket.close();
			fis.close();
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
