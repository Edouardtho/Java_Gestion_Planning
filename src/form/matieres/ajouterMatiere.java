package form.matieres;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.matiereBLL;
import entite.matiere;
import form.menu;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ajouterMatiere extends JFrame {

	private JPanel contentPane;
	private JTextField nomMatiereText;
	private JTextField nbrHeuresText;
	
	/**
	 * Create the frame.
	 */
	public ajouterMatiere() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel top = new JPanel();
		top.setBackground(new Color(102, 0, 0));
		
		JLabel lblNomMatiere = new JLabel("Nom Mati\u00E8re :");
		
		JLabel lblNbrHeures = new JLabel("Nombre d'heures :");
		
		nomMatiereText = new JTextField();
		nomMatiereText.setColumns(10);
		
		nbrHeuresText = new JTextField();
		nbrHeuresText.setColumns(10);
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(192, 192, 192));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(top, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNbrHeures)
						.addComponent(lblNomMatiere))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(nomMatiereText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
						.addComponent(nbrHeuresText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
					.addGap(18))
				.addComponent(bottom, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(top, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomMatiere)
						.addComponent(nomMatiereText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNbrHeures)
						.addComponent(nbrHeuresText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(bottom, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Si les champs du formulaire ne sont pas vides, on insert la nouvelle classe en base
				if (!nomMatiereText.getText().isEmpty() && !nbrHeuresText.getText().isEmpty() && hibernate.fonctions.isInt(nbrHeuresText.getText())){
					// Création de la classe à partir du formulaire
					matiere newMatiere = new matiere(nomMatiereText.getText(), Integer.parseInt(nbrHeuresText.getText()));
					
					// On essaie de sauvegarder la classe
					try {
						Boolean realiser = matiereBLL.saveMatiere(newMatiere);
						
						if (realiser == false){
							// Boîte du message préventif
							JOptionPane.showMessageDialog(null, "La matière a bien été enregistrée.", "Valider", JOptionPane.INFORMATION_MESSAGE);
							
							menu eMenu = new menu();
							eMenu.setVisible(true);
							dispose();
							
							/*
							 *	nomClassText.setText("");
							 *	nbrElevesText.setText("");
							 */
						}
						else{
							// Boîte du message préventif
							JOptionPane.showMessageDialog(null, "Une erreur s'est produite.", "Valider", JOptionPane.WARNING_MESSAGE);
						}
					}
					// Et si on n'y arrive pas on gère l'erreur
					catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

						menu eMenu = new menu();
						eMenu.setVisible(true);
						dispose();
					}
				}
				// On avertit l'utilisateur si le nombre d'élèves n'est pas numérique
				else if (!hibernate.fonctions.isInt(nbrHeuresText.getText())){
					// Boîte du message préventif
					JOptionPane.showMessageDialog(null, "Le nombre d'heure n'est pas un nombre !", "Attention", JOptionPane.WARNING_MESSAGE);
				}
				// Sinon, on avertit l'utilisateur
				else
				{
					// Boîte du message préventif
					JOptionPane.showMessageDialog(null, "Certains champs sont vides", "Attention", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu eMenu = new menu();
				eMenu.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_bottom = new GroupLayout(bottom);
		gl_bottom.setHorizontalGroup(
			gl_bottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bottom.createSequentialGroup()
					.addGap(118)
					.addComponent(btnAjouter, GroupLayout.PREFERRED_SIZE, 59, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 59, Short.MAX_VALUE)
					.addGap(99))
		);
		gl_bottom.setVerticalGroup(
			gl_bottom.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_bottom.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_bottom.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAjouter)
						.addComponent(btnAnnuler))
					.addContainerGap())
		);
		bottom.setLayout(gl_bottom);
		
		JLabel lblAjoutMatire = new JLabel("Ajout mati\u00E8re");
		lblAjoutMatire.setForeground(new Color(255, 255, 255));
		lblAjoutMatire.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 29));
		GroupLayout gl_top = new GroupLayout(top);
		gl_top.setHorizontalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjoutMatire, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_top.setVerticalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjoutMatire)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		top.setLayout(gl_top);
		getContentPane().setLayout(groupLayout);
	}

}