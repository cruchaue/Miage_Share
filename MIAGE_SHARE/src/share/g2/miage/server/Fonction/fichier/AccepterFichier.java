package share.g2.miage.server.Fonction.fichier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import share.g2.miage.server.ServerFichier;
import share.g2.miage.server.dao.UtilisateurStat;
import share.g2.miage.client.dao.Fichier;
import share.g2.miage.serverJar.fonction.fichier.AccepterFichierJar;
import share.g2.miage.util.Parametre;
/**
 * <p>Verifie les informations envoyees par l'utilisateur lors de l'upload d'un 
 * fichier par exemple.<br />
 * Ajoute les droit d'acces au fichier et ajoute toutes les informations relative au fichier.</p>
 * 
 * 
 *
 */
public class AccepterFichier extends AccepterFichierJar{

	@Override
	protected int apresConnection() {
		ajouterDroit(this.parametre1);

		creerFichierInfo(this.parametre1, this.parametre2);
		
		//modifier le num de upload
		UtilisateurStat us;
		Map<String,UtilisateurStat> list = ServerFichier.getListeUserStat();
		if((us = list.get(this.parametre2)) == null){
			us = new UtilisateurStat();
			us.setLoginName(this.parametre2);
			us.setNumConnection(1);
			us.setNumUpload(1);
			us.setNumDowdload(0);
			list.put(this.parametre2, us);
		}else{
			us.setNumUpload(us.getNumUpload()+1);
		}
		
		return 1;
	}
	
	/**
	 * Va ajouter toutes les informations du fichier (date de creation, auteur, etc...).
	 * @param fichierNom 
	 * 					Le nom du fichier envoyé.
	 * @param userName
	 * 					Le nom de l'utilisateur qui a envoyé le fichier.
	 * @return -1 si une erreur c'est produite
	 * 
	 * @see Fichier
	 */
	private int creerFichierInfo(String fichierNom, String userName) {
		StringBuffer sb = new StringBuffer();
		String taille;
		String datestr;

		double temp = 1024;
		DecimalFormat df = new DecimalFormat("#.00");

		// obtenir la taille de fichier.
		File file = new File(Parametre.fichierChemin + fichierNom);
		long filesize = file.length();
		if (filesize < 1024) {
			taille = filesize + "b";
		} else if (filesize < 1024 * 1024) {
			temp = filesize / temp;
			taille = df.format(temp) + "kb";
			System.out.println(df.format(temp));
		} else {
			temp = 1024 * 1024;
			temp = filesize / temp;
			taille = df.format(temp) + "mb";
			System.out.println(df.format(temp));
		}
		System.out.println("filesize: --" + filesize);

		// obtenir le temps.
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		datestr = sdf.format(date);

		sb.append(userName);
		sb.append(Parametre.SPEPARER_FICHIER_INFO);
		sb.append(taille);
		sb.append(Parametre.SPEPARER_FICHIER_INFO);
		sb.append(datestr);
		sb.append(Parametre.SPEPARER_FICHIER_INFO);
		sb.append("0");
		sb.append(Parametre.SPEPARER_FICHIER_INFO);
		sb.append(Parametre.FICHIER_DROIT_DEFAULT);
		sb.append(Parametre.SPEPARER_FICHIER_INFO);

		System.out.println(sb.toString());
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(
					Parametre.fichiersConfigChemin + fichierNom + ".txt"));
			byte[] byteFI = sb.toString().getBytes();

			fos.write(byteFI);

			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}
	
	/**
	 * Ajout des droits d'acces au fichier envoyé.
	 * 
	 * @param fichierNom
	 * @return -1 si une erreur c'est produite.
	 * 
	 * @see Fichier
	 */
	private int ajouterDroit(String fichierNom) {

		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(Parametre.droit_fichiers, true)));
			out.write(fichierNom + ";"
					+ Parametre.FICHIER_DROIT_DEFAULT + "\r\n");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		return 1;

	}

}
