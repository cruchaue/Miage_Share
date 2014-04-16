package share.g2.miage.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import share.g2.miage.connectionClient.Client;
import share.g2.miage.connectionClient.FonctionClientFichier;
import share.g2.miage.connectionClient.UploadFichier;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientInterface extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public ClientInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				    "TXT files", "txt");
				chooser.setFileFilter(filter);
				JFrame parent = new JFrame();
				int returnVal = chooser.showOpenDialog(parent);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				   System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
				   System.out.println("Chemin absolu : "+chooser.getSelectedFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
				   
				   
				    Client client = new Client();
					client.demarrer();
					client.setParametre1(chooser.getSelectedFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
					client.setParametre2(chooser.getSelectedFile().getName());
					FonctionClientFichier fcf = new UploadFichier();
					String fichier = chooser.getSelectedFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
					System.out.println("Fichier : "+fichier);
					fcf.excuter(client);
				}
			}
		});
		btnUpload.setBounds(153, 84, 89, 23);
		contentPane.add(btnUpload);
	}
}
