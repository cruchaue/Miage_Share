package share.g2.miage.serverJar.fonction.fichier;

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
import share.g2.miage.server.outil.Outil;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.generalite.Communication;
import share.g2.miage.serverJar.fonction.generalite.FonctionServer;
import share.g2.miage.util.Parametre;

public abstract class SupprimerFichierJar extends FonctionServer {
	
	@Override
	public int commExecuter1() {
		try {
			DataInputStream dis = clients.getDis();

			this.parametre1 = dis.readUTF();
			System.out.println(this.parametre1 + ",");

			// Supprimer fichier
			File file = new File(Parametre.fichierChemin + this.parametre1);
			if (file.exists()) {
				file.delete();
				System.out.println("Le fichier a été supprimé avec succès");
			} else {
				System.out.println("Aucun fichier selectionné");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
