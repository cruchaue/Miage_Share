package share.g2.miage.client.interfaces.interne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;

import share.g2.miage.client.dao.Fichier;
import share.g2.miage.client.dao.User;
import share.g2.miage.client.fonction.statistiques.StatUpDownload;
import share.g2.miage.client.outil.ParametreC;
import share.g2.miage.clientJar.fonction.fichier.GetFichierList;
import share.g2.miage.clientJar.fonction.fichier.LireFichierInfo;
import share.g2.miage.clientJar.fonction.generalite.FonctionClient;
import share.g2.miage.clientJar.fonction.statistiques.outil.StatIndiv;
import share.g2.miage.clientJar.outil.Outil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreStat extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	private final DefaultListModel<String> model;
	private final DefaultListModel<String> model2;
	private static String[] fichiers;
	private static User User;
	private BufferedReader br;
	private StatIndiv statI = new StatIndiv();



	public static User getUser() {
		return User;
	}

	public static void setUser(User user) {
		User = user;
	}

	private JTabbedPane onglet = new JTabbedPane();

	/**
	 * Create the frame.
	 */
	public FenetreStat(User user) {
		this.User = user;
		this.setSize(700, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(onglet, null);
		// *************les onglets*****************************************//
		onglet.addTab("onglet1", null, pan1);



		onglet.setTitleAt(0, "Statistiques individuelles");
		pan1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 29, 167, 255);
		pan1.add(scrollPane);

		final JList list = new JList(new DefaultListModel<String>());
		scrollPane.setViewportView(list);

		model = new DefaultListModel<String>();
		scrollPane.setViewportView(list);
		list.setModel(model);


		JCheckBox chckbxNewCheckBox = new JCheckBox("connexion");
		chckbxNewCheckBox.setBounds(19, 76, 97, 23);
		pan1.add(chckbxNewCheckBox);

		JCheckBox checkBox = new JCheckBox("upload");
		checkBox.setBounds(19, 99, 97, 23);
		pan1.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("download");
		checkBox_1.setBounds(19, 125, 97, 23);
		pan1.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("suppression");
		checkBox_2.setBounds(19, 151, 97, 23);
		pan1.add(checkBox_2);

		JCheckBox checkBox_3 = new JCheckBox("message");
		checkBox_3.setBounds(19, 177, 97, 23);
		pan1.add(checkBox_3);

		JCheckBox chckbxCommentaire_2 = new JCheckBox("commentaire");
		chckbxCommentaire_2.setBounds(19, 203, 97, 23);
		pan1.add(chckbxCommentaire_2);

		JCheckBox checkBox_5 = new JCheckBox("notification");
		checkBox_5.setBounds(19, 229, 97, 23);
		pan1.add(checkBox_5);

		JButton btnNewButton = new JButton("Générer diagramme");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


			}
		});
		btnNewButton.setBounds(10, 259, 150, 23);
		pan1.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Utilisateur :");
		lblNewLabel.setBounds(19, 29, 97, 14);
		pan1.add(lblNewLabel);

		JLabel lblFichier = new JLabel("Fichier :");
		lblFichier.setBounds(401, 31, 62, 14);
		pan1.add(lblFichier);

		JCheckBox chckbxDownload = new JCheckBox("download");
		chckbxDownload.setBounds(401, 76, 97, 23);
		pan1.add(chckbxDownload);

		JCheckBox chckbxCommentaire = new JCheckBox("commentaire");
		chckbxCommentaire.setBounds(401, 99, 97, 23);
		pan1.add(chckbxCommentaire);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(504, 27, 165, 253);
		pan1.add(scrollPane_1);

		JList list_1 = new JList(new DefaultListModel<String>());
		scrollPane_1.setViewportView(list_1);

		model2 = new DefaultListModel<String>();
		scrollPane_1.setViewportView(list_1);
		list_1.setModel(model2);



		JButton button = new JButton("Générer diagramme");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				FonctionClient fc = new LireFichierInfo((String) list.getSelectedValue());

				System.out.println(fc.getResultat1());
				Fichier fichier = new Fichier((String) list.getSelectedValue()
						+ Parametre.SPEPARER_FICHIER_INFO
						+ fc.getResultat1());

				Fichier fic = null;

				DefaultPieDataset data2= new DefaultPieDataset();

				statI.createStatFicTest(fic,"commentaire",data2);

				statI.createStatFicTest(fic,"download",data2);

				  statI.statUt(data2,"Statistiques de l'utilisateur : "+list.getSelectedValue(),"");*/
			}
		});
		button.setBounds(347, 259, 151, 23);
		pan1.add(button);

		JButton btnDmo = new JButton("démo");
		btnDmo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FonctionClient<ChartFrame> fcf = new StatUpDownload(User.getUserName());
				ChartFrame chartFrame = fcf.getResultat3();
				chartFrame.setVisible(true);
			}
		});
		btnDmo.setBounds(19, 320, 150, 23);
		pan1.add(btnDmo);



		onglet.addTab("onglet2", null, pan2);
		onglet.setTitleAt(1, "Statistiques générales");
		pan2.setLayout(null);

		JButton button_1 = new JButton("Générer diagramme");
		button_1.setBounds(424, 82, 138, 23);
		pan2.add(button_1);

		JLabel lblFichiers = new JLabel("Fichiers");
		lblFichiers.setBounds(401, 14, 62, 14);
		pan2.add(lblFichiers);

		JButton button_2 = new JButton("Générer diagramme");
		button_2.setBounds(19, 82, 150, 23);
		pan2.add(button_2);

		JLabel lblUtilisateurs = new JLabel("Utilisateurs");
		lblUtilisateurs.setBounds(19, 12, 96, 14);
		pan2.add(lblUtilisateurs);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 32, 131, 20);
		comboBox.addItem("connexion");
		comboBox.addItem("upload");
		comboBox.addItem("download");
		comboBox.addItem("suppression");
		comboBox.addItem("message");
		comboBox.addItem("commentaire");
		comboBox.addItem("notification");
		pan2.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(471, 32, 131, 20);
		comboBox_1.addItem("download");
		comboBox_1.addItem("commentaire");
		pan2.add(comboBox_1);

		JLabel lblCritres = new JLabel("Critère :");
		lblCritres.setBounds(19, 35, 62, 14);
		pan2.add(lblCritres);

		JLabel label = new JLabel("Critère :");
		label.setBounds(401, 39, 62, 14);
		pan2.add(label);

		this.setContentPane(container);

		this.setVisible(true);
		listerFichiers();
		listerUtilisateurs();

	}

	public void listerFichiers() {
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
