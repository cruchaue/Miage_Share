package share.g2.miage.clientJar.fonction.autre.interne;
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
	private TextArea textArea = new TextArea();  
	private TextField textField = new TextField(); 
	
	private String userName;
	private Button button_send = new Button("Envoyer");  
	private Button button_clear = new Button("Effacer");  

	private static Socket clientLink;  
	private BufferedReader br;  
	private PrintStream ps;  
	private String msg;  
	private StringBuffer sb = new StringBuffer();  
	
	static {  
		try {  
			clientLink = new Socket("127.0.0.1",2001);  
		} catch (UnknownHostException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	}  

	public FenetreChat(String userName) {  
		super("ChatRoom");  
		this.userName = userName;
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		try {  

			br = new BufferedReader(new InputStreamReader(clientLink  
					.getInputStream()));  
			ps = new PrintStream(clientLink.getOutputStream());  

			//   
			button_send.addActionListener(new ActionListener() {  
				@Override  
				public void actionPerformed(ActionEvent e) {
					msg = textField.getText();  

					ps.println(userName+": "+msg);  
					ps.flush();  
				}  

			});  

			textField.addActionListener(new ActionListener() {  
				@Override  
				public void actionPerformed(ActionEvent e) {  
					msg = textField.getText();  

					ps.println(userName+": "+msg);  
					ps.flush();  

				}  

			});  

			button_clear.addActionListener(new ActionListener() {  
				@Override  
				public void actionPerformed(ActionEvent e) {  
					textArea.setText("");  
					sb.delete(0, sb.length());  
				}  
			});  

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