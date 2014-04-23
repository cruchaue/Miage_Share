package share.g2.miage.client;

import java.io.*;
import java.net.*;

import javax.swing.*;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.UploadFichier;
import share.g2.miage.client.fonction.interfaces.FonctionClient;


public class ClientTest {


	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.demarrer();
		FonctionClient fcf = new UploadFichier();
		client.setParametre1("test.jpg");
		client.setParametre2("test.jpg");
		fcf.excuter(client);
		client.closeConnection();
	
	}

}
