package share.g2.miage.client.interfaces;
import java.awt.BorderLayout;  
import java.awt.Button;  
import java.awt.TextArea;  
import java.awt.TextField;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.Socket;  
import java.net.UnknownHostException;  

import javax.swing.JFrame;  
  
@SuppressWarnings("serial")  
public class FenetreChat extends JFrame  implements Runnable {  
    TextArea textArea = new TextArea();// ����һ���ı���  
    TextField textField = new TextField();// ����һ���ı���  
  
    Button button_send = new Button("Envoyer");  
    Button button_clear = new Button("Effacer");  
  
    static Socket clientLink;  
    BufferedReader br;  
    PrintStream ps;  
    String msg;  
    StringBuffer sb = new StringBuffer();  
  
    static {  
        try {  
            clientLink = new Socket("127.0.0.1",2001);  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public FenetreChat() {  
        super("ChatRoom");  
    }  
  
  


	@Override
	public void run() {
		this.setLocation(400, 450);  
        this.setSize(400, 400);  
        this.add(textArea, BorderLayout.NORTH);//   
        this.add(textField, BorderLayout.SOUTH);//  
        this.add(button_send, BorderLayout.EAST);//   
        this.add(button_clear, BorderLayout.WEST);  
        this.setVisible(true);//   
        this.pack();//  
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
  
        try {  
  
            br = new BufferedReader(new InputStreamReader(clientLink  
                    .getInputStream()));  
            ps = new PrintStream(clientLink.getOutputStream());  
  
            //   
            button_send.addActionListener(new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) {  
                    msg = textField.getText();  
                    System.out.println(msg);  
                    // ���ﲻ���û�����,�������������Ϣ  
                    ps.println(msg);  
                    ps.flush();  
                }  
  
            });  
  
            // �س�ʱ,�ı����¼�  
            textField.addActionListener(new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) {  
                    msg = textField.getText();  
                    // ���ﲻ���û�����д  
                    ps.println(msg);  
                    ps.flush();  
  
                }  
  
            });  
  
            // ������ť�¼�  
            button_clear.addActionListener(new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) {  
                    textArea.setText("");  
                    sb.delete(0, sb.length());  
                }  
            });  
  
            // ���ܷ�������Ϣ 
            show();
            while (true) {  
                msg = br.readLine();  
                sb.append(msg + "\n");  
                textArea.setText(sb.toString());  
                textField.setText("");  
            }  
  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (null != clientLink) {  
                    clientLink.close();  
  
                }  
                if (null != br) {  
                    br.close();  
                }  
                if (null != ps) {  
                    ps.close();  
                }  
  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
		
	}  
  
}  