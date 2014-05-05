package share.g2.miage.client.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import share.g2.miage.client.dao.User;
import share.g2.miage.client.outil.CrypterMDP;
import share.g2.miage.client.outil.ParametreC;
import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.fichier.SupprimerFichier;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.fonction.utilisateur.Login;
import share.g2.miage.clientJar.outil.Outil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.SystemColor;
import java.awt.Color;

public class FenetreLogin extends JFrame {

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
					FenetreLogin frame = new FenetreLogin();
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
	public FenetreLogin() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 360);
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
		textFieldLogin.setBounds(194, 73, 191, 28);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		passwordFieldMdp = new JPasswordField();
		passwordFieldMdp.setBounds(194, 117, 191, 28);
		contentPane.add(passwordFieldMdp);

		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldLogin.getText().equals("")
						|| passwordFieldMdp.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Manque logien et/ou mot de passe");
				} else {
					String login = textFieldLogin.getText();
					String mdp = passwordFieldMdp.getText();
					mdp = CrypterMDP.crypteMDP(mdp);
					System.out.println("MDP : " + mdp);

					FonctionClient fc = new Login(login, mdp);

					String resultat = fc.getResultat1();
					if ("1".equals(resultat)) {
						System.out.println("login ok");
						String userInfoStr = fc.getResultat2();
						String[] userInfo = Outil
								.StringToStringTableau(userInfoStr);

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

					} else if ("0".equals(resultat)) {
						System.out.println("pas de user");

						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null,
								"Cet utilisateur n'existe pas.",
								"Login failed", JOptionPane.WARNING_MESSAGE);

					} else if ("-1".equals(resultat)) {
						System.out.println("faute pw");

						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, "Mauvais mot de passe.",
								"Login failed", JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		btnConnexion.setBounds(194, 172, 191, 29);
		contentPane.add(btnConnexion);

		JButton btnCreer = new JButton("Creer un utilisateur");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							FenetreCreationUtilisateur frame = new FenetreCreationUtilisateur();
							frame.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		btnCreer.setBounds(194, 212, 191, 29);
		contentPane.add(btnCreer);

	}
}
