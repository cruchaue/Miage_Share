package share.g2.miage.client.outil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 *
 */
public class ParametreC {

	
	public final static String SPEPARER_FICHIER_INFO = "<@_SFI>";
	public final static String SPEPARER_FICHIER_COMMENTAIRE1 = "<@_SC>";
	public final static String SPEPARER_FICHIER_COMMENTAIRE2 = "<@_SC_>";
	public final static String SPEPARER_INFO_UTILISATEUR = "<@_SIU>";

	public final static String FICHIER_DROIT_DEFAULT = "3";
	public final static String UTILISATEUR_DROIT_DEFAULT = "3";
	
	public final static String fichierChemin;
	public final static String fichiersConfigChemin;
	public final static String fichiers_BD_utilisateurs;
	public final static String droit_fichiers;
	public final static int portServerChat;
	
	/**
	 * 
	 */
	static{
		InputStream inputStream = ParametreC.class.getClassLoader()
				.getResourceAsStream("ipConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		fichierChemin = p.getProperty("fichierChemin");
		fichiersConfigChemin = p.getProperty("config_fichiers");
		fichiers_BD_utilisateurs = p.getProperty("BD_utilisateurs");
		droit_fichiers = p.getProperty("droit_fichiers");
		portServerChat = Integer.valueOf(p.getProperty("portServerChat"));
	}
	
}
