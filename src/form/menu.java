package form;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BLL.*;
import entite.*;
import form.classes.*;
import form.matiere.ajouterClasse;
import form.matiere.listeClasses;
import form.matiere.modifierClasse;
import form.matiere.suprimerClasse;
import form.matières.*;
import form.professeurs.*;
import form.salles.*;

@SuppressWarnings({ "unused", "serial" })
public class menu extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblClasses = new JLabel("Classes");
		lblClasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasses.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		/* Module classe */
		JButton btnAjouterClasses = new JButton("Ajouter");
		btnAjouterClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouterClasse ajoutClasse = new ajouterClasse();
				ajoutClasse.setVisible(true);
			}
		});
		
		JButton btnModifierClasses = new JButton("Modifier");
		btnModifierClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifierClasse modifClasse = new modifierClasse();
				modifClasse.setVisible(true);
			}
		});
		
		JButton btnSupprimerClasses = new JButton("Supprimer");
		btnSupprimerClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suprimerClasse suprClasse = new suprimerClasse();
				suprClasse.setVisible(true);
			}
		});
		
		JButton btnListeClasses = new JButton("Liste");
		btnListeClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeClasses lesClasses = new listeClasses();
				lesClasses.setVisible(true);
			}
		});
		/**/
		
		/* Module matière */
		JLabel lblmatieres = new JLabel("Mati\u00E8res");
		lblmatieres.setHorizontalAlignment(SwingConstants.CENTER);
		lblmatieres.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnAjouterMatieres = new JButton("Ajouter");
		btnAjouterMatieres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterMatiere ajoutMatiere = new ajouterMatiere();
				ajoutMatiere.setVisible(true);
			}
		});
		
		JButton btnModifierMatieres = new JButton("Modifier");
		btnModifierMatieres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierClasse modifMatiere = new modifierClasse();
				modifMatiere.setVisible(true);
			}
		});
		
		JButton btnSupprimerMatieres = new JButton("Supprimer");
		btnSupprimerMatieres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suprimerMatiere suprMatiere = new suprimerMatiere();
				suprMatiere.setVisible(true);
			}
		});
		
		JButton btnListeMatieres = new JButton("Liste");
		btnListeMatieres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeMatieres listeMatier = new listeMatieres();
				listeMatier.setVisible(true);
			}
		});
		/**/
		
		/* Module Professeur*/
		JLabel lblProfesseurs = new JLabel("Professeurs");
		lblProfesseurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfesseurs.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnAjouterProfesseurs = new JButton("Ajouter");
		btnAjouterProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterProfesseur ajoutProf = new ajouterProfesseur();
				ajoutProf.setVisible(true);
			}
		});

		JButton btnModifierProfesseurs = new JButton("Modifier");
		btnModifierProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierProfesseur modifProf = new modifierProfesseur();
				modifProf.setVisible(true);
			}
		});
		
		JButton btnSupprimerProfesseurs = new JButton("Supprimer");
		btnSupprimerProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suprimerProfesseur suprProf = new suprimerProfesseur();
				suprProf.setVisible(true);
			}
		});
		
		JButton btnListeProfesseurs = new JButton("Liste");
		btnListeProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeProfesseurs listeProf = new listeProfesseurs();
				listeProf.setVisible(true);
			}
		});
		/**/
		
		/* Module Salle */
		JLabel lblSalles = new JLabel("Salles");
		lblSalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalles.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnAjouterSalles = new JButton("Ajouter");
		btnAjouterSalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterSalle ajoutSalle = new ajouterSalle();
				ajoutSalle.setVisible(true);
			}
		});
		
		JButton btnModifierSalles = new JButton("Modifier");
		btnModifierSalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierSalle modifSalle = new modifierSalle();
				modifSalle.setVisible(true);
			}
		});
		
		JButton btnSuprimerSalles = new JButton("Supprimer");
		btnSuprimerSalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suprimerSalle suprSalle = new suprimerSalle();
				suprSalle.setVisible(true);
			}
		});
		
		JButton btnListeSalles = new JButton("Liste");
		btnListeSalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeSalles listSalles = new listeSalles();
				listSalles.setVisible(true);
			}
		});
		
		JButton btnPlanning = new JButton("Planning");
		btnPlanning.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnAjouterClasses, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnModifierClasses, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSupprimerClasses, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblClasses, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
								.addComponent(btnListeClasses, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnListeMatieres, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSupprimerMatieres, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnModifierMatieres, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAjouterMatieres, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblmatieres))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(54)
									.addComponent(lblProfesseurs, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addGap(59)
									.addComponent(lblSalles, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(72)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnModifierProfesseurs, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
											.addComponent(btnModifierSalles, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnAjouterProfesseurs, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnAjouterSalles, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnSupprimerProfesseurs, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
											.addComponent(btnSuprimerSalles, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnListeProfesseurs, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
											.addComponent(btnListeSalles, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))))))
						.addComponent(btnPlanning, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblmatieres, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblProfesseurs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSalles, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblClasses))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAjouterMatieres)
							.addComponent(btnAjouterSalles)
							.addComponent(btnAjouterProfesseurs))
						.addComponent(btnAjouterClasses))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnModifierClasses)
							.addGap(18)
							.addComponent(btnSupprimerClasses))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnModifierMatieres)
							.addGap(18)
							.addComponent(btnSupprimerMatieres))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnModifierProfesseurs)
							.addGap(18)
							.addComponent(btnSupprimerProfesseurs))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnModifierSalles)
							.addGap(18)
							.addComponent(btnSuprimerSalles)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListeMatieres)
						.addComponent(btnListeProfesseurs)
						.addComponent(btnListeSalles)
						.addComponent(btnListeClasses))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnPlanning, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
