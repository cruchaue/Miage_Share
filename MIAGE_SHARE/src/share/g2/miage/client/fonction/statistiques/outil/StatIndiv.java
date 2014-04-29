package share.g2.miage.client.fonction.statistiques.outil;

import  org.jfree.chart.ChartFactory;
import  org.jfree.chart.ChartFrame;	import  org.jfree.chart.JFreeChart;
import  org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.client.dao.User;
	

/**
 * Cette classe contient les différentes méthodes permettant d'afficher des diagramme statistiques d'un objet unique
 * 
 * @author loktora
 *
 */
public class StatIndiv {
	
	/**
	 * Ajoute à un DataSet d'un fichier le critere selectionné
	 * 
	 * @param fic=fichier sur lequel on veut effectuer les calculs
	 * @param critere=l'element qui nous interesse (download,commentaire...)
	 * @param data=le DataSet auquel on souhaite ajouter le critere
	 * @return
	 */
	public static void createStatFic(Fichier fic, String critere, DefaultPieDataset data){
	    if(critere=="download"){
	    	data.setValue("nombre de download", fic.getNbDown());
	    }else if(critere=="commentaire"){
	    	data.setValue("nombre de commentaires", fic.getNbCom());
	    }
	}
	 
	/**
	 * Ajoute à un DataSet d'utilisateur le critere selectionné
	 * 
	 * @param util=utilisateur sur lequel on veut effectuer les calculs
	 * @param critere=l'element qui nous interesse (upload,connexion...)
	 * @param data=le DataSet auquel on souhaite ajouter le critere
	 * @return
	 */
	public static void createStatUtil(User util, String critere, DefaultPieDataset data){
	    if(critere=="connexion"){
	    	data.setValue("nombre de connexions", util.getNbConnex());
	    }else if(critere=="upload"){
	    	data.setValue("nombre d'uploads", util.getNbUp());
	    }else if(critere=="download"){
	    	data.setValue("nombre de downloads", util.getNbDown());
	    }else if(critere=="suppression"){
	    	data.setValue("nombre de suppressions", util.getNbSuppr());
	    }else if(critere=="message"){
	    	data.setValue("nombre de messages", util.getNbMessages());
	    }else if(critere=="connexion"){
	    	data.setValue("nombre de commentaires", util.getNbComm());
	    }else  if(critere=="notification"){
	    	data.setValue("nombre de notifications", util.getNbNotif());
	    }

	}
	
	
	/**
	 * Creer un objet JFreeChart
	 * @param titre: titre du diagramme
	 * @param data: donnéess (à générer plus tôt)
	 * @return
	 */
	public static JFreeChart createPie(String titre,DefaultPieDataset data){
		JFreeChart chart=ChartFactory.createPieChart( titre, data, true/*legend?*/,true/*tooltips?*/, false/*URLs?*/);
		return chart;
	}

	/**
	 * Affiche le JFreechart
	 * @param name: nom de la fenetre
	 * @param chart: JFreeChart ÔøΩ afficher
	 */
	public static void visualiseChart(String name,JFreeChart chart){
	    ChartFrame frame=new ChartFrame(name,chart);
	    frame.pack();
	    frame.setVisible(true);
	}
	
	/**
	 * genere et affiche le Jfreechart a partir des données
	 * @param us
	 * @param titreDiag
	 * @param titreFen
	 */
	public static void statUt(DefaultPieDataset data, String titreDiag, String titreFen){
		  JFreeChart chart=createPie(titreDiag,data);
		  visualiseChart(titreFen,chart);
	}
	
	
	///////TEST A SUPPRIME DANS LA VERSION FINALE///////
	
	public static void createStatFicTest(FichierTest fic, String critere, DefaultPieDataset data){
	    if(critere=="download"){
	    	data.setValue("nombre de download", fic.getNbDown());
	    }else if(critere=="commentaire"){
	    	data.setValue("nombre de commentaires", fic.getNbCom());
	    }
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
		  olmail.setNbUp(6);
		  olmail.setNbConnex(60);
		  
		  
		  DefaultPieDataset data= new DefaultPieDataset();
		  createStatUtil(olmail, "connexion",data);
		  createStatUtil(olmail, "upload",data);
		  createStatUtil(olmail, "download",data);
		  statUt(data,"titrediag","titrfen");
		  
		  
		  FichierTest hello=new FichierTest();
		  hello.setNbCom(12);
		  hello.setNbDown(30);
		  
		  DefaultPieDataset data2= new DefaultPieDataset();
		  createStatFicTest(hello,"commentaire",data2);
		  createStatFicTest(hello,"download",data2);
		  
		  statUt(data2,"titreDiag","titreFen");

	  }
	 
	
}
