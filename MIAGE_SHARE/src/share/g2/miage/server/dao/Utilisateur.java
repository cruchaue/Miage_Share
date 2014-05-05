package share.g2.miage.server.dao;

/**
 * <b>Represention d'un utilisateur enregistré sur le serveur</b>
 * 
 * <p>Contient toute les informations necessaire a l'identification d'un utilisateur
 * ainsi que les differentes methodes d'acces au differents element de l'objet:
 * 	<ul>
 * 		<li>Un login unique</li>
 * 		<li>Son mot de passe</li>
 * 		<li>ses droit d'acces aux fichier du serveur</li>
 * 		<li>Son adresse mail</li>
 * 	</ul>
 * </p>
 *
 */
public class Utilisateur {
	private String loginName;
	private String password;
	private String limite;
	private String mail;
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLimite() {
		return limite;
	}
	public void setLimite(String limite) {
		this.limite = limite;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
		
}
