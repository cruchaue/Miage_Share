package share.g2.miage.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.connectionClient.fonction.UploadFichier;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fenetreChat extends JFrame {

	private JPanel contentPane;
	private final JButton btnRecevoir = new JButton("Recevoir");
	Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenetreChat frame = new fenetreChat();
					frame.setVisible(true);
					Client client = new Client();
					client.demarrer();
					FonctionClientFichier fcf = new UploadFichier();
					client.setParametre1("test.jpg");
					client.setParametre2("test.jpg");
					fcf.excuter(client);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public fenetreChat() {
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCeciEstUn = new JLabel("Ceci est un chat :");
		lblCeciEstUn.setBounds(6, 18, 109, 16);
		contentPane.add(lblCeciEstUn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 148, 451, 140);
		contentPane.add(scrollPane);
		
		JTextPane textPaneReception = new JTextPane();
		scrollPane.setViewportView(textPaneReception);
		
		JButton btnPoster = new JButton("Poster");
		btnPoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.toString();
			}
		});
		btnPoster.setBounds(214, 101, 89, 23);
		contentPane.add(btnPoster);
		
		JButton btnCloseConnexion = new JButton("Close connexion");
		btnCloseConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				client.closeConnection();
				
			}
		});
		btnCloseConnexion.setBounds(317, 299, 117, 23);
		contentPane.add(btnCloseConnexion);
		btnRecevoir.setBounds(186, 299, 109, 23);
		contentPane.add(btnRecevoir);
		
		JTextPane textPaneEcriture = new JTextPane();
		textPaneEcriture.setBounds(16, 45, 451, 45);
		contentPane.add(textPaneEcriture);
	}
}
