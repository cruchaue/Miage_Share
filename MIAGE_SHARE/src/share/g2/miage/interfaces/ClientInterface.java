package share.g2.miage.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.dao.Client;
import share.g2.miage.connectionClient.fonction.LireFichierInfo;
import share.g2.miage.connectionClient.fonction.SupprimerFichier;
import share.g2.miage.connectionClient.fonction.TelechargerFichier;
import share.g2.miage.connectionClient.fonction.UploadFichier;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class ClientInterface extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JScrollPane scrollPane;
	private String cheminC_enregistrer_fichier_defaut;
	private String cheminS_liste_fichier;

	// private Client client;

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

		cheminC_enregistrer_fichier_defaut = p.getProperty("cheminC_enregistrer_defaut");
		cheminS_liste_fichier = p.getProperty("fichierChemin");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 298);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JButton btnUpload = new JButton("Upload");

		scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 31, 151, 130);
		contentPane.add(scrollPane);
		
		list = new JList(new DefaultListModel<String>());
		
		listerFichier();
		// A METTRE ICI

		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
				chooser.setFileFilter(filter);
				JFrame parent = new JFrame();
				int returnVal = chooser.showOpenDialog(parent);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: "
							+ chooser.getSelectedFile().getName());
					System.out.println("Chemin absolu : "
							+ chooser.getSelectedFile().getAbsolutePath()
									.replaceAll("\\\\", "\\\\\\\\"));

					Client client = new Client();
					client.demarrer();
					client.setParametre1(chooser.getSelectedFile()
							.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
					client.setParametre2(chooser.getSelectedFile().getName());
					FonctionClientFichier fcf = new UploadFichier();
					String fichier = chooser.getSelectedFile()
							.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
					System.out.println("Fichier : " + fichier);
					fcf.excuter(client);
					
					
					
					
					client.closeConnection();
					
				}
				listerFichier();
			}
			
		});
		btnUpload.setBounds(44, 78, 89, 23);
		contentPane.add(btnUpload);

		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomFic = (String) list.getSelectedValue();

				System.out.println(nomFic);
				
				
				Client client = new Client();
				client.demarrer();
				client.setParametre1(cheminC_enregistrer_fichier_defaut);
				client.setParametre2(nomFic);
				FonctionClientFichier fcf = new TelechargerFichier();

				
				
				fcf.excuter(client);
				client.closeConnection();
				

			}
		});
		btnDownload.setBounds(44, 135, 89, 23);
		contentPane.add(btnDownload);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fichierSuppression = (String) list.getSelectedValue();
				
				Client client = new Client();
				client.demarrer();
				client.setParametre1(fichierSuppression);
				FonctionClientFichier fcf = new SupprimerFichier();

				
				
				fcf.excuter(client);
				client.closeConnection();
				
			}
		});
		btnSupprimer.setBounds(204, 172, 151, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnChat = new JButton("Chat");
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenetreChat fc = new fenetreChat();
				fc.show();
			}
		});
		btnChat.setBounds(23, 193, 117, 29);
		contentPane.add(btnChat);
		
		JButton btnInformationsFichier = new JButton("Informations fichier");
		btnInformationsFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filename = (String) list.getSelectedValue();
				fenetreInformations finfo = new fenetreInformations(filename);
				
				Client client = new Client();
				client.demarrer();
				client.setParametre1(filename);
				FonctionClientFichier fcf = new LireFichierInfo();

				
				
				fcf.excuter(client);
				client.closeConnection();
				
				finfo.show();
			}
		});
		btnInformationsFichier.setBounds(204, 206, 151, 23);
		contentPane.add(btnInformationsFichier);

	}
	
	public void listerFichier(){
		
		System.out.println("LA");
		

		final DefaultListModel<String> model = new DefaultListModel<String>();
		scrollPane.setViewportView(list);	
		
		
		File repertoire = new File(cheminS_liste_fichier);
		final String [] listefichiers; 


		//Temps d'attente pour l'upload du fichier sur le serveur
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			//if (listefichiers[i].endsWith(".txt") == true) {
				System.out.println("Valeur de " +i);
				System.out.println("---" + listefichiers[i]);
				model.addElement(listefichiers[i]);
			//}
		}

	list.setModel(model);
	}
}
