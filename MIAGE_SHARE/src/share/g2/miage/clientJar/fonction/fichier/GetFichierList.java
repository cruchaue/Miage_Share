package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.outil.ParametreCJ;

/**
 * Contient la méthode permettant de recuperer la liste des fichiers stockés sur le serveur.
 * Le seul parametre a envoyer est le nom d'utilisateur. 
 *
 */
public class GetFichierList<T> extends FonctionClient<T> {

	/**
	 * 
	 * @param userName
	 */
	public GetFichierList(String userName) {
		super();
		parametre1 = userName;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(ParametreCJ.FICHIER_GET_LIST);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			resultat1 = dis.readUTF();
			client.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
