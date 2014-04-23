package share.g2.miage.server;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.Socket;  
import java.util.List;  
  
public class ServerThreadChat  extends Thread {  
    List<Socket> clientLinkList;  
    Socket clientLink;  
    BufferedReader br;  
    PrintStream ps;  
    String msg;  
    String ip;  
    public ServerThreadChat(List<Socket> clientLinkList, Socket clientLink) {  
        this.clientLinkList = clientLinkList;  
        this.clientLink = clientLink;  
        start();
    }  
  
    @Override  
    public void run() {  
  
        try {  
            br = new BufferedReader(new InputStreamReader(clientLink  
                    .getInputStream()));              
            //ip=clientLink.getInetAddress().getHostAddress();  
              
            while (null != (msg=br.readLine())) {         
                for (int i = 0; i < clientLinkList.size(); i++) {  
                    ps = new PrintStream(clientLinkList.get(i)  
                            .getOutputStream());  
                    ps.println("IPΪ:"+ip+"dire:"+msg+"\n");  
                      
                    ps.flush();  
                }  
            }  
              
              
          
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                if(null!=clientLink){  
                    clientLink.close();  
                      
                }  
                if(null!=br){  
                    br.close();  
                }  
                if(null!=ps){  
                    ps.close();  
                }  
                  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
  
    }  
  
}  