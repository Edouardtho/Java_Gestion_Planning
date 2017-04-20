package form.professeurs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.matiereBLL;
import entite.matiere;
import form.menu;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class supprimerProf extends JFrame {

	private JPanel contentPane;
	private JTextField nbrHeuresText;
	private List<matiere> listeMatiere;
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public supprimerProf() {
		setTitle("Supprimer mati\u00E8re");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JComboBox cmbxMatiere = new JComboBox();
		try {
			listeMatiere = matiereBLL.listeMatieres();
		}
		catch (Exception e){
			// Boîte du message préventif
			JOptionPane.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		cmbxMatiere.addItem("Sélectionnez une matière");
		
		for(matiere uneMatiere:listeMatiere){
			cmbxMatiere.addItem(uneMatiere.getNomMatiere());
		}
		
		cmbxMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbxMatiere.getSelectedIndex() == 0){
					nbrHeuresText.setText("");
				}
				else{
					nbrHeuresText.setText(String.valueOf(listeMatiere.get(cmbxMatiere.getSelectedIndex()-1).getNbrHeures()));
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boîte du message préventif
				int rs = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer '"+listeMatiere.get(cmbxMatiere.getSelectedIndex()-1).getNomMatiere()+"' ?", "Supression", JOptionPane.OK_CANCEL_OPTION);
				
				// Si le résultat du message est ok
				if (rs == 0){
					// On essaie de sauvegarder la classe
					try {
						Boolean realiser = matiereBLL.deleteMatiere(listeMatiere.get(cmbxMatiere.getSelectedIndex()-1).getIdMatiere());
						
						if (realiser == false){
							// Boîte du message préventif
							JOptionPane.showMessageDialog(null, "La matière a bien été supprimée.", "Valider", JOptionPane.INFORMATION_MESSAGE);
							
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
				// Si Aucune classe n'est sélectionnée
				else if (cmbxMatiere.getSelectedItem().toString() == "Sélectionnez une matière"){
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
		
		JButton button_1 = new JButton("Annuler");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu eMenu = new menu();
				eMenu.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(118)
					.addComponent(btnModifier, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(67))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModifier)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 0));
		
		JLabel lblSupprimerMatire = new JLabel("Supprimer mati\u00E8re");
		lblSupprimerMatire.setForeground(Color.WHITE);
		lblSupprimerMatire.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 29));
		lblSupprimerMatire.setBackground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSupprimerMatire, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSupprimerMatire)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		nbrHeuresText = new JTextField();
		nbrHeuresText.setFont(new Font("Tahoma", Font.BOLD, 12));
		nbrHeuresText.setEditable(false);
		nbrHeuresText.setColumns(10);
		
		JLabel lblNbrHeures = new JLabel("Nombre d'heures :");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(cmbxMatiere, 0, 341, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNbrHeures)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(nbrHeuresText, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbxMatiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nbrHeuresText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNbrHeures))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
