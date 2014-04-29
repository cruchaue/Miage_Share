package share.g2.miage.client.fonction.generalite;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.ClientConnection;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public abstract class FonctionClient implements
		Fonction {
	protected ClientConnection client = new ClientConnection();
	protected String parametre1 = "";
	protected String parametre2 = "";
	protected String resultat1 = ""; 
	protected String resultat2 = ""; 
	public FonctionClient(){
		client.demarrer();
	}
	
	public void demarrer(){
		excuter();
		client.closeConnection();
	}
	
	public String getResultat1() {
		return resultat1;
	}

	public String getResultat2() {
		return resultat2;
	}

}
