package share.g2.miage.client.interfaces;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.client.dao.User;
import share.g2.miage.client.fonction.statistiques.StatUpDownload;
import share.g2.miage.client.outil.ParametreC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JList;
import javax.swing.JScrollPane;

import share.g2.miage.clientJar.dao.ClientConnection;
import share.g2.miage.clientJar.fonction.fichier.GetFichierList;
import share.g2.miage.clientJar.fonction.fichier.LireFichierInfo;
import share.g2.miage.clientJar.fonction.fichier.SupprimerFichier;
import share.g2.miage.clientJar.fonction.fichier.TelechargerFichier;
import share.g2.miage.clientJar.fonction.fichier.UploadFichier;
import share.g2.miage.clientJar.fonction.generalite.Communication;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.fonction.statistiques.StatUpDownloadJar;
import share.g2.miage.clientJar.outil.Outil;

public class ClientInterface extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> model;
	private JList list;
	private JScrollPane scrollPane;
	private String cheminC_enregistrer_fichier_defaut;
	private String cheminS_liste_fichier;
	private static String BD_utilisateurs;
	private static User User;
	private static String[] fichiers;
	private FenetreInformations finfo;

	// private Client client;

	public static User getUser() {
		return User;
	}

	public static void setUser(User user) {
		User = user;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	public String getCheminC_enregistrer_fichier_defaut() {
		return cheminC_enregistrer_fichier_defaut;
	}

	/**
	 * Create the frame.
	 */
	public ClientInterface() {
		setResizable(false);

		// lire le fichier de parametre
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("ipConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		cheminC_enregistrer_fichier_defaut = p
				.getProperty("cheminC_enregistrer_defaut");
		cheminS_liste_fichier = p.getProperty("fichierChemin");
		BD_utilisateurs = p.getProperty("BD_utilisateurs");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 460);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnUpload = new JButton("Upload");

		scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 11, 282, 347);
		contentPane.add(scrollPane);

		list = new JList(new DefaultListModel<String>());
		scrollPane.setViewportView(list);
		model = new DefaultListModel<String>();
		list.setModel(model);

		

		JButton btnAdmin = new JButton("Administration");
		btnAdmin.setVisible(false);
		System.out.println("Droit"+User.getDroit());
		if(User.getDroit()==1)
		{
			btnAdmin.setVisible(true);
		}
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FenetreAdministration fa = new FenetreAdministration(User);
				fa.setVisible(true);
			}
		});
		btnAdmin.setBounds(23, 26, 151, 23);
		contentPane.add(btnAdmin);

		listerFichier();
		// A METTRE ICI

		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"TXT files", "txt");
				chooser.setFileFilter(filter);
				JFrame parent = new JFrame();
				int returnVal = chooser.showOpenDialog(parent);
				if (returnVal == JFileChooser.APPROVE_OPTION) {


					FonctionClient fc = new UploadFichier(chooser.getSelectedFile()
							.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"),
							chooser.getSelectedFile().getName()
							);
					String fichier = chooser.getSelectedFile()
							.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");



					FenetreNotification f1 = new FenetreNotification();
					f1.setBounds(100, 100, 450, 175);
					f1.setVisible(true);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					listerFichier();
				}

			}

		});
		btnUpload.setBounds(23, 73, 151, 23);
		contentPane.add(btnUpload);

		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nomFic = (String) list.getSelectedValue();



				if("".equals(nomFic)||nomFic == null){
					JOptionPane.showMessageDialog(null,
							"Aucun fichier selectionne");					
				}
				else{
					FonctionClient fc = new TelechargerFichier(cheminC_enregistrer_fichier_defaut, nomFic, User.getUserName());
					JOptionPane.showMessageDialog(null,
							"Fichier telecharge avec succes");
				}

			}
		});
		btnDownload.setBounds(23, 107, 151, 23);
		contentPane.add(btnDownload);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fichierSuppression = (String) list.getSelectedValue();

				if("".equals(fichierSuppression)||fichierSuppression == null){
					JOptionPane.showMessageDialog(null,
							"Aucun fichier selectionne");

				}
				else{
					FonctionClient fcf = new SupprimerFichier(fichierSuppression);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					listerFichier();

				}
			}
		});
		btnSupprimer.setBounds(23, 141, 151, 23);
		contentPane.add(btnSupprimer);

		JButton btnInformationsFichier = new JButton("Informations fichier");
		btnInformationsFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (finfo == null) {
					finfo = new FenetreInformations();

				}

				String filename = (String) list.getSelectedValue();

				if("".equals(filename)||filename == null){
					JOptionPane.showMessageDialog(null,
							"Aucun fichier selectionne");

				}
				else{

					FonctionClient fc = new LireFichierInfo(filename);

				Fichier fichier = new Fichier(filename
						+ ParametreC.SPEPARER_FICHIER_INFO
						+ fc.getResultat1());
				finfo.setFichierInfo(fichier);

					finfo.show();
				}}
		});
		btnInformationsFichier.setBounds(23, 206, 151, 23);
		contentPane.add(btnInformationsFichier);

		JButton btnDconnexion = new JButton("Deconnexion");
		btnDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});
		btnDconnexion.setBounds(23, 349, 151, 29);
		contentPane.add(btnDconnexion);

		JButton btnNewButton = new JButton("Statistiques");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FenetreStat fs = new FenetreStat(User);
				fs.setVisible(true);
			}
		});
		btnNewButton.setBounds(23, 240, 151, 23);
		contentPane.add(btnNewButton);



	}

	public static String getBD_utilisateurs() {
		return BD_utilisateurs;
	}

	public void listerFichier() {
		// getFichiers
		FonctionClient fc = new GetFichierList(User.getUserName());
		fichiers = Outil.StringToStringTableau(fc.getResultat1());

		// Temps d'attente pour l'upload du fichier sur le serveur
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.clear();
		for (int i = 0; i < fichiers.length; i++) {

			model.addElement(fichiers[i]);
		}

	}
}
