package share.g2.miage.connectionClient.dao;

import java.util.Date;
import java.util.List;

public class Fichier {
	private String nom;
	private String auteur;
	private Date date;
	private int numTelechargement;
	private int droit;
	private List<Commentaire> comms;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	
}
