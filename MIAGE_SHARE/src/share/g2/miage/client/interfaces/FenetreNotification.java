package share.g2.miage.client.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.dao.User;
import share.g2.miage.client.fonction.EnvoyerMail;
import share.g2.miage.client.fonction.GetFichierList;
import share.g2.miage.client.fonction.Login;
import share.g2.miage.client.fonction.SupprimerFichier;
import share.g2.miage.client.fonction.interfaces.Fonction;
import share.g2.miage.server.dao.Utilisateur;
import share.g2.miage.util.CrypterMDP;
import share.g2.miage.util.Parametre;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JPasswordField;

import java.awt.SystemColor;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.MouseEvent;

public class FenetreNotification extends JFrame {

	private final DefaultListModel<String> model;

	public FenetreNotification() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblVoulezVousEnvoyer = new JLabel("Voulez- vous envoyer une notification ?  ");
		lblVoulezVousEnvoyer.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoulezVousEnvoyer.setVerticalAlignment(SwingConstants.TOP);
		lblVoulezVousEnvoyer.setBounds(6, 65, 438, 16);
		getContentPane().add(lblVoulezVousEnvoyer);

		JLabel lblFichierUploadeAvec = new JLabel("Fichier uploade avec succes !");
		lblFichierUploadeAvec.setBounds(18, 21, 196, 16);
		getContentPane().add(lblFichierUploadeAvec);

		JButton btnOui = new JButton("Oui");
		btnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(450,320);

			}
		});
		btnOui.setBounds(97, 93, 117, 29);
		getContentPane().add(btnOui);

		JButton btnNon = new JButton("Non");
		btnNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNon.setBounds(226, 93, 117, 29);
		getContentPane().add(btnNon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 138, 309, 97);
		getContentPane().add(scrollPane);
		
		final JList list = new JList(new DefaultListModel<String>());
		
		model = new DefaultListModel<String>();
		scrollPane.setViewportView(list);
		list.setModel(model);
		
		
		
		listerUtilisateurs();	
		

		


		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> list2 = list.getSelectedValuesList();
				for (int i=0; i<list2.size(); i++)
				{
					Client client = new Client();
					client.demarrer();
					client.setParametre1(list2.get(i));
					Fonction fcf = new EnvoyerMail();
					fcf.excuter(client);
					client.closeConnection();
				}
				
				
			}
		});
		btnEnvoyer.setBounds(175, 243, 117, 29);
		getContentPane().add(btnEnvoyer);

	}

	public void listerUtilisateurs() {
		String fichiers_BD_utilisateurs = ClientInterface.getBD_utilisateurs();

		File filename = new File(fichiers_BD_utilisateurs); 
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(filename));

			BufferedReader br = new BufferedReader(reader); 
			String line = "";

			while ((line =br.readLine()) != null) {
				System.out.println(line);
				String uStr[] = line.split(";");
				model.addElement(uStr[3]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}