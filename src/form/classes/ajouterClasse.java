package form.classes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.classeBLL;
import entite.classe;
import form.menu;
import hibernate.fonctions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ajouterClasse extends JFrame {
	// Initialisation d'attributs
	private JPanel contentPane;
	private JTextField nomClassText;
	private JTextField nbrElevesText;
	private JOptionPane avertissement;
	private fonctions mesFonctions;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public ajouterClasse() {
		setTitle("Ajout Classe");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAjoutClasse = new JLabel("Ajout Classe");
		lblAjoutClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutClasse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		nomClassText = new JTextField();
		nomClassText.setColumns(10);
		
		nbrElevesText = new JTextField();
		nbrElevesText.setColumns(10);
		
		JLabel lblNomClasse = new JLabel("Nom de la classe :");
		
		JLabel lblNombreEleves = new JLabel("Nombre d'\u00E9l\u00E8ves :");
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Si les champs du formulaire ne sont pas vides, on insert la nouvelle classe en base
				if (!nomClassText.getText().isEmpty() && !nbrElevesText.getText().isEmpty() && hibernate.fonctions.isInt(nbrElevesText.getText())){
					// Création de la classe à partir du formulaire
					classe newClasse = new classe(nomClassText.getText(), Integer.parseInt(nbrElevesText.getText()));
					
					// On essaie de sauvegarder la classe
					try {
						Boolean realiser = classeBLL.saveClasse(newClasse);
						
						if (realiser == false){
							// Boîte du message préventif
							JOptionPane.showMessageDialog(null, "La classe a bien été enregistrée.", "Valider", JOptionPane.INFORMATION_MESSAGE);
							
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
							avertissement = new JOptionPane();
							avertissement.showMessageDialog(null, "Une erreur s'est produite.", "Valider", JOptionPane.WARNING_MESSAGE);
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
				else if (!hibernate.fonctions.isInt(nbrElevesText.getText())){
					// Boîte du message préventif
					avertissement = new JOptionPane();
					avertissement.showMessageDialog(null, "Le nombre d'élève n'est pas un nombre !", "Attention", JOptionPane.WARNING_MESSAGE);
				}
				// Sinon, on avertit l'utilisateur
				else
				{
					// Boîte du message préventif
					avertissement = new JOptionPane();
					avertissement.showMessageDialog(null, "Certains champs sont vides", "Attention", JOptionPane.WARNING_MESSAGE);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomClasse, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addComponent(lblNombreEleves, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(nomClassText)
								.addComponent(nbrElevesText, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
							.addGap(35))
						.addComponent(lblAjoutClasse, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addComponent(btnAjouter, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addGap(95)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAjoutClasse)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomClasse)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nomClassText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nbrElevesText, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombreEleves))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnuler)
						.addComponent(btnAjouter))
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
