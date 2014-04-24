package share.g2.miage.client.fonction;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.fonction.interfaces.Fonction;
import share.g2.miage.client.interfaces.ClientInterface;
import share.g2.miage.server.ServerFichier;
import share.g2.miage.util.Parametre;

public abstract class FonctionClient implements
		Fonction {
	protected Client client;

	public Client getClient() {
		return client;
	}

	public abstract int excuter();

}
