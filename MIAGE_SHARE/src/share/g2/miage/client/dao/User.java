package share.g2.miage.client.dao;

public class User {
	private String userName;
	private String email;
	private int droit;
	private int nbConnex, nbUp, nbDown, nbSuppr, nbMessages, nbComm, nbNotif;
	public int getNbConnex() {
		return nbConnex;
	}
	public void setNbConnex(int nbConnex) {
		this.nbConnex = nbConnex;
	}
	public int getNbUp() {
		return nbUp;
	}
	public void setNbUp(int nbUp) {
		this.nbUp = nbUp;
	}
	public int getNbDown() {
		return nbDown;
	}
	public void setNbDown(int nbDown) {
		this.nbDown = nbDown;
	}
	public int getNbSuppr() {
		return nbSuppr;
	}
	public void setNbSuppr(int nbSuppr) {
		this.nbSuppr = nbSuppr;
	}
	public int getNbMessages() {
		return nbMessages;
	}
	public void setNbMessages(int nbMessages) {
		this.nbMessages = nbMessages;
	}
	public int getNbComm() {
		return nbComm;
	}
	public void setNbComm(int nbComm) {
		this.nbComm = nbComm;
	}
	public int getNbNotif() {
		return nbNotif;
	}
	public void setNbNotif(int nbNotif) {
		this.nbNotif = nbNotif;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDroit() {
		return droit;
	}
	public void setDroit(int droit) {
		this.droit = droit;
	}
	
}
