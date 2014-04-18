package share.g2.miage.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrypterMDP {
	
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
