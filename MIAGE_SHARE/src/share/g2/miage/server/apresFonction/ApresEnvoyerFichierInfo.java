package share.g2.miage.server.apresFonction;

import share.g2.miage.server.dao.ClientS;
import share.g2.miage.server.fonction.CommenterFichier;
import share.g2.miage.server.fonction.EnvoyerFichier;
import share.g2.miage.server.fonction.EnvoyerFichierInfo;



public class ApresEnvoyerFichierInfo extends EnvoyerFichierInfo{

	public ApresEnvoyerFichierInfo(ClientS clients) {
		super(clients);
	}

	@Override
	protected void apresConnection() {
		// TODO Auto-generated method stub
		
	}

}
