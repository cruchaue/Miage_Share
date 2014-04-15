package share.g2.miage.connectionClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class UploadFichier implements
		FonctionClientFichier {

	

	@Override
	public int excuter(Socket client,String fichierNom) {
		try {
			//String pathname = "D:\\twitter\\13_9_6\\dataset\\en\\input.txt"; // ���·�������·�������ԣ������Ǿ��·����д���ļ�ʱ��ʾ���·��
			File filename = new File(fichierNom); 
			// 从服务端接受的数据流
			BufferedReader br1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader); 
			String msg;
			PrintStream ps =new PrintStream(client.getOutputStream()); 
			
				ps.println("<@uploadTXT>");
			
			
			if((msg=br1.readLine())!=null){
				ps.println(fichierNom);
			}else{
				return -1;
			}
			
			
			while ((msg=br.readLine())!=null) {
				ps.println(msg); // 将输入框中的内容发送给服务器端
				System.out.println(msg);
				//System.out.println(br1.readLine());;
				
				//ps.println(msg);   
				
			}
			
			
			ps.println("<@finit>"); // 将输入框中的内容发送给服务器端
			System.out.println("finir d'envoyer le fichier!");
			System.out.println(br1.readLine());;
			br1.close();
			ps.close();
			client.close();
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
