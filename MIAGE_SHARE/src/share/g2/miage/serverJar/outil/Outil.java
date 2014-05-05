package share.g2.miage.serverJar.outil;

import java.util.ArrayList;
import java.util.List;

import share.g2.miage.util.Parametre;

/**
 * Classe regroupant plusieurs methodes utiles effectuant des operation de 
 * transformations d'objet en String et inversement.
 *
 */
public class Outil {
	
	/**
	 * Transforme une liste de String en un seul String.
	 * @param lists
	 * 			Le liste a reunir en un String.
	 * @return Un String
	 */
	public static String ListToString(List<String> lists){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< lists.size();i++){
			sb.append(lists.get(i));
			if(i!=lists.size()-1){
				sb.append(Parametre.SEPARATEUR);
			}
		}
		return sb.toString();
	}
	
	/**
	 * Reunis touts les elements d'un tableau de String en un seul String.
	 * 
	 * @param strT
	 * 			Le tableau de String a transformer.
	 * @return Le contenu d'un tableau de String en un String.
	 */
	public static String strTableauToString(String[] strT){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< strT.length;i++){
			sb.append(strT[i]);
			if(i!=strT.length-1){
				sb.append(Parametre.SEPARATEUR);
			}
		}
		return sb.toString();
	}
	
	/**
	 * Transforme un String en une liste de String.
	 * @param str
	 * 			Le String a separer.
	 * @return Une liste de String
	 */
	public static List<String> StringToList(String str){
		String[] strT =  str.split(Parametre.SEPARATEUR);
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i< strT.length;i++){
			list.add(strT[i]);
		}
		
		return list;
	}
	
	/**
	 * Tranqforme un String en un tableau de String.
	 * @param str
	 * 			Le String a separer.
	 * @return Un tableau de String.
	 */
	public static String[] StringToStringTableau(String str){
		return str.split(Parametre.SEPARATEUR);
	}
}
