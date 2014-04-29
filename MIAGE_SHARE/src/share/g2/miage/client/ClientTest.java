package share.g2.miage.client;

import java.io.*;
import java.net.*;

import javax.swing.*;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.fichier.UploadFichier;
import share.g2.miage.client.fonction.generalite.Fonction;


public class ClientTest {


	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.demarrer();
		Fonction fcf = new UploadFichier();
		client.setParametre1("test.jpg");
		client.setParametre2("test.jpg");
		fcf.excuter(client);
		client.closeConnection();
	
	}

}
