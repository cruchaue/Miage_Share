package share.g2.miage.util;

public class FonctionPublique {
	public static String byteTableauToString(byte[] byteTableau, int length){
		String strRead1 = new String(byteTableau);
		 strRead1 = String.copyValueOf(strRead1.toCharArray(), 0, length);
		 return strRead1;
	}
	 
}
