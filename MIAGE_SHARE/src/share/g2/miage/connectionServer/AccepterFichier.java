package share.g2.miage.connectionServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AccepterFichier implements
		FonctionServerFichier {

	@Override
	public int excuter(Server server) {
		try {
			Socket client  = server.getServerSocket().accept();
			
			PrintStream ps =new PrintStream(client.getOutputStream());       
			
			// l'entrée de serveur
			BufferedReader br;
			
			StringBuffer sb = new StringBuffer();

			br = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			
			
			//ps = new PrintStream(socket.getOutputStream());
			String msg;
			// accepter le fichier
			
			
			
            
            
            if((msg = br.readLine()) != null&&msg.equals("<@uploadTXT>")){
            	ps.println("ok pour uploadFichier.");
            	
            	  
            	String fichierNom = "";
            	if((msg = br.readLine()) != null){
            		fichierNom = msg;
            	}else{
            		return -1;
            	}
            	
            	 /* 写入Txt文件 */  
                File writename = new File(server.getFichierChemin()+fichierNom); // 相对路径，如果没有则要建立一个新的output。txt文件  
                writename.createNewFile(); // 创建新文件  
                BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            	
            	while ((msg = br.readLine()) != null) {
    				sb.append("reçu：" + msg + "\n");
    				System.out.println(msg);
    				
    				
    				//ps.println(msg);
    				if (msg.equals("<@finit>")) {
    					sb.append("客户端“2000”已退出！" + "\n");
    					sb.append("服务器程序将退出！");
    					System.out.print(sb.toString());
    					break;
    				}else{
    					out.write(msg+"\r\n"); // \r\n即为换行  
    				}
    				
    				ps.println(msg);
    			}
            	
            	out.flush(); // 把缓存区内容压入文件  
                out.close(); // 最后记得关闭文件
            }
			
			
			
			
			
			//br.close();
			client.close();
			ps.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

}
