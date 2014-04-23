package share.g2.miage.client.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.dao.User;
import share.g2.miage.client.fonction.Login;
import share.g2.miage.client.fonction.SupprimerFichier;
import share.g2.miage.client.fonction.interfaces.FonctionClient;
import share.g2.miage.util.CrypterMDP;
import share.g2.miage.util.Parametre;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.SystemColor;
import java.awt.Color;

public class fenetreLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldMdp;

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
	public fenetreLogin() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(60, 79, 61, 16);
		contentPane.add(lblLogin);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(60, 117, 105, 16);
		contentPane.add(lblMotDePasse);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(194, 73, 134, 28);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		

		passwordFieldMdp = new JPasswordField();
		passwordFieldMdp.setBounds(194, 117, 134, 28);
		contentPane.add(passwordFieldMdp);

		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textFieldLogin.getText();
				String mdp = passwordFieldMdp.getText();
				mdp = CrypterMDP.crypteMDP(mdp);
				System.out.println("MDP : " +mdp);
				
				Client client = new Client();
				client.demarrer();
				client.setParametre1(login);
				client.setParametre2(mdp);
				FonctionClient fcf = new Login();

				fcf.excuter(client);
				String resultat = client.getResultat1();
				if (Parametre.OK.equals(resultat)) {
					System.out.println("login ok");
					String userInfoStr = client.getResultat2();
					String[] userInfo =  userInfoStr.split("<@>");
					
					User user = new User();
					user.setUserName(userInfo[0]);
					user.setDroit(Integer.valueOf(userInfo[1]));
					ClientInterface.setUser(user);
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								
								ClientInterface frame = new ClientInterface();
								frame.setVisible(true);

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					setVisible(false);

				} else if (Parametre.USER_EXISTE_PAS.equals(resultat)) {
					System.out.println("pas de user");
					
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null,
							"Cet utilisateur n'existe pas.",
							"Login failed",
							JOptionPane.WARNING_MESSAGE);
					
				} else if (Parametre.USER_PW_PAS_CORRECTE
						.equals(resultat)) {
					System.out.println("faute pw");
					
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null,
							"Mauvais mot de passe.",
							"Login failed",
							JOptionPane.WARNING_MESSAGE);
				}

				client.closeConnection();
				

			}
		});
		btnConnexion.setBounds(194, 156, 134, 29);
		contentPane.add(btnConnexion);
		
		JButton btnCreer = new JButton("Creer un utilisateur");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							fenetreCreationUtilisateur frame = new fenetreCreationUtilisateur();
							frame.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnCreer.setBounds(194, 212, 134, 29);
		contentPane.add(btnCreer);

	}
}
