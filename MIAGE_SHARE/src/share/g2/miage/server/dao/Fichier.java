package share.g2.miage.server.dao;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import share.g2.miage.client.outil.ParametreC;
import share.g2.miage.clientJar.fonction.statistiques.interne.FichierTest;
import share.g2.miage.server.ServerFichier;

/**
 * <b>Representation d'un fichier</b>
 * 
 * <p>Contient toutes les informations necessaires a l'identification du fichier sur le serveur
 *  ainsi que toutes les methodes qui permettent d'acceder aux differents parametres.
 * <ul>
 * 		<li>Le nom du fichier</li>
 * 		<li>L'auteur</li>
 * 		<li>La taille du fichier</li>
 * 		<li>La date de creation</li>
 * 		<li>Le nombre de fois que le fichier a ete telecharge</li>
 * 		<li>les droits d'acces</li>
 * 		<li>La liste des commentaires associe</li>
 * </ul>
 * </p>
 *
 */
public class Fichier {
	private String nom;
	private String auteur;
	private String taille;
	private String date;
	private int numTelechargement;
	private int droit;
	private List<Commentaire> comms;
	private String commsStr;
	private int nbDown,nbCom;


	/**
	 * Transforme les informations du fichier enregistes sous forme d'un String sous la forme d'un objet.
	 * 
	 * @param infoFichier
	 * 					Les informations du fichier.
	 * 
	 */
	public Fichier(String infoFichier) {
		String[] strFI = infoFichier.split(ParametreC.SPEPARER_FICHIER_INFO);
		this.nom = strFI[0];
		this.auteur = strFI[1];
		this.taille = strFI[2];

		this.date = strFI[3];

		this.numTelechargement = Integer.valueOf(strFI[4]);
		this.droit = Integer.valueOf(strFI[5]);

		if (strFI.length > 6) {
			String[] strCMMS = strFI[6].split(ParametreC.SPEPARER_FICHIER_COMMENTAIRE1);
			this.comms = new ArrayList<Commentaire>();
			for (int i = 0; i < strCMMS.length; i++) {
				Commentaire cmm = new Commentaire();
				String[] strCMM = strCMMS[i].split(ParametreC.SPEPARER_FICHIER_COMMENTAIRE2);
				cmm.setUser(strCMM[0]);

				cmm.setDate(strCMM[1]);

				cmm.setContenu(strCMM[2]);
				this.comms.add(cmm);
			}
		}

	}

	/**
	 * Transforme les informations contenus dans un objet Fichier en un String.
	 * 
	 * @return un String contenant les informations d'un objet Fichier.
	 */
	public String fichierToString(){




		StringBuffer sb =  new StringBuffer();
		
		sb.append(this.nom);
	    sb.append(ParametreC.SPEPARER_FICHIER_INFO);
	    sb.append(this.auteur);
	    sb.append(ParametreC.SPEPARER_FICHIER_INFO);
	    sb.append(this.taille);
	    sb.append(ParametreC.SPEPARER_FICHIER_INFO);
	    sb.append(this.date);
	    sb.append(ParametreC.SPEPARER_FICHIER_INFO);
	    sb.append(this.numTelechargement);
	    sb.append(ParametreC.SPEPARER_FICHIER_INFO);
	    sb.append(this.droit);
	    sb.append(ParametreC.SPEPARER_FICHIER_INFO);
	    
	    if(this.comms!=null){
	    	for(int i = 0;i<comms.size();i++){
	    		
	    		sb.append(comms.get(i).getUser());
	    		sb.append(ParametreC.SPEPARER_FICHIER_COMMENTAIRE2);
	    		sb.append(comms.get(i).getDate());
	    		sb.append(ParametreC.SPEPARER_FICHIER_COMMENTAIRE2);
	    		sb.append(comms.get(i).getContenu());
	    		if(i!=comms.size()-1){
	    			sb.append(ParametreC.SPEPARER_FICHIER_COMMENTAIRE1);
	    		}
	    	}
	    }
	    
	    return sb.toString();
	}

	//getters et setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumTelechargement() {
		return numTelechargement;
	}

	public void setNumTelechargement(int numTelechargement) {
		this.numTelechargement = numTelechargement;
	}

	public int getDroit() {
		return droit;
	}

	public void setDroit(int droit) {
		this.droit = droit;
	}

	public List<Commentaire> getComms() {
		return comms;
	}

	public void setComms(List<Commentaire> comms) {
		this.comms = comms;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}


	public int getNbDown() {
		return nbDown;
	}

	public void setNbDown(int nbDown) {
		this.nbDown = nbDown;
	}

	public int getNbCom() {
		return nbCom;
	}

	public void setNbCom(int nbCom) {
		this.nbCom = nbCom;
	}

	public String getCommsStr() {
		return commsStr;
	}

	public void setCommsStr(String commsStr) {
		this.commsStr = commsStr;
	}

}
