package form.classes;

import BLL.classeBLL;
import entite.classe;
import form.menu;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
public class modifierClasse extends JFrame {

	private JPanel contentPane;
	private JTextField nomClassText;
	private JTextField nbrElevesText;
	
	private List<classe> listeClasse;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	public modifierClasse() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		setTitle("Modif Classe");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblModifClasse = new JLabel("Modif Classe");
		lblModifClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifClasse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JComboBox cmbxClasse = new JComboBox();
		try {
			listeClasse = classeBLL.listeClasses();
		}
		catch (Exception e){
			// Boite du message préventif
			JOptionPane.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		cmbxClasse.addItem("Sélectionnez une classe");
		
		for(classe uneClasse:listeClasse){
			cmbxClasse.addItem(uneClasse.getNomClasse());
		}
		
		cmbxClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbxClasse.getSelectedIndex() == 0){
					nomClassText.setText("");
					nbrElevesText.setText("");
				}
				else{
					nomClassText.setText(listeClasse.get(cmbxClasse.getSelectedIndex()-1).getNomClasse());
					nbrElevesText.setText(String.valueOf(listeClasse.get(cmbxClasse.getSelectedIndex()-1).getNombreEleves()));
				}
			}
		});
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Si les champs du formulaire ne sont pas vides, on insert la nouvelle classe en base
				if (!nomClassText.getText().isEmpty() && !nbrElevesText.getText().isEmpty() && hibernate.fonctions.isInt(nbrElevesText.getText())){
					// Création de la classe à partir du formulaire
					classe newClasse = new classe(listeClasse.get(cmbxClasse.getSelectedIndex()-1).getIdClasse(), nomClassText.getText(), Integer.parseInt(nbrElevesText.getText()));
					
					// On essaie de sauvegarder la classe
					try {
						int realiser = classeBLL.updateClasse(newClasse);
						
						if (realiser == 1){
							// Boite du message préventif
							JOptionPane.showMessageDialog(null, "La classe a bien été modifiée.", "Valider", JOptionPane.INFORMATION_MESSAGE);
							
							menu eMenu = new menu();
							eMenu.setVisible(true);
							dispose();
						}
						else{
							// Boite du message préventif
							JOptionPane.showMessageDialog(null, "Une erreur s'est produite.", "Valider", JOptionPane.WARNING_MESSAGE);
						}
					}
					// Et si on n'y arrive pas on gère l'erreur
					catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if (cmbxClasse.getSelectedItem().toString() == "Sélectionnez une classe")
				{
					// Boite du message préventif
					JOptionPane.showMessageDialog(null, "Aucune classe n'est sélectionnée !", "Attention", JOptionPane.WARNING_MESSAGE);
				}
				// On avertit l'utilisateur si le nombre d'élèves n'est pas numérique
				else if (!hibernate.fonctions.isInt(nbrElevesText.getText())){
					// Boite du message préventif
					JOptionPane.showMessageDialog(null, "Le nombre d'élève n'est pas un nombre !", "Attention", JOptionPane.WARNING_MESSAGE);
				}
				// Sinon, on avertit l'utilisateur
				else
				{
					// Boite du message préventif
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
		
		JLabel lblNomClasse = new JLabel("Nom de la classe :");
		
		JLabel lblNbrEleves = new JLabel("Nombre d'\u00E9l\u00E8ves :");
		
		nomClassText = new JTextField();
		nomClassText.setColumns(10);
		
		nbrElevesText = new JTextField();
		nbrElevesText.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModifClasse, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(btnModifier, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(79))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(cmbxClasse, Alignment.LEADING, 0, 312, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNomClasse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
										.addComponent(lblNbrEleves, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(nbrElevesText)
										.addComponent(nomClassText, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
							.addGap(24)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblModifClasse, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbxClasse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomClasse, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomClassText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nbrElevesText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNbrEleves))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModifier)
						.addComponent(btnAnnuler))
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
