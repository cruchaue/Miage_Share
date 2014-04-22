package share.g2.miage.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.connectionClient.dao.Fichier;
import share.g2.miage.connectionClient.fonction.CommenterFichier;
import share.g2.miage.connectionClient.fonction.LireFichierInfo;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fenetreInformations extends JFrame {
	private final Fichier fichier;
	private JPanel contentPane;
	private JTextField textFieldCommentaire;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenetreInformations frame = new fenetreInformations(null,"");
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
	public fenetreInformations(final Fichier fichier, String nomFichier) {
		this.fichier = fichier;
		setTitle("Informations fichier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDuFichier = new JLabel("Nom du fichier :");
		lblNomDuFichier.setBounds(43, 30, 122, 14);
		contentPane.add(lblNomDuFichier);
		
		JLabel lblAuteur = new JLabel("Auteur :");
		lblAuteur.setBounds(43, 55, 110, 14);
		contentPane.add(lblAuteur);
		
		JLabel lblTempsDupload = new JLabel("Temps d'upload :");
		lblTempsDupload.setBounds(43, 107, 122, 14);
		contentPane.add(lblTempsDupload);
		
		JLabel lblNombreDeTlchargement = new JLabel("Nombre de téléchargements :");
		lblNombreDeTlchargement.setBounds(43, 135, 176, 14);
		contentPane.add(lblNombreDeTlchargement);
		
		JLabel lblTaille = new JLabel("Taille :");
		lblTaille.setBounds(43, 81, 110, 14);
		contentPane.add(lblTaille);
		
		JLabel lblDroits = new JLabel("Droits :");
		lblDroits.setBounds(43, 160, 122, 14);
		contentPane.add(lblDroits);
		
		JLabel lblCommentaires = new JLabel("Commentaires :");
		lblCommentaires.setBounds(324, 30, 110, 14);
		contentPane.add(lblCommentaires);
		
		JLabel nomFicLabel = new JLabel("New label");
		nomFicLabel.setBounds(229, 30, 131, 14);
		contentPane.add(nomFicLabel);
		
		JLabel auteurLabel = new JLabel("New label");
		auteurLabel.setBounds(229, 55, 131, 14);
		contentPane.add(auteurLabel);
		
		JLabel tailleLabel = new JLabel("New label");
		tailleLabel.setBounds(229, 81, 131, 14);
		contentPane.add(tailleLabel);
		
		JLabel tempsUploadLabel = new JLabel("New label");
		tempsUploadLabel.setBounds(229, 107, 131, 14);
		contentPane.add(tempsUploadLabel);
		
		JLabel nbTelechargementLabel = new JLabel("New label");
		nbTelechargementLabel.setBounds(229, 135, 131, 14);
		contentPane.add(nbTelechargementLabel);
		
		nomFicLabel.setText(nomFichier);
		auteurLabel.setText(this.fichier.getAuteur());
		tailleLabel.setText(this.fichier.getTaille());
		tempsUploadLabel.setText(this.fichier.getDate().toString());
		nbTelechargementLabel.setText(this.fichier.getNumTelechargement()+"");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(322, 56, 334, 118);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel droitsLabel = new JLabel("New label");
		droitsLabel.setBounds(229, 155, 49, 24);
		contentPane.add(droitsLabel);
		droitsLabel.setText(this.fichier.getDroit()+"");
		
		textFieldCommentaire = new JTextField();
		textFieldCommentaire.setBounds(44, 233, 612, 20);
		contentPane.add(textFieldCommentaire);
		textFieldCommentaire.setColumns(10);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//A FINIR ECRITURE DANS FICHIER
				
				Client client = new Client();
				client.demarrer();
				client.setParametre1(fichier.getNom());
				client.setParametre2(textFieldCommentaire.getText());
				//FonctionClientFichier fcf = new CommenterFichier();
				//fcf.excuter(client);
				client.closeConnection();
				System.out.println(client.getParametre1()+client.getParametre2());
			
			}
		});
		btnEnvoyer.setBounds(567, 264, 89, 23);
		contentPane.add(btnEnvoyer);
		
		JLabel lblVotreCommentaire = new JLabel("Votre commentaire :");
		lblVotreCommentaire.setBounds(43, 207, 176, 14);
		contentPane.add(lblVotreCommentaire);
	}
}
