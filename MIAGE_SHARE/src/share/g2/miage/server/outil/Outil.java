package share.g2.miage.server.outil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import share.g2.miage.server.ServerFichier;

/**
 * Classe regroupant quelques fonctions utiles pouvant etre couramment utilisees.
 * 
 */
public class Outil {
	
	/**
	 * Retourne la liste de tous les fichiers avec leur droits d'acces respectifs.
	 * 
	 * @return une Map contenant les droits d'acces au fichier identifier par le nom des fichier.
	 */
	public static Map<String, String> getDroitsFichier() {
		BufferedReader br;
		Map<String, String> droitsFichier = null;
		try {
			droitsFichier = new HashMap<String, String>();
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(ParametreS.droit_fichiers)
					));
			br = new BufferedReader(reader);
			String uneLigne;
			while ((uneLigne = br.readLine()) != null) {
				String[] strTable = uneLigne.split(";");
				if(strTable.length==2){
					droitsFichier.put(strTable[0], strTable[1]);
				}
				
			}
			
			reader.close();
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return droitsFichier;
	}
	
	/**
	 * Verifie si l'utilisateur a les droits suffisant pour effectuer une action sur un fichier.
	 * 
	 * @param droitUtilisateur
	 * 						Les droits d'acces de l'utilisateur.
	 * @param droitFichier
	 * 						Les droits d'acces du fichier.
	 * @return True si l'utilisateur a le droit d'effectuer une action sur un fichier, False sinon.
	 */
	public static boolean comparerDroit(String droitUtilisateur,
			String droitFichier) {
		int droitU = Integer.valueOf(droitUtilisateur);
		int droitF = Integer.valueOf(droitFichier);
		if (droitU <= droitF)
			return true;
		else
			return false;
		
	}
}
