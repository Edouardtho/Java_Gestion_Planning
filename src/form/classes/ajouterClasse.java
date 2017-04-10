package form.classes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.classeBLL;
import entite.classe;

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
	private JTextField nbrEleveText;
	private JOptionPane avertissement;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public ajouterClasse() {
		setTitle("Ajout Classe");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAjoutClasse = new JLabel("Ajout Classe");
		lblAjoutClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutClasse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		nomClassText = new JTextField();
		nomClassText.setColumns(10);
		
		nbrEleveText = new JTextField();
		nbrEleveText.setColumns(10);
		
		JLabel lblNomClasse = new JLabel("Nom de la classe :");
		
		JLabel lblNombreEleves = new JLabel("Nombre d'\u00E9l\u00E8ves :");
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Si les champs du formulaire ne sont pas vides, on insert la nouvelle classe en base
				if (!nomClassText.getText().isEmpty() && !nbrEleveText.getText().isEmpty() && hibernate.fonctions.isInt(nbrEleveText.getText())){
					// Création de la classe à partir du formulaire
					classe newClasse = new classe(nomClassText.getText(), Integer.parseInt(nbrEleveText.getText()));
					
					// On essaie de sauvegarder la classe
					try {
						Boolean realiser = classeBLL.saveClasse(newClasse);
						System.out.println(realiser);
					}
					// Et si on n'y arrive pas on gère l'erreur
					catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// On avertit l'utilisateur si le nombre d'élèves n'est pas numérique
				else if (!hibernate.fonctions.isInt(nbrEleveText.getText())){
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
								.addComponent(lblNomClasse)
								.addComponent(lblNombreEleves))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(nbrEleveText, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomClassText, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAjoutClasse, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addComponent(btnAjouter)
							.addGap(18)
							.addComponent(btnAnnuler)))
					.addContainerGap())
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
								.addComponent(nbrEleveText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
