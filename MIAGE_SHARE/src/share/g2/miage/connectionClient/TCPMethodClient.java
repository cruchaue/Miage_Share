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
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

			/* 读入TXT文件 */
			String pathname = "D:\\twitter\\13_9_6\\dataset\\en\\input.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
			File filename = new File(pathname); // 要读取以上路径的input。txt文件
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); // 建立一个输入流对象reader
			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			String msg;
			PrintStream ps =new PrintStream(client.getOutputStream());  
			while ((msg=br.readLine())!=null) {
				ps.println(msg);   //将输入框中的内容发送给服务器端
			}
			
			
			
           
			
			
/*
			
			File writename = new File(".\\result\\en\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
			writename.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write("我会写入文件啦\r\n"); // \r\n即为换行
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
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
