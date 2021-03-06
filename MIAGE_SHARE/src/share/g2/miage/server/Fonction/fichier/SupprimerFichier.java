package share.g2.miage.server.Fonction.fichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.client.dao.User;
import share.g2.miage.server.outil.Outil;
import share.g2.miage.server.outil.ParametreS;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.fichier.SupprimerFichierJar;

/**
 * <b>Supprime du serveur un fichier choisi par l'utilisateur</b>
 * 
 * <p>Après avoir verifié que l'utilisateur a tous les droits d'effectuer
 *  cette action, le serveur va supprimer de sa memoire le fichier choisi.</p>
 *  
 *  @see User
 *  @see Fichier
 *  @see share.g2.miage.clientJar.fonction.fichier.SupprimerFichier
 *
 */
public class SupprimerFichier extends SupprimerFichierJar {

	public SupprimerFichier(String fichierChemin) {
		super(fichierChemin);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int apresConnection() {
		// Supprimer fichierInfo
		File file = new File(ParametreS.fichiersConfigChemin + this.parametre1
				+ ".txt");
		if (file.exists()) 
			file.delete();


		// Supprimer fichierDroit
		Map<String, String> fichierList = Outil.getDroitsFichier();
		fichierList.remove(this.parametre1);

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

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(
					ParametreS.droit_fichiers));
			fos.write(sb.toString().getBytes());

			fos.close();
			return 1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}


	}

}

