package share.g2.miage.connectionClient.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fichier {
	private String nom;
	private String auteur;
	private String taille;
	private String date;
	private int numTelechargement;
	private int droit;
	private List<Commentaire> comms;
	private String commsStr;

	public String getCommsStr() {
		return commsStr;
	}

	public void setCommsStr(String commsStr) {
		this.commsStr = commsStr;
	}

	public Fichier(String nomFichier, String infoFichier) {
		String[] strFI = infoFichier.split("<@_SFI>");
		this.nom = nomFichier;
		this.auteur = strFI[0];
		this.taille = strFI[1];

		this.date = strFI[2];

		this.numTelechargement = Integer.valueOf(strFI[3]);
		this.droit = Integer.valueOf(strFI[4]);
		if (strFI.length > 5) {
			String[] strCMMS = strFI[5].split("<@_SC>");
			this.comms = new ArrayList<Commentaire>();
			for (int i = 0; i < strCMMS.length; i++) {
				Commentaire cmm = new Commentaire();
				String[] strCMM = strCMMS[i].split("<@_SC_>");
				System.out.println(strCMMS[i]);
				cmm.setUser(strCMM[0]);

				cmm.setDate(strCMM[1]);

				cmm.setContenu(strCMM[2]);
			}
		}

	}

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

}
