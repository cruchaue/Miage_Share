package share.g2.miage.server.Fonction.utilisateur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import share.g2.miage.client.outil.ParametreC;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.outil.ParametreS;
import share.g2.miage.serverJar.fonction.utilisateur.CreerUtilisateurJar;
import share.g2.miage.serverJar.fonction.utilisateur.ModifierDroitUtilisateurJar;
import share.g2.miage.serverJar.fonction.utilisateur.SupprimerUtilisateurJar;

/**
 * <b>Creation d'un utilisateur</b>
 * 
 * <p>
 * Permettre de creer le profil d'un utilisateur sur le serveur lors de
 * l'inscription de celui-ci après avoir verifier les donnees envoyees.
 * </p>
 * 
 * @see CreerUtilisateurJar
 * 
 */
public class ModifierDroitUtilisateur extends ModifierDroitUtilisateurJar {
	private String fileName;
	public ModifierDroitUtilisateur(String fileName){
		this.fileName = fileName;
	}
	@Override
	protected int apresConnection() {
		
		File file = new File(fileName);
		InputStreamReader reader;
		BufferedReader br;
		try {
			reader = new InputStreamReader(new FileInputStream(file));

			br = new BufferedReader(reader);
			String line = "";
			StringBuffer sb = new StringBuffer();
			String Newligne=System.getProperty("line.separator"); 
			while ((line = br.readLine()) != null) {
				
				String uStr[] = line.split(";");
				if (uStr[0].equals(this.parametre1)) {
					uStr[2] = this.parametre2;
				}
				sb.append(uStr[0] + ";" + uStr[1]+";" + uStr[2]+";" + uStr[3]+";"+Newligne);

			}		
			
			File file2 = new File(fileName);
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		return 1;

		
		
		
		
		
		/*
		File file = new File(fileName);
		InputStreamReader reader;
		BufferedReader br;
		try {
			reader = new InputStreamReader(new FileInputStream(file));

			br = new BufferedReader(reader);
			String line = "";
			StringBuffer sb = new StringBuffer();
			String Newligne=System.getProperty("line.separator"); 
			while ((line = br.readLine()) != null) {
				
				String uStr[] = line.split(";");
				if (uStr[0].equals(this.parametre1)) {
					uStr[1] = this.parametre2;
					

				}
				sb.append(uStr[0] + ";" + uStr[1]+Newligne);

			}		
			

			File file2 = new File(ParametreS.droit_fichiers);
			FileWriter fw = new FileWriter(file2.getAbsoluteFile(), false);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
