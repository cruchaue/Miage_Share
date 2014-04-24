package share.g2.miage.client.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import share.g2.miage.client.dao.Client;
import share.g2.miage.client.dao.User;
import share.g2.miage.client.fonction.Login;
import share.g2.miage.client.fonction.SupprimerFichier;
import share.g2.miage.client.fonction.interfaces.Fonction;
import share.g2.miage.util.CrypterMDP;
import share.g2.miage.util.Parametre;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.SystemColor;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FenetreNotification extends JFrame {
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
				setSize(450,300);
				
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
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setBounds(175, 243, 117, 29);
		getContentPane().add(btnEnvoyer);
		
		
	}
}