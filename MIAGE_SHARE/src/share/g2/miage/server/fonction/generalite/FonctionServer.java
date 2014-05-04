package share.g2.miage.server.fonction.generalite;

import share.g2.miage.server.dao.ClientS;

/**
 * 
 *
 */
public  abstract class FonctionServer implements
Communication {
	
	/**
	 * 
	 */
	protected ClientS clients;
	
	/**
	 * 
	 */
	protected String parametre1 = "";
	
	/**
	 * 
	 */
	protected String parametre2 = "";
	
	/**
	 * 
	 */
	protected void demarrer(){
		commExecuter();
		clients.closeConnection();
		apresConnection();
	}
	
	/**
	 * 
	 */
	protected abstract void apresConnection();
}
