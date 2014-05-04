package share.g2.miage.client.dao;

/**
 * un User est la repr�sentation de l'utilisateur final de l'application.
 * 
 *
 */
public class User {
	/**
	 * Le nom de l'utilisateur (pseudo)
	 */
	private String userName;
	
	/**
	 * L'email de l'utilisateur
	 */
	private String email;
	
	/**
	 * Les droits d'acc�s que l'utilisateur aura sur les fichiers
	 */
	private int droit;
	
	/**
	 * 
	 */
	private int nbConnex, nbUp, nbDown, nbSuppr, nbMessages, nbComm, nbNotif;
	
	/**
	 * 
	 * @return 
	 */
	public int getNbConnex() {
		return nbConnex;
	}
	
	/**
	 * 
	 * @param nbConnex
	 */
	public void setNbConnex(int nbConnex) {
		this.nbConnex = nbConnex;
	}
	
	/**
	 * 
	 * @return Le nombre de Fichier que l'utilisateur a envoy� sur le serveurs.
	 */
	public int getNbUp() {
		return nbUp;
	}
	
	/**
	 * Met � jour le nombre upload de l'utilisateur.
	 * 
	 * @param nbUp
	 * 			Le nouveau nombre d'upload.
	 */
	public void setNbUp(int nbUp) {
		this.nbUp = nbUp;
	}
	
	/**
	 * Retourne le nombre de fichier t�l�charg� par l'utilisateur depuis le serveur.
	 * @return Le nombre de fichier t�l�charg� par l'utilisateur.
	 */
	public int getNbDown() {
		return nbDown;
	}
	
	/**
	 * Met � jour le nombre de download de l'utilisateur.
	 * @param nbDown
	 * 			Nouveau nom de download. nbDown > 0.
	 */
	public void setNbDown(int nbDown) {
		this.nbDown = nbDown;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNbSuppr() {
		return nbSuppr;
	}
	
	/**
	 * 
	 * @param nbSuppr
	 */
	public void setNbSuppr(int nbSuppr) {
		this.nbSuppr = nbSuppr;
	}
	
	/**
	 * 
	 * @return Le nombre de message envoy� par l'utilisateur sur un chat.
	 */
	public int getNbMessages() {
		return nbMessages;
	}
	
	/**
	 * Met � jour le nombre de message laiss� par l'utilisateur sur le chat.
	 * @param nbMessages
	 * 				Le nouveau nombre de message laiss� par l'utilisateur.
	 */
	public void setNbMessages(int nbMessages) {
		this.nbMessages = nbMessages;
	}
	
	/**
	 * Retoune le nombre de commentaire que l'utilisateur � laiss� sur l'ensemble des fichiers du serveur.
	 * @return Le nombre total de commentaire laiss� par l'utilisateur.
	 */
	public int getNbComm() {
		return nbComm;
	}
	
	/**
	 * Met � jour le nombre de commentaire laiss� par l'utilisateur.
	 * @param nbComm
	 * 			Le nouveau nombre de commentaire.
	 */
	public void setNbComm(int nbComm) {
		this.nbComm = nbComm;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNbNotif() {
		return nbNotif;
	}
	
	/**
	 * 
	 * @param nbNotif
	 */
	public void setNbNotif(int nbNotif) {
		this.nbNotif = nbNotif;
	}
	
	/**
	 * Retourne le nom/pseudo que l'utilisateur � choisi lors de son inscription. 
	 * @return Le nom (pseudo) de l'utilisateur.
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Modifie le nom/pseudo de l'utilisateur (si la fonction de modification de nom a �t� implent�e).
	 * @param userName
	 * 				Le nouveau nom de l'utilisateur.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getDroit() {
		return droit;
	}
	
	/**
	 * 
	 * @param droit
	 */
	public void setDroit(int droit) {
		this.droit = droit;
	}
	
}
