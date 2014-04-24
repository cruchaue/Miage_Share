package share.g2.miage.server.fonction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.fonction.interfaces.FonctionServer;
import share.g2.miage.util.Outil;
import share.g2.miage.util.Parametre;

public class SupprimerFichier implements FonctionServer {

	@Override
	public int excuter(ClientS clients) {
		try {
			DataInputStream dis = clients.getDis();

			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");

			// Supprimer fichier
			File file = new File(ServerFichier.getFichierChemin() + strTemp);
			if (file.exists()) {
				file.delete();
				System.out.println("Le fichier a été supprimé avec succès");
			} else {
				System.out.println("Aucun fichier selectionné");
			}

			// Supprimer fichierInfo
			file = new File(ServerFichier.getFichiersConfigChemin() + strTemp
					+ ".txt");
			if (file.exists()) {
				file.delete();
				System.out.println("Le fichier a été supprimé avec succès");
			} else {
				System.out.println("Aucun fichier selectionné");
			}

			// Supprimer fichierDroit
			Map<String, String> fichierList = Outil.getDroitsFichier();
			fichierList.remove(strTemp);

			StringBuffer sb = new StringBuffer();
			Iterator iter = fichierList.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry) iter.next();
				String key = entry.getKey();
				String val = entry.getValue();
				sb.append(key);
				sb.append(";");
				sb.append(val);
				sb.append("\r\n");
			}

			FileOutputStream fos = new FileOutputStream(new File(
					ServerFichier.getDroit_fichiers()));
			fos.write(sb.toString().getBytes());

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
