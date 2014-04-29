package share.g2.miage.client.fonction.statistiques.outil;
import java.util.Hashtable;
import java.util.Iterator;

import  org.jfree.chart.ChartFactory;
import  org.jfree.chart.ChartFrame;	import  org.jfree.chart.JFreeChart;
import  org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.User;
public class StatUtils {

		

		
		//private int tab[] = new int[10];
		 
		/**
		 * Genere un DataSet pour les uploads des utilisateurs
		 * @return
		 */
		public static DefaultPieDataset createUpDownUtil(Hashtable<Integer, User> ht){
			DefaultPieDataset data=new DefaultPieDataset();
			System.out.println("data cr��");
			Iterator<Integer> it;
		    it=ht.keySet().iterator(); // on cree un iterator sur les cl�s du hashmap
		     
		    while(it.hasNext()){
		    	System.out.println("debut du while");
		       Object key=it.next();
		       Object value=ht.get(key);
		       // traitement :
		       String nom=((User) value).getUserName();
				int up=((User) value).getNbUp();
				System.out.println("nom : "+nom);
				System.out.println("nombre d'uploads : "+up);
				data.setValue(nom,up);
		       
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
		
		
		  public static void main(String[] args) {
			  User olmail=new User();
			  olmail.setNbUp(3);
			  olmail.setUserName("olmail");
			  User tamere=new User();
			 tamere.setNbUp(20);
			 tamere.setUserName("tamere");
			  User tasoeur=new User();
			  tasoeur.setNbUp(15);
			  tasoeur.setUserName("tasoeur");
			 Hashtable<Integer, User> ht = new Hashtable<Integer, User>();
			  ht.put(10, olmail);
			    ht.put(20, tamere);
			    ht.put(30, tasoeur);

				    
		 
			  DefaultPieDataset data = createUpDownUtil(ht);
			  JFreeChart chart=createPie("Part d'uploads des utilisateurs",data);
			  visualiseChart("trololo",chart);
			  

		 
		  }
}
