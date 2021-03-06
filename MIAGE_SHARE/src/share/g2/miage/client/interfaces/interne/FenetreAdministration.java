package share.g2.miage.client.interfaces.interne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import share.g2.miage.client.dao.User;
import share.g2.miage.client.outil.ParametreC;
import share.g2.miage.clientJar.fonction.fichier.GetFichierList;
import share.g2.miage.clientJar.fonction.fichier.ModifierDroitFichier;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.fonction.utilisateur.ModifierDroitUtilisateur;
import share.g2.miage.clientJar.fonction.utilisateur.SupprimerUtilisateur;
import share.g2.miage.clientJar.outil.Outil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAdministration extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();

	private JTabbedPane onglet = new JTabbedPane();
	private final DefaultListModel<String> model;
	private final DefaultListModel<String> model2;
	private BufferedReader br;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private static String[] fichiers;
	private static User user;
	private final JButton btnAttribuerDroits = new JButton("Attribuer droits");
	private final JButton btnNewButton = new JButton("Modifier les droits");

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		user = user;
	}

	/**
	 * Create the frame.
	 */
	public FenetreAdministration(User user) {
		this.user = user;
		this.setSize(700, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		// *************les onglets*****************************************//
		onglet.addTab("onglet1", null, pan1);
		pan1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 37, 504, 323);
		pan1.add(scrollPane);

		final JList<String> list = new JList<String>(
				new DefaultListModel<String>());
		;
		scrollPane.setViewportView(list);

		model = new DefaultListModel<String>();
		scrollPane.setViewportView(list);
		list.setModel(model);

		final Properties p = new Properties();
		

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SupprimerUtilisateur(list.getSelectedValue());
			
			}
		});
		btnSupprimer.setBounds(363, 394, 180, 41);
		pan1.add(btnSupprimer);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomUtil = (String) list.getSelectedValue();
				
				if ("".equals(nomUtil) || nomUtil == null) {
					JOptionPane.showMessageDialog(null,
							"Aucun fichier selectionne");
				} else {

					Object[] possibilities = { "1", "2", "3" };
					String choixDroit = (String) JOptionPane.showInputDialog(
							null, "Choisir le niveau de droit de l'utilisateur",
							"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
							null, possibilities, "1");
					
					FonctionClient fcf = new ModifierDroitUtilisateur(nomUtil, choixDroit);
					//modifierDroitUtilisateur(nomUtil, choixDroit);

				}

			}
		});
		btnNewButton.setBounds(105, 394, 180, 41);
		
		pan1.add(btnNewButton);

		onglet.addTab("onglet2", null, pan2);
		pan2.setLayout(null);
		scrollPane_1.setBounds(338, 5, 2, 2);

		pan2.add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(78, 36, 558, 426);
		pan2.add(scrollPane_2);

		model2 = new DefaultListModel<String>();
		final JList list_1 = new JList(new DefaultListModel<String>());
		scrollPane_2.setViewportView(list_1);
		list_1.setModel(model2);

		btnAttribuerDroits.setBounds(269, 473, 188, 23);

		pan2.add(btnAttribuerDroits);

		
		onglet.setTitleAt(0, "Gestion utilisateurs");
		onglet.setTitleAt(1, "Gestion fichiers ");
		

		btnAttribuerDroits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomFic = (String) list_1.getSelectedValue();
			
				if ("".equals(nomFic) || nomFic == null) {
					JOptionPane.showMessageDialog(null,
							"Aucun fichier selectionne");
				} else {

					Object[] possibilities = { "1", "2", "3" };
					String choixDroit = (String) JOptionPane.showInputDialog(
							null, "Choisir le niveau de droit du fichier",
							"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
							null, possibilities, "1");
					
					FonctionClient fcf = new ModifierDroitFichier(nomFic, choixDroit);
				}

			}
		});

		listerFichiers();

		// ***********et tu peux ajouter d'autre************************//
		container.add(onglet, null);

		this.setContentPane(container);

		this.setVisible(true);
		listerUtilisateurs();
	}
	
	public void listerFichiers() {
		// getFichiers
		FonctionClient fc = new GetFichierList(user.getUserName());
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

			model2.addElement(fichiers[i]);
		}

	}

	public void listerUtilisateurs() {
		String fichiers_BD_utilisateurs = ClientInterface.getBD_utilisateurs();

		File filename = new File(fichiers_BD_utilisateurs);
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(filename));

			br = new BufferedReader(reader);
			String line = "";

			while ((line = br.readLine()) != null) {
				
				String uStr[] = line.split(";");
				if(!uStr[0].equals(user.getUserName()))
					model.addElement(uStr[0]);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
