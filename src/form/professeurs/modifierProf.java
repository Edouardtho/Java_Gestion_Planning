package form.professeurs;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class modifierProf extends JFrame {
	
	private JPanel contentPane;
	private JTextField nomMatiereText;
	private JTextField nbrHeuresText;
	private List<matiere> listeMatieres;
	
	/**
	 * Create the frame.
	 */
	public modifierProf() {
		setResizable(false);
		setTitle("Modifier mati\u00E8re");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel top = new JPanel();
		top.setBackground(new Color(102, 0, 0));
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(192, 192, 192));
		
		JComboBox<String> cmbxMatiere = new JComboBox<String>();
		try {
			listeMatieres = matiereBLL.listeMatieres();
		}
		catch (Exception e){
			// Boîte du message préventif
			JOptionPane.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		cmbxMatiere.addItem("Sélectionnez une classe");
		
		for(matiere uneMatiere:listeMatieres){
			cmbxMatiere.addItem(uneMatiere.getNomMatiere());
		}
		
		cmbxMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbxMatiere.getSelectedIndex() == 0){
					nomMatiereText.setText("");
					nbrHeuresText.setText("");
				}
				else{
					nomMatiereText.setText(listeMatieres.get(cmbxMatiere.getSelectedIndex()-1).getNomMatiere());
					nbrHeuresText.setText(String.valueOf(listeMatieres.get(cmbxMatiere.getSelectedIndex()-1).getNbrHeures()));
				}
			}
		});
		
		JLabel lblNomMatiere = new JLabel("Nom de la mati\u00E8re :");
		
		JLabel lblNbrHeures = new JLabel("Nombre d'heures :");
		
		nomMatiereText = new JTextField();
		nomMatiereText.setColumns(10);
		
		nbrHeuresText = new JTextField();
		nbrHeuresText.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(top, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
				.addComponent(bottom, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(cmbxMatiere, 0, 341, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNomMatiere)
					.addGap(18)
					.addComponent(nomMatiereText, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNbrHeures)
					.addGap(18)
					.addComponent(nbrHeuresText, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(top, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbxMatiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomMatiere)
						.addComponent(nomMatiereText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNbrHeures)
						.addComponent(nbrHeuresText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addComponent(bottom, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Si les champs du formulaire ne sont pas vides, on insert la nouvelle classe en base
				if (!nomMatiereText.getText().isEmpty() && !nbrHeuresText.getText().isEmpty() && hibernate.fonctions.isInt(nbrHeuresText.getText())){
					// Création de la classe à partir du formulaire
					matiere majMatiere = new matiere(listeMatieres.get(cmbxMatiere.getSelectedIndex()-1).getIdMatiere(), nomMatiereText.getText(), Integer.parseInt(nbrHeuresText.getText()));
					
					// On essaie de sauvegarder la classe
					try {
						int realiser = matiereBLL.updateMatiere(majMatiere);
						
						if (realiser == 1){
							// Boîte du message préventif
							JOptionPane.showMessageDialog(null, "La matière a bien été modifiée.", "Valider", JOptionPane.INFORMATION_MESSAGE);
							
							menu eMenu = new menu();
							eMenu.setVisible(true);
							dispose();
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
					}
				}
				else if (cmbxMatiere.getSelectedItem().toString() == "Sélectionnez une classe")
				{
					// Boîte du message préventif
					JOptionPane.showMessageDialog(null, "Aucune classe n'est sélectionnée !", "Attention", JOptionPane.WARNING_MESSAGE);
				}
				// On avertit l'utilisateur si le nombre d'élèves n'est pas numérique
				else if (!hibernate.fonctions.isInt(nbrHeuresText.getText())){
					// Boîte du message préventif
					JOptionPane.showMessageDialog(null, "Le nombre d'élève n'est pas un nombre !", "Attention", JOptionPane.WARNING_MESSAGE);
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
					.addComponent(btnModifier, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_bottom.setVerticalGroup(
			gl_bottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bottom.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_bottom.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModifier)
						.addComponent(btnAnnuler))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		bottom.setLayout(gl_bottom);
		
		JLabel lblModifierMatire = new JLabel("Modifier mati\u00E8re");
		lblModifierMatire.setForeground(new Color(255, 255, 255));
		lblModifierMatire.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 29));
		lblModifierMatire.setBackground(new Color(255, 255, 255));
		GroupLayout gl_top = new GroupLayout(top);
		gl_top.setHorizontalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModifierMatire, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_top.setVerticalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModifierMatire)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		top.setLayout(gl_top);
		getContentPane().setLayout(groupLayout);
	}
}
