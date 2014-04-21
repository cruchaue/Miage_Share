package share.g2.miage.connectionServer.fonction;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import share.g2.miage.connectionServer.ClientS;
import share.g2.miage.connectionServer.FonctionServerFichier;
import share.g2.miage.connectionServer.Server;
import share.g2.miage.util.ParametrePublique;

public class AccepterFichier implements FonctionServerFichier {

	@Override
	public int excuter(ClientS clients) {
		try {

			DataInputStream dis = clients.getDis();
			BufferedInputStream bis = clients.getBis();
			FileOutputStream fos = null;

			byte[] byteTemp = new byte[1024];
			int lengthTemp = 0;
			String strTemp = "";

			strTemp = dis.readUTF();
			System.out.println(strTemp + ",");

			System.out.println(lengthTemp + ", " + strTemp);
			
			String userName = dis.readUTF();

			fos = new FileOutputStream(new File(Server.getFichierChemin()
					+ strTemp));
			while ((lengthTemp = bis.read(byteTemp, 0, byteTemp.length)) > 0) {
				fos.write(byteTemp, 0, lengthTemp);
				fos.flush();
			}
			fos.close();
			clients.closeConnection();
			
			creerFichierInfo(strTemp,userName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}
	
	private int creerFichierInfo(String fichierNom, String userName){
		StringBuffer sb =  new StringBuffer();
		String taille;
		String datestr;
		
		double temp = 1024;
		DecimalFormat df = new DecimalFormat("#.00");
		
		//obtenir la taille de fichier.
		File file = new File(Server.getFichierChemin()
				+ fichierNom);
		long filesize = file.length();
		if(filesize<1024){
			taille = filesize + "b";
		}else if(filesize<1024*1024){
			temp = filesize/temp;
			taille = df.format(temp)+"kb";
	        System.out.println(df.format(temp));
		}else{
			temp = 1024*1024;
			temp = filesize/temp;
			taille = df.format(temp)+"mb";
	        System.out.println(df.format(temp));
		}
		System.out.println("filesize: --"+filesize);
		
		//obtenir le temps.
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf  =   new  SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    datestr = sdf.format( date); 
		
	    sb.append(userName);
	    sb.append("<@_SFI>");
	    sb.append(taille);
	    sb.append("<@_SFI>");
	    sb.append(datestr);
	    sb.append("<@_SFI>");
	    sb.append("0");
	    sb.append("<@_SFI>");
	    sb.append("1");
	    
	    System.out.println(sb.toString());
	    FileOutputStream fos;
	    try {
	    fos = new FileOutputStream(new File(Server.getFichiersConfigChemin()
				+ fichierNom+".txt"));
	    byte[] byteFI = sb.toString().getBytes();
	    
			fos.write(byteFI);
		
	    fos.flush();
	    fos.close();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		
		return 1;
	}

}
