package share.g2.miage.server.dao;

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
