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
import share.g2.miage.server.outil.ParametreS;
import share.g2.miage.client.dao.Fichier;
import share.g2.miage.serverJar.fonction.fichier.AccepterFichierJar;
/**
 * <p>Verifie les informations envoyees par l'utilisateur lors de l'upload d'un 
 * fichier par exemple.<br />
 * Ajoute les droit d'acces au fichier et ajoute toutes les informations relative au fichier.</p>
 * 
 * 
 *
 */
public class AccepterFichier extends AccepterFichierJar{
	
	public AccepterFichier(String fichierChemin) {
		super(fichierChemin);
		// TODO Auto-generated constructor stub
	}

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
		File file = new File(ParametreS.fichierChemin + fichierNom);
		long filesize = file.length();
		if (filesize < 1024) {
			taille = filesize + "b";
		} else if (filesize < 1024 * 1024) {
			temp = filesize / temp;
			taille = df.format(temp) + "kb";
			
		} else {
			temp = 1024 * 1024;
			temp = filesize / temp;
			taille = df.format(temp) + "mb";
			
		}
		

		// obtenir le temps.
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		datestr = sdf.format(date);
		
		sb.append(fichierNom);
		sb.append(ParametreS.SPEPARER_FICHIER_INFO);
		sb.append(userName);
		sb.append(ParametreS.SPEPARER_FICHIER_INFO);
		sb.append(taille);
		sb.append(ParametreS.SPEPARER_FICHIER_INFO);
		sb.append(datestr);
		sb.append(ParametreS.SPEPARER_FICHIER_INFO);
		sb.append("0");
		sb.append(ParametreS.SPEPARER_FICHIER_INFO);
		sb.append(ParametreS.FICHIER_DROIT_DEFAULT);
		sb.append(ParametreS.SPEPARER_FICHIER_INFO);

		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(
					ParametreS.fichiersConfigChemin + fichierNom + ".txt"));
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
					new FileOutputStream(ParametreS.droit_fichiers, true)));
			out.write(fichierNom + ";"
					+ ParametreS.FICHIER_DROIT_DEFAULT + "\r\n");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		return 1;

	}

}
