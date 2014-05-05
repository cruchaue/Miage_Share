package share.g2.miage.client.outil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe permettant de crypter les mots de passes gr�ce � l'algorithme MD5
 * 
 * Il suffit de passer en param�tre le mot de passe � crypter dans la m�thode
 * crypteMDP() afin que celle-ci le renvoie crypt�.
 */
public class CrypterMDP {
	
	/**
	 * Renvoie le mot de passe crypter gr�ce � l'algorithme MD5.
	 * @param mdp
	 * 			Le mot de passe � crypter.
	 * @return Le mot de passe crypt�.
	 */
	public static String crypteMDP(String mdp){
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(mdp.getBytes());
			byte[] digest = md.digest();
			StringBuffer sbMDcrypte = new StringBuffer();
			for (byte b : digest) {
				sbMDcrypte.append(String.format("%02x", b & 0xff));
			}
			return sbMDcrypte.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
	}

}
