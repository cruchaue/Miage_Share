package share.g2.miage.clientJar.outil;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Outil {
	
	/**
	 * 
	 * @param lists
	 * @return
	 */
	public static String ListToString(List<String> lists){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< lists.size();i++){
			sb.append(lists.get(i));
			if(i!=lists.size()-1){
				sb.append(ParametreCJ.SEPARATEUR);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param strT
	 * @return
	 */
	public static String strTableauToString(String[] strT){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< strT.length;i++){
			sb.append(strT[i]);
			if(i!=strT.length-1){
				sb.append(ParametreCJ.SEPARATEUR);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> StringToList(String str){
		String[] strT =  str.split(ParametreCJ.SEPARATEUR);
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i< strT.length;i++){
			list.add(strT[i]);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String[] StringToStringTableau(String str){
		return str.split(ParametreCJ.SEPARATEUR);
	}
}
