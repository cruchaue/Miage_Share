package share.g2.miage.client.interfaces.interne;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.client.outil.ParametreC;
import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.fichier.CommenterFichier;
import share.g2.miage.clientJar.fonction.fichier.LireFichierInfo;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FenetreInformations extends JFrame {
	//private final Fichier fichier;
	private JPanel contentPane;
	private JLabel nomFicLabel;
	private JLabel auteurLabel;
	private JLabel tailleLabel;
	private JList list;
	private JLabel tempsUploadLabel;
	private JLabel nbTelechargementLabel;
	private JLabel droitsLabel;

	DefaultListModel model ;
	private JTextField textFieldCommentaire;


	/**
	 * Create the frame.
	 */
	public FenetreInformations() {
		//this.fichier = fichier;
		setTitle("Informations fichier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 600);
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
		lblCommentaires.setBounds(43, 204, 131, 14);
		contentPane.add(lblCommentaires);

		nomFicLabel = new JLabel("New label");
		nomFicLabel.setBounds(229, 30, 87, 14);
		contentPane.add(nomFicLabel);

		auteurLabel = new JLabel("New label");
		auteurLabel.setBounds(229, 55, 87, 14);
		contentPane.add(auteurLabel);

		tailleLabel = new JLabel("New label");
		tailleLabel.setBounds(229, 81, 87, 14);
		contentPane.add(tailleLabel);

		tempsUploadLabel = new JLabel("New label");
		tempsUploadLabel.setBounds(229, 107, 87, 14);
		contentPane.add(tempsUploadLabel);

		nbTelechargementLabel = new JLabel("New label");
		nbTelechargementLabel.setBounds(229, 135, 87, 14);
		contentPane.add(nbTelechargementLabel);

		droitsLabel = new JLabel("New label");
		droitsLabel.setBounds(229, 155, 75, 24);
		contentPane.add(droitsLabel);

		//nomFicLabel.setText(nomFichier);
		//auteurLabel.setText(this.fichier.getAuteur());
		//tailleLabel.setText(this.fichier.getTaille());
		//tempsUploadLabel.setText(this.fichier.getDate().toString());
		//nbTelechargementLabel.setText(this.fichier.getNumTelechargement()+"");
		//droitsLabel.setText(this.fichier.getDroit()+"");


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 240, 612, 116);
		contentPane.add(scrollPane);
		list = new JList(new DefaultListModel<String>());
		scrollPane.setViewportView(list);
		model = new DefaultListModel<String>();
		list.setModel(model);





		textFieldCommentaire = new JTextField();
		textFieldCommentaire.setBounds(43, 406, 612, 53);
		contentPane.add(textFieldCommentaire);
		textFieldCommentaire.setColumns(10);


		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//A FINIR ECRITURE DANS FICHIER
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat sdf  =   new  SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

				String commentaire = ClientInterface.getUser().getUserName()+
						ParametreC.SPEPARER_FICHIER_COMMENTAIRE2+
						sdf.format( date)+
						ParametreC.SPEPARER_FICHIER_COMMENTAIRE2+
						textFieldCommentaire.getText()+
						ParametreC.SPEPARER_FICHIER_COMMENTAIRE1;
				new CommenterFichier(nomFicLabel.getText(),commentaire);


				FonctionClient fc = new LireFichierInfo(nomFicLabel.getText());
				Fichier fichier = new Fichier(fc.getResultat1());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				setFichierInfo(fichier);
				textFieldCommentaire.setText("");

			}
		});
		btnEnvoyer.setBounds(554, 513, 102, 23);
		contentPane.add(btnEnvoyer);

		JLabel lblVotreCommentaire = new JLabel("Votre commentaire :");
		lblVotreCommentaire.setBounds(43, 381, 176, 14);
		contentPane.add(lblVotreCommentaire);
	}

	public void setFichierInfo(Fichier fichier){
		nomFicLabel.setText(fichier.getNom());
		auteurLabel.setText(fichier.getAuteur());
		tailleLabel.setText(fichier.getTaille());
		tempsUploadLabel.setText(fichier.getDate());
		nbTelechargementLabel.setText(fichier.getNumTelechargement()+"");
		droitsLabel.setText(fichier.getDroit()+"");
		model.clear();
		if(fichier.getComms()!=null&&fichier.getComms().size()>0){
			for(int i = 0;i<fichier.getComms().size();i++){
				model.addElement(fichier.getComms().get(i).getContenu()+
						"  ["+fichier.getComms().get(i).getUser()+"/"+fichier.getComms().get(i).getDate()+"]");
			}

		}
	}
}
