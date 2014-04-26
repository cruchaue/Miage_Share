package share.g2.miage.client.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import share.g2.miage.util.Parametre;

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
	private JPanel pan3 = new JPanel();
	private JTabbedPane onglet = new JTabbedPane();
	private final DefaultListModel<String> model;
	private BufferedReader br;

	/**
	 * Create the frame.
	 */
	public FenetreAdministration() {
		this.setTitle("TESTE");
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
		System.out.println(p.getProperty("BD_utilisateurs"));

		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnNewButton.setBounds(74, 382, 115, 41);
		pan1.add(btnNewButton);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteLine(Parametre.fichiers_BD_utilisateurs,list.getSelectedIndex());
			}
		});
		btnSupprimer.setBounds(223, 382, 115, 41);
		pan1.add(btnSupprimer);

		onglet.addTab("onglet2", null, pan2);
		onglet.addTab("onglet3", null, pan3);
		onglet.setTitleAt(0, "Gestion utilisateurs");
		onglet.setTitleAt(1, "Gestion fichiers ");
		onglet.setTitleAt(2, "Gestion des groupes ");

		listerUtilisateurs();

		// ***********et tu peux ajouter d'autre************************//
		container.add(onglet, null);

		this.setContentPane(container);

		this.setVisible(true);
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
				System.out.println(line);
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

	public void deleteLine(String fileName, int lineNumber) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));

			StringBuffer sb = new StringBuffer();
			String line;
			int nbLinesRead = 0;
			while ((line = reader.readLine()) != null) {
				if (nbLinesRead != lineNumber) {
					sb.append(line + "\r\n");
				}
				nbLinesRead++;
			}
			reader.close();
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(sb.toString());
			out.close();
			System.out.println("done");

		} catch (Exception e) {

		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAdministration frame = new FenetreAdministration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
