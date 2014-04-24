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

public class FenetreNotification extends JFrame {
	public FenetreNotification() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnResize = new JButton("resize");
		btnResize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSize(100,100);
			}
		});
		btnResize.setBounds(94, 110, 117, 29);
		getContentPane().add(btnResize);
		
		
	}
}