package share.g2.miage.server.dao;

import java.util.Date;

/**
 * Commentaire repr�sente un commentaire qu'un client peut laisser sur un Fichier.
 * Il est repr�sent� par le nom du client, la date de d�pose du commentaire et �videmment son contenu. 
 *
 */
public class Commentaire {
	/**
	 * Le nom de l'utilisateur qui a d�pos� le commentaire.
	 */
	private String user;

	/**
	 * La date de d�pose du commentaire.
	 */
	private String date;

	/**
	 * Le commentaire lui m�me.
	 */
	private String contenu;

	/**
	 * 
	 * @return Le nom de l'utilisateur qui a d�pos� le commentaire.
	 */
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 
	 * @return La date de d�pose du commentaire.
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
	 * Retourne uniquement le commentaire laiss� par l'utilisateur.
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
