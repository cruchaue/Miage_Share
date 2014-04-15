package share.g2.miage.connectionClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class TCPMethodClient extends ConnectionClient implements
		FonctionShareClient {

	@Override
	public int uploadFichier(String fichierNom) {
		try {
			//String pathname = "D:\\twitter\\13_9_6\\dataset\\en\\input.txt"; // ���·�������·�������ԣ������Ǿ��·����д���ļ�ʱ��ʾ���·��
			File filename = new File(fichierNom); 
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader); 
			String msg;
			PrintStream ps =new PrintStream(client.getOutputStream());  
			while ((msg=br.readLine())!=null) {
				System.out.println(msg);
				
				//ps.println(msg);   
				
			}
			
			
			
           
			
			
/*
			
			File writename = new File(".\\result\\en\\output.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
			writename.createNewFile(); // �������ļ�
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write("�һ�д���ļ���\r\n"); // \r\n��Ϊ����
			out.flush(); // �ѻ���������ѹ���ļ�
			out.close(); // ���ǵùر��ļ�
			**/

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int telechargerFichier(String fichierNom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
