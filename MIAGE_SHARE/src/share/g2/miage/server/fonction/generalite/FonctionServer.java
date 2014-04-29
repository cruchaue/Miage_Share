package share.g2.miage.server.fonction.generalite;

import share.g2.miage.server.dao.ClientS;

public  abstract class FonctionServer implements
Fonction {
	protected ClientS clients;
	protected String parametre1 = "";
	protected String parametre2 = "";
	
	protected void demarrer(){
		excuter();
		clients.closeConnection();
		apresConnection();
	}
	protected abstract void apresConnection();
}
