package share.g2.miage.client.interfaces;

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
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;



public class FenetreAdministration extends JFrame{
	private JPanel container = new JPanel();
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	private JPanel pan3 = new JPanel();
	private JTabbedPane onglet = new JTabbedPane();
	private final DefaultListModel<String> model;


	/**
	 * Create the frame.
	 */
	public FenetreAdministration() {
		this.setTitle("TESTE");
		this.setSize(700, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		//*************les onglets*****************************************//
		onglet.addTab("onglet1", null, pan1);
		pan1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 37, 504, 323);
		pan1.add(scrollPane);

		final JList list = new JList(new DefaultListModel<String>());;
		scrollPane.setViewportView(list);

		model = new DefaultListModel<String>();
		scrollPane.setViewportView(list);
		list.setModel(model);

		onglet.addTab("onglet2", null,pan2);
		onglet.addTab("onglet3", null,pan3);
		onglet.setTitleAt(0,"Gestion utilisateurs");
		onglet.setTitleAt(1,"Gestion fichiers ");
		onglet.setTitleAt(2,"Gestion des groupes ");

		listerUtilisateurs();

		//***********et tu peux ajouter d'autre************************//
		container.add(onglet,null);

		this.setContentPane(container);          

		this.setVisible(true);
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
				model.addElement(uStr[1]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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



