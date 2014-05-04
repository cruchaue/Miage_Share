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
import share.g2.miage.server.fonction.generalite.Fonction;
import share.g2.miage.server.fonction.generalite.FonctionServer;
import share.g2.miage.util.Outil;
import share.g2.miage.util.Parametre;

public abstract class SupprimerFichier extends FonctionServer {
	
	public SupprimerFichier(ClientS clients){
		this.clients = clients;
		demarrer();
	}

	@Override
	public int executer() {
		try {
			DataInputStream dis = clients.getDis();

			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");

			// Supprimer fichier
			File file = new File(Parametre.fichierChemin + strTemp);
			if (file.exists()) {
				file.delete();
				System.out.println("Le fichier a été supprimé avec succès");
			} else {
				System.out.println("Aucun fichier selectionné");
			}

			// Supprimer fichierInfo
			file = new File(Parametre.fichiersConfigChemin + strTemp
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
					Parametre.droit_fichiers));
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
