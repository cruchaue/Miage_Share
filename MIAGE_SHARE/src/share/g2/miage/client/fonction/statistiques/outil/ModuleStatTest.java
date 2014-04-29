package share.g2.miage.client.fonction.statistiques.outil;

import  org.jfree.chart.ChartFactory;
import  org.jfree.chart.ChartFrame;	import  org.jfree.chart.JFreeChart;
import  org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.User;
	
public class ModuleStatTest {
	
	//private int tab[] = new int[10];
	 
	/**
	 * Genere un DataSet pour les uploads/downloads d'un utilisateur
	 * @return
	 */
	public static DefaultPieDataset createUpDownUtil(User util){
	    DefaultPieDataset data=new DefaultPieDataset();
	    data.setValue("nombre de download", util.getNbDown());
	    data.setValue("nombre d'upload", util.getNbUp());
		return data;
	}
	
	/**
	 * Genere un DataSet pour les uploads/downloads
	 * @return
	 */
	public static DefaultPieDataset createUpDown(int [] tab){
		//int tab[]={200,20,3,2,1,6,6,0,40,8};
	    DefaultPieDataset data=new DefaultPieDataset();
	    data.setValue("nombre de download", tab[1]);
	    data.setValue("nombre d'upload", tab[2]);
	    
	    
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
		  /*
		  int tab[]={200,20,3,2,1,6,6,0,40,8};
		  DefaultPieDataset data = createUpDown(tab);
		  JFreeChart chart=createPie("Ratio Uploads/Downloads",data);
		  visualiseChart("trololo",chart);
	  	  */
		  User olmail=new User();
		  olmail.setNbDown(40);
		  olmail.setNbUp(3);
		  DefaultPieDataset data = createUpDownUtil(olmail);
		  JFreeChart chart=createPie("Ratio Uploads/Downloads d'olmail",data);
		  visualiseChart("trololo",chart);
	  }
	 
	
}
