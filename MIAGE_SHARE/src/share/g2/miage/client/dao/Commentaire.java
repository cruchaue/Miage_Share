package share.g2.miage.client.dao;

import java.util.Date;

/**
 * Commentaire représente un commentaire qu'un client peut laisser sur un Fichier.
 * Il est représenté par le nom du client, la date de dépose du commentaire et évidemment son contenu. 
 *
 */
public class Commentaire {
	/**
	 * Le nom de l'utilisateur qui a déposé le commentaire.
	 */
	private String user;
	
	/**
	 * La date de dépose du commentaire.
	 */
	private String date;
	
	/**
	 * Le commentaire lui même.
	 */
	private String contenu;
	
	/**
	 * 
	 * @return Le nom de l'utilisateur qui a déposé le commentaire.
	 */
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return La date de dépose du commentaire.
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Retourne uniquement le commentaire laissé par l'utilisateur.
	 * @return Le commentaire
	 */
	public String getContenu() {
		return contenu;
	}
	
	/**
	 * Edition du commentaire.
	 * @param contenu
	 * 				Le nouveau contenu du commentaire.
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
