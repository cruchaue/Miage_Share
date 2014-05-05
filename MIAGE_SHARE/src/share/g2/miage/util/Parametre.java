package share.g2.miage.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 *
 */
public class Parametre {
	/**
	 * 
	 */
	//**************parametre de JAR*************/
	public final static int LENGTH_ENVOYER = 1024;
	
	//**************prédicat de JAR*************/
	//prédicat d'opération en commun
	public final static String OK = "<@ok>";
	public final static String SEPARATEUR = "<@_>";
	
	//prédicat d'opération de fichier
	public final static String FICHIER_UPLOAD = "<@uploadFichier>";
	public final static String FICHIER_TELECHARGER = "<@telechargerFichier>";
	public final static String FICHIER_SUPPRIMER = "<@supprimerFichier>";
	public final static String FICHIER_COMMENTER = "<@commenterFichier>";
	public final static String FICHIER_LIRE_INFO = "<@lireFichierInfo>";
	public final static String FICHIER_GET_LIST = "<@getFichierList>";
	
	//prédicat d'opération de fichier
	public final static String UTILISATEUR_LOGIN = "<@login>";
	public final static String UTILISATEUR_CREER = "<@creerUtilisateur>";
	public final static String UTILISATEUR_EXISTE_PAS = "<@UserExistePas>";
	public final static String UTILISATEUR_PW_PAS_CORRECTE = "<@pwPasCorrecte>";
	
	//prédicat d'opération de chat
	public final static String CHAT = "<@chat>";
	
	//**************prédicat de logicel*************/
	
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
		InputStream inputStream = Parametre.class.getClassLoader()
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
