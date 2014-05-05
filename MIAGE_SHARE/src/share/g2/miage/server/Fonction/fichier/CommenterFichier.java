package share.g2.miage.server.Fonction.fichier;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import share.g2.miage.client.dao.Commentaire;
import share.g2.miage.serverJar.dao.ClientS;
import share.g2.miage.serverJar.fonction.fichier.CommenterFichierJar;
import share.g2.miage.util.Parametre;


/**
 * Ajoute un commentaire envoyé par un utilisateur sur un fichier choisi.
 * 
 * @see Commentaire
 *
 */
public class CommenterFichier extends CommenterFichierJar{

	@Override
	protected void apresConnection() {
		
		try {
			
			int lengthTemp;
			byte[] byteTemp = new byte[Parametre.LENGTH_ENVOYER];
			
			File file = new File(Parametre.fichiersConfigChemin+this.parametre1+".txt");
			
			System.out.println(this.parametre2);
			
			
			StringBuffer sb = new StringBuffer();
			if(file.exists()){
				FileInputStream fis = new FileInputStream(file);
				while ((lengthTemp = fis.read(byteTemp, 0, byteTemp.length)) > 0) {
					String strRead = new String(byteTemp);
					sb.append(String.copyValueOf(strRead.toCharArray(), 0, lengthTemp));
				
				}
				sb.append(this.parametre2);
				
				FileOutputStream fos = new FileOutputStream(file);
				
				fos.write(sb.toString().getBytes());
				
				fos.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
