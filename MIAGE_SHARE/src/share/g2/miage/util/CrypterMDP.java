package share.g2.miage.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe permettant de crypter les mots de passes grâce à l'algorithme MD5
 * 
 * Il suffit de passer en paramètre le mot de passe à crypter dans la méthode
 * crypteMDP() afin que celle-ci le renvoie crypté.
 */
public class CrypterMDP {
	
	/**
	 * Renvoie le mot de passe crypter grâce à l'algorithme MD5.
	 * @param mdp
	 * 			Le mot de passe à crypter.
	 * @return Le mot de passe crypté.
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
