package share.g2.miage.server.apresFonction;

import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.fonction.CommenterFichier;
import share.g2.miage.server.fonction.EnvoyerFichier;



public class ApresEnvoyerFichier extends EnvoyerFichier{

	public ApresEnvoyerFichier(ClientS clients) {
		super(clients);
	}

	@Override
	protected void apresConnection() {
		// TODO Auto-generated method stub
		
	}

}
