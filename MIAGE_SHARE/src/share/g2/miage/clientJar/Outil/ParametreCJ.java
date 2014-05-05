package share.g2.miage.clientJar.Outil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 *
 */
public class ParametreCJ {

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
	
	//prédicat d'opération de statistique
		public final static String STATISTIQUE_NUM_UPDOWNLOAD = "<@numUpDownLoad>";
	
	//prédicat d'opération de chat
	public final static String CHAT = "<@chat>";
	
	
}
