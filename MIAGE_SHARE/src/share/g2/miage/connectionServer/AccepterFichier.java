package share.g2.miage.connectionServer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import share.g2.miage.util.ParametrePublique;

public class AccepterFichier implements FonctionServerFichier {

	@Override
	public int excuter(ClientS clients) {
		try {

			DataInputStream dis = clients.getDis();
			FileOutputStream fos = null;

			byte[] byteTemp = new byte[1024];
			int lengthTemp = 0;
			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");

			System.out.println(lengthTemp + ", " + strTemp);

			fos = new FileOutputStream(new File(Server.getFichierChemin()
					+ strTemp));
			while ((lengthTemp = dis.read(byteTemp, 0, byteTemp.length)) > 0) {
				fos.write(byteTemp, 0, lengthTemp);
				fos.flush();
			}

			fos.close();
			clients.closeConnection();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
