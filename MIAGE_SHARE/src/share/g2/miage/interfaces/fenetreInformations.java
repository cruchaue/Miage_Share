package share.g2.miage.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import share.g2.miage.connectionClient.dao.Fichier;

public class fenetreInformations extends JFrame {
	private Fichier fichier;
	public void setFichier(Fichier fichier) {
		this.fichier = fichier;
	}

	private JPanel contentPane;

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
	public fenetreInformations(Fichier fichier, String nomFichier) {
		this.fichier = fichier;
		setTitle("Informations fichier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		lblCommentaires.setBounds(43, 185, 110, 14);
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
		
		JLabel droitsLabel = new JLabel("New label");
		droitsLabel.setBounds(229, 160, 131, 14);
		contentPane.add(droitsLabel);
		
		nomFicLabel.setText(nomFichier);
		auteurLabel.setText(this.fichier.getAuteur());
		tailleLabel.setText(this.fichier.getTaille());
		tempsUploadLabel.setText(this.fichier.getDate().toString());
		nbTelechargementLabel.setText(this.fichier.getNumTelechargement()+"");
		droitsLabel.setText(this.fichier.getDroit()+"");
	}
}
