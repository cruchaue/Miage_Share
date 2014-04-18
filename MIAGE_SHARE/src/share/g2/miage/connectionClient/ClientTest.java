package share.g2.miage.connectionClient;

import java.io.*;
import java.net.*;

import javax.swing.*;

import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.connectionClient.fonction.UploadFichier;

public class ClientTest {


	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.demarrer();
		FonctionClientFichier fcf = new UploadFichier();
		client.setParametre1("test.jpg");
		client.setParametre2("test.jpg");
		fcf.excuter(client);
		client.closeConnection();
	
	}

}
