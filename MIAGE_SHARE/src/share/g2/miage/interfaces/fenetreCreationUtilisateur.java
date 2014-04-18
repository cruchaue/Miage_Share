package share.g2.miage.interfaces;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class fenetreCreationUtilisateur extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBounds(197, 47, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(41, 50, 86, 14);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Saisir un mot de passe");
		lblNewLabel.setBounds(41, 85, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmez votre mot de passe");
		lblNewLabel_1.setBounds(41, 112, 146, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 78, 134, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(197, 109, 134, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblAdresseMail = new JLabel("Adresse mail");
		lblAdresseMail.setBounds(41, 143, 86, 14);
		contentPane.add(lblAdresseMail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 140, 134, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCrerLeCompte = new JButton("Créer le compte");
		btnCrerLeCompte.setBounds(221, 186, 109, 23);
		contentPane.add(btnCrerLeCompte);

	}
}
