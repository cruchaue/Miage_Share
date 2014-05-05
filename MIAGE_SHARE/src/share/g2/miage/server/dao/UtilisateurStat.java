package share.g2.miage.server.dao;

/**
 * <b>Representation de toutes les inforamtions statistique d'un utilisateur</b>
 * 
 * <p>Contient toutes les informations statistiques relatives a un utilisateur:
 * 	<ul>
 * 		<li>le login de l'utilisateur</li>
 * 		<li>Le nombre de fichier uploader</li>
 * 		<li>Le nombre de fichier telecharge</li>
 * 		<li>Le nombre de fois que l'utilisateur c'est connecter au serveur<li>
 * 	</ul>
 * </p>
 * <p>Elles pourront servir dans l'elaboration d'elements graphiques fournit par le framework</p>
 * 
 * <p>Il suffit de creer une classe heritant de celle ci afin de rajouter des informations jugees 
 * necessaires pour l'application cree.</p>
 */
public class UtilisateurStat {
	private String loginName;
	private int numUpload;
	private int numDowdload;
	private int numConnection;
	
	public int getNumUpload() {
		return numUpload;
	}

	public void setNumUpload(int numUpload) {
		this.numUpload = numUpload;
	}

	public int getNumDowdload() {
		return numDowdload;
	}

	public void setNumDowdload(int numDowdload) {
		this.numDowdload = numDowdload;
	}

	public int getNumConnection() {
		return numConnection;
	}

	public void setNumConnection(int numConnection) {
		this.numConnection = numConnection;
	}

	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
		
}
