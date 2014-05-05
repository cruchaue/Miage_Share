package share.g2.miage.client.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;



import share.g2.miage.server.Server;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreServeur extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreServeur frame = new FenetreServeur();
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
	public FenetreServeur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 209, 129);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLancerServeur = new JButton("Lancer serveur");
		btnLancerServeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Server s1 = new Server();
				JOptionPane.showMessageDialog(null,
						"Serveur en fonctionnement");
			}
		});
		btnLancerServeur.setBounds(10, 30, 173, 23);
		contentPane.add(btnLancerServeur);
	}
}
