package share.g2.miage.clientJar.fonction.fichier;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.outil.ParametreCJ;

/**
 * <b>Represente l'action de supprimer un utilisateur du serveur</b>
 * 
 * <p>A la demande de l'utilisateur l'action de supprimer son compte va etre demander.
 * Cette classe va lancer l'execution qui va elle même demander au serveur de supprimer 
 * cet utilisateur.</p>
 *
 */
public class ModifierDroitFichier<T> extends FonctionClient<T> {
	
	/**
	 * demarre l'action "suppression d'un utilisateur"
	 */
	public ModifierDroitFichier(String fichiernom, String droit) {
		super();
		 parametre1 = fichiernom;
		 parametre2 = droit;
		demarrer();
	}

	@Override
	public int commExecuter1() {
		try {

			// FileInputStream fis = new FileInputStream(file);

			DataOutputStream dos = client.getDos();
			DataInputStream dis = client.getDis();

			dos.writeUTF(ParametreCJ.FICHIER_MODIFIER_DROIT);
			dos.flush();

			dos.writeUTF(parametre1);
			dos.flush();
			
			dos.writeUTF(parametre2);
			dos.flush();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
