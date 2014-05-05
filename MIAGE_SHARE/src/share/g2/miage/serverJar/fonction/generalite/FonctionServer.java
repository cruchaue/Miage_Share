package share.g2.miage.serverJar.fonction.generalite;

import share.g2.miage.serverJar.dao.ClientS;

/**
 * <p>Superclasse (qui implemente l'interface Communication) dont 
 * toutes les actions demandees par un client et executable par le serveur decouleront.</p>
 * 
 * <p>Toutes fonctions nouvellement implementees devra heritee de cette classe afin d'assurer le bon fonctionnement de cette derniere 
 * lors d'envoi ou la recuperation d'informations par le serveur. </p>
 *
 * <p>C'est cette classe qui sera chargé d'executer toutes les differentes fonctions permettant le 
 * bon deroulement de l'action</p>
 * 
 * <p>Le deroulement s'effectue en plusieurs etapes: 
 * 	<ul>
 * 		<li>une action avant la connection</li>
 * 		<li>une action une fois la connection effectuee</li>
 * 		<li>une derniere action apres la connection</li>
 * 	</ul>
 * </p>
 */
public  abstract class FonctionServer implements
Communication {

	/**
	 * 
	 */
	protected ClientS clients;

	/**
	 * 
	 */
	protected String parametre1 = "";

	/**
	 * 
	 */
	protected String parametre2 = "";


	/**
	 * 
	 */
	protected int resultat1;

	/**
	 * 
	 */
	protected String resultat2 = "";

	/**
	 * Lance la séquence d'execution de l'action demandee.
	 * @return TODO
	 */
	public int demarrer(ClientS clients){

		int rs;
		this.clients = clients;

		rs = avantConnection();

		if(rs==1){
			rs = commExecuter1();
		}else{
			return rs;
		}

		if(rs==1){
			rs = pendantConnection();
		}else{
			return rs;
		}

		if(rs==1){
			rs = commExecuter2();
			clients.closeConnection();
		}else{
			clients.closeConnection();
			return rs;
		}

		if(rs==1){
			rs = apresConnection();
		}else{
			return rs;
		}

		return rs;
	}


	@Override
	public int commExecuter2(){return 1;}

	/**
	 * 
	 * @return 
	 */
	protected int avantConnection(){return 1;}


	/**
	 * 
	 * @return
	 */
	protected int pendantConnection(){return 1;}

	/**
	 * Va permettre d'executer certaines actions demandés par l'utilisateur au serveur une fois la connection effectuee.
	 */
	protected int apresConnection(){return 1;}
}
