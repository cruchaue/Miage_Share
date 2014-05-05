package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.Outil.ParametreCJ;

/**
 * Permet a l'utilisateur de lire les informations lié au fichier.
 * 
 * Il suffit de faire une demande au serveur avec le nom du fichier a consulter en parametre.
 *
 */
public class LireFichierInfo<T> extends FonctionClient<T> {
	
	/**
	 * 
	 * @param filename
	 */
	public LireFichierInfo(String filename){
		super();
		parametre1 = filename;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(ParametreCJ.FICHIER_LIRE_INFO);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();

			byte[] sendBytes = new byte[ParametreCJ.LENGTH_ENVOYER];
			int length = 0;

			StringBuffer sb = new StringBuffer();
			while ((length = dis.read(sendBytes, 0, sendBytes.length)) > 0) {
				String strRead = new String(sendBytes);
				strRead = String.copyValueOf(strRead.toCharArray(), 0, length);
				sb.append(strRead);

			}

			resultat1 = sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
