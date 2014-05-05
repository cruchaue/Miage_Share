package share.g2.miage.clientJar.fonction.statistiques.outil;
import java.util.Hashtable;
import java.util.Iterator;

import  org.jfree.chart.ChartFactory;
import  org.jfree.chart.ChartFrame;	import  org.jfree.chart.JFreeChart;
import  org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.client.dao.User;

/**
 * Contient les m�thodes permettant de comparer les donn�es de plusieurs utilisateurs 
 * 
 * @author loktora
 *
 */
public class StatGenerales {

		

		
		//private int tab[] = new int[10];
		 
		/**
		 * Genere un DataSet pour les activit�s sur les fichiers
		 * @return
		 */
		public static DefaultPieDataset createStatFic(Hashtable<Integer, Fichier> ht,String critere){
			DefaultPieDataset data=new DefaultPieDataset();

			Iterator<Integer> it;
		    it=ht.keySet().iterator(); // on cree un iterator sur les objets du hashmap
		     
		    while(it.hasNext()){
		    	
		       Object key=it.next();
		       Object value=ht.get(key);
		       // traitement :
		       String nom=((Fichier) value).getNom();
		       int crit=0;
		       // on selectionne en fonction du critere en parametre
		       if(critere=="commentaire"){
				 crit=((Fichier) value).getNbCom();
		       }else if(critere=="download"){
				 crit=((Fichier) value).getNbDown();
		       }
				
				
				data.setValue(nom,crit);
		       
		    }

			
			return data;
		}
		
		/**
		 * Genere un DataSet pour les activit� des utilisateurs
		 * @return
		 */
		public static DefaultPieDataset createStatUtil(Hashtable<Integer, User> ht,String critere){
			DefaultPieDataset data=new DefaultPieDataset();

			Iterator<Integer> it;
		    it=ht.keySet().iterator(); // on cree un iterator sur les objets du hashmap
		     
		    while(it.hasNext()){
		    	
		       Object key=it.next();
		       Object value=ht.get(key);
		       // traitement :
		       String nom=((User) value).getUserName();
		       int crit=0;
		       // on selectionne en fonction du critere en parametre
		       if(critere=="connexion"){
				 crit=((User) value).getNbConnex();
		       }else if(critere=="upload"){
				 crit=((User) value).getNbUp();
		       }else if(critere=="download"){
				 crit=((User) value).getNbDown();
		       }else if(critere=="suppression"){
				 crit=((User) value).getNbSuppr();
		       }else if(critere=="message"){
				 crit=((User) value).getNbMessages();
		       }else if(critere=="commentaire"){
				 crit=((User) value).getNbComm();
		       }else if(critere=="notification"){
				 crit=((User) value).getNbNotif();
		       }
				
				
				data.setValue(nom,crit);
		       
		    }

			
			return data;
		}
		
	
		/**
		 * Creer un objet JFreeChart
		 * @param titre: titre du diagramme
		 * @param data: donn�es (g�n�r�es pr�cedemment)
		 * @return
		 */
		public static JFreeChart createPie(String titre,DefaultPieDataset data){
			JFreeChart chart=ChartFactory.createPieChart( titre, data, true/*legend?*/,true/*tooltips?*/, false/*URLs?*/);
			return chart;
		}

		/**
		 * Affiche le JFreechart
		 * @param name: nom de la fenetre
		 * @param chart: JFreeChart � afficher
		 */
		public static void visualiseChart(String name,JFreeChart chart){
		    ChartFrame frame=new ChartFrame(name,chart);
		    frame.pack();
		    frame.setVisible(true);
		}
		
		/**
		 * Genere le dataset pour un utilisateur, cree le Jfreechart et l'affiche
		 * @param ht=liste des utilisateurs
		 * @param critere= critere de creation du diagramme
		 * @param titreDiag=titre du diagramme
		 * @param titreFen=titre de la fenetre
		 */
		public static void statUtil(Hashtable<Integer, User> ht, String critere, String titreDiag, String titreFen){
			
			 DefaultPieDataset data = createStatUtil(ht, critere);
			  JFreeChart chart=createPie(titreDiag,data);
			  visualiseChart(titreFen,chart);
		}
		
		/**
		 * Genere le dataset pour un fichier, cree le Jfreechart et l'affiche
		 * @param ht=liste des fichiers
		 * @param critere= critere de creation du diagramme
		 * @param titreDiag=titre du diagramme
		 * @param titreFen=titre de la fenetre
		 */
		public static void statFic(Hashtable<Integer, Fichier> ht, String critere, String titreDiag, String titreFen){
			
			 DefaultPieDataset data = createStatFic(ht, critere);
			  JFreeChart chart=createPie(titreDiag,data);
			  visualiseChart(titreFen,chart);
		}
		
		
		
		
	
		  public static void main(String[] args) {
			  User olmail=new User();
			  olmail.setNbUp(3);
			  olmail.setNbMessages(6);
			  olmail.setUserName("olmail");
			  User tamere=new User();
			 tamere.setNbUp(20);
			 tamere.setNbMessages(2);
			 tamere.setUserName("tamere");
			  User tasoeur=new User();
			  tasoeur.setNbUp(15);
			  tasoeur.setNbMessages(40);
			  tasoeur.setUserName("tasoeur");
			 Hashtable<Integer, User> ht = new Hashtable<Integer, User>();
			  ht.put(10, olmail);
			    ht.put(20, tamere);
			    ht.put(30, tasoeur);
			    
		
			   
			    
			    
			   /*statUtil(ht, "upload", "titre diag", "titre fenetre");
			 statUtil(ht, "message", "titre diag", "titre fenetre");
			  */

		 
		  }
}
