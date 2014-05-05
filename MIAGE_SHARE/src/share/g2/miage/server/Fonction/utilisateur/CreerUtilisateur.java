package share.g2.miage.server.Fonction.utilisateur;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.utilisateur.CreerUtilisateurJar;
import share.g2.miage.util.Parametre;

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
public class CreerUtilisateur extends CreerUtilisateurJar {

	@Override
	protected int apresConnection() {

		try {
			System.out.println("Info util : " + this.parametre1);
			String[] lesInfosUtilisateur = this.parametre1
					.split(Parametre.SPEPARER_INFO_UTILISATEUR);

			StringBuffer sb = new StringBuffer();
			sb.append(lesInfosUtilisateur[0] + ";");
			sb.append(lesInfosUtilisateur[1] + ";");
			sb.append(Parametre.UTILISATEUR_DROIT_DEFAULT + ";");
			sb.append(lesInfosUtilisateur[3] + ";\r\n");

			File file = new File(Parametre.fichiers_BD_utilisateurs);

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();

			clients.closeConnection();
			ServerFichier.chargerUtilisateur();
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

}
