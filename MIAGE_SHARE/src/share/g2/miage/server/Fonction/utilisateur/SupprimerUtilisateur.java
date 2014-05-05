package share.g2.miage.server.Fonction.utilisateur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.outil.ParametreS;
import share.g2.miage.serverJar.fonction.utilisateur.CreerUtilisateurJar;
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
public class SupprimerUtilisateur extends SupprimerUtilisateurJar {
	private String fileName;
	public SupprimerUtilisateur(String fileName){
		this.fileName = fileName;
	}
	@Override
	protected int apresConnection() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));
			
			StringBuffer sb = new StringBuffer();
			String line;
			String[] lineStrT;
			while ((line = reader.readLine()) != null) {
				lineStrT = line.split(";");
				if (!lineStrT[0].equals(this.parametre1)) {
					sb.append(line + "\r\n");
				}
			}
			reader.close();
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(sb.toString());
			out.close();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

}
