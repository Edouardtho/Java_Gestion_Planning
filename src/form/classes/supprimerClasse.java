package form.classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BLL.classeBLL;
import entite.classe;
import hibernate.fonctions;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings({ "serial", "unused" })
public class supprimerClasse extends JFrame {
	private JPanel contentPane;
	private JOptionPane avertissement;
	private List<classe> listeClasse;
	private JTextField nbrElevesText;
	private fonctions mesFonctions;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	public supprimerClasse() {
		setTitle("Suppression Classe");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JLabel lblNbrEleves = new JLabel("Nombre d'\u00E9l\u00E8ves :");
		
		JComboBox cmbxClasse = new JComboBox();
		try {
			listeClasse = classeBLL.listeClasses();
		}
		catch (Exception e){
			// Boîte du message préventif
			avertissement = new JOptionPane();
			avertissement.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		cmbxClasse.addItem("Sélectionnez une classe");
		
		for(classe uneClasse:listeClasse){
			cmbxClasse.addItem(uneClasse.getNomClasse());
		}
		
		cmbxClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbxClasse.getSelectedIndex() == 0){
					nbrElevesText.setText("");
				}
				else{
					nbrElevesText.setText(String.valueOf(listeClasse.get(cmbxClasse.getSelectedIndex()-1).getNombreEleves()));
				}
			}
		});
		
		JLabel label_1 = new JLabel("Suppression Classe");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boîte du message préventif
				int rs = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer '"+listeClasse.get(cmbxClasse.getSelectedIndex()-1).getNomClasse()+"' ?", "Supression", JOptionPane.OK_CANCEL_OPTION);
				
				// Si le résultat du message est ok
				if (rs == 0){
					// On essaie de sauvegarder la classe
					try {
						Boolean realiser = classeBLL.deleteClasse(listeClasse.get(cmbxClasse.getSelectedIndex()-1).getIdClasse());
						
						if (realiser == false){
							// Boîte du message préventif
							JOptionPane.showMessageDialog(null, "La classe a bien été supprimée.", "Valider", JOptionPane.INFORMATION_MESSAGE);
							
							mesFonctions.close();
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
				// Si Aucune classe n'est sélectionnée
				else if (cmbxClasse.getSelectedItem().toString() == "Sélectionnez une classe"){
					// Boîte du message préventif
					JOptionPane.showMessageDialog(null, "Aucune classe n'est sélectionnée !", "Attention", JOptionPane.WARNING_MESSAGE);
				}
				// Si une autre erreur survient
				else{
					// Boîte du message préventif
					JOptionPane.showMessageDialog(null, "Une erreur est survenue !", "Attention", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesFonctions.close();
				dispose();
			}
		});
		
		nbrElevesText = new JTextField();
		nbrElevesText.setFont(new Font("Tahoma", Font.BOLD, 12));
		nbrElevesText.setForeground(Color.BLACK);
		nbrElevesText.setEditable(false);
		nbrElevesText.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addComponent(btnSupprimer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
							.addGap(87))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cmbxClasse, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNbrEleves)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nbrElevesText)))
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(cmbxClasse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNbrEleves)
						.addComponent(nbrElevesText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSupprimer)
						.addComponent(btnAnnuler))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
