package share.g2.miage.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import share.g2.miage.connectionServer.Utilisateur;

public class fenetreCreationUtilisateur extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField login;
	private JPasswordField pass;
	private JPasswordField verifPass;
	private JTextField mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenetreLogin frame = new fenetreLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fenetreCreationUtilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		login = new JTextField();
		login.setBounds(197, 50, 134, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(41, 53, 86, 14);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Saisir un mot de passe");
		lblNewLabel.setBounds(41, 87, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmez votre mot de passe");
		lblNewLabel_1.setBounds(41, 112, 146, 14);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBounds(197, 78, 134, 20);
		contentPane.add(pass);
		
		verifPass = new JPasswordField();
		verifPass.setBounds(197, 109, 134, 20);
		contentPane.add(verifPass);
		
		JLabel lblAdresseMail = new JLabel("Adresse mail");
		lblAdresseMail.setBounds(41, 143, 86, 14);
		contentPane.add(lblAdresseMail);
		
		mail = new JTextField();
		mail.setBounds(197, 140, 134, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnCreerLeCompte = new JButton("Créer le compte");
		btnCreerLeCompte.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Utilisateur u = new Utilisateur();
				u.setLoginName(login.getText());
				
				u.setPassword(pass.getText());
				u.setMail(mail.getText());
				
				
				
			}
		});
		btnCreerLeCompte.setBounds(221, 186, 109, 23);
		contentPane.add(btnCreerLeCompte);
		
		

	}
}
