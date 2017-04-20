package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.classeBLL;
import BLL.matiereBLL;
import BLL.personneBLL;
import entite.*;
import form.classes.*;
import form.matieres.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class menu extends JFrame {
	/**
	 * Attributs de l'application.
	 */
	private JPanel contentPane;
	private JTabbedPane modules;
	
	private JButton btnAjouterClasse;
	private JButton btnModifierClasse;
	private JButton btnSupprimerClasse;
	
	private ArrayList<String> lesColonnes;
	private List<classe> listeClasses;
	private JTable tableauClasses;
	private List<matiere> listeMatieres;
	private JTable tableauMatieres;
	private List<personne> listePersonnes;
	private JTable tableauPersonnes;

	// private JButton btnActualiserClasses;
	private DefaultTableModel model;

	/**
	 * Création de la fenêtre.
	 * @throws Exception
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(0, 0, 884, 60);
		contentPane.add(panel);
		
		JLabel lblPlanning = new JLabel("Planning");
		lblPlanning.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlanning.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 29));
		lblPlanning.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlanning, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 498, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(181))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPlanning, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		modules = new JTabbedPane(JTabbedPane.TOP);
		modules.setBounds(0, 70, 884, 454);
		contentPane.add(modules);
		
		/********************************************************* Classes ********************************************************/
		// Tuto : http://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable
		// Création du modèle de la table (colonnes)...
		model = new DefaultTableModel();
		
		btnAjouterClasse = new JButton("Ajouter");
		btnAjouterClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouterClasse ajoutClasse = new ajouterClasse();
				ajoutClasse.setVisible(true);
				dispose();
			}
		});
		btnAjouterClasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnModifierClasse = new JButton("Modifier");
		btnModifierClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modifierClasse modifClasse = new modifierClasse();
					modifClasse.setVisible(true);
				}
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModifierClasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnSupprimerClasse = new JButton("Supprimer");
		btnSupprimerClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerClasse suprClasse = new supprimerClasse();
				suprClasse.setVisible(true);
			}
		});
		btnSupprimerClasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		/*
		 *	btnActualiserClasses = new JButton("Actualiser");
		 *	btnActualiserClasses.addActionListener(new ActionListener() {
		 *		public void actionPerformed(ActionEvent arg0) {
		 *			
		 *		}
		 *	});
		 *	btnActualiserClasses.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 */
		
		tableauClasses = getTableauClasse(model, btnAjouterClasse, btnModifierClasse, btnSupprimerClasse/*, btnActualiserClasses*/);
		/**************************************************************************************************************************/
		
		/******************************************************** Matières ********************************************************/
		model = new DefaultTableModel();
		JPanel panelMatieres = new JPanel();
		panelMatieres.setBackground(new Color(255, 255, 255));
		modules.addTab("Mati\u00E8res", null, panelMatieres, null);
		
		tableauMatieres= new JTable(model);
		JScrollPane scrollPaneMatieres = new JScrollPane(tableauMatieres);
		
		try {
			lesColonnes = classeBLL.nomColonnes("matiere");
			listeMatieres = matiereBLL.listeMatieres();
			
			for (String uneColonne:lesColonnes){
				model.addColumn(uneColonne);
			}
			for (matiere uneMatiere:listeMatieres)
			{
				model.addRow(new Object[]{uneMatiere.getIdMatiere(), uneMatiere.getNomMatiere(), uneMatiere.getNbrHeures()});
			}
		}
		catch (Exception e){
			// Boîte du message préventif
			JOptionPane.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		JButton btnAjouterMatiere = new JButton("Ajouter");
		btnAjouterMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterMatiere ajoutMatiere = new ajouterMatiere();
				ajoutMatiere.setVisible(true);
				dispose();
			}
		});
		btnAjouterMatiere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnModifierMatiere = new JButton("Modifier");
		btnModifierMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierMatiere modifMatiere = new modifierMatiere();
				modifMatiere.setVisible(true);
				dispose();
			}
		});
		btnModifierMatiere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSupprimerMatiere = new JButton("Supprimer");
		btnSupprimerMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerMatiere suprMatiere = new supprimerMatiere();
				suprMatiere.setVisible(true);
				dispose();
			}
		});
		btnSupprimerMatiere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panelMatieres = new GroupLayout(panelMatieres);
		gl_panelMatieres.setHorizontalGroup(
			gl_panelMatieres.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMatieres.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMatieres.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneMatieres, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
						.addGroup(gl_panelMatieres.createSequentialGroup()
							.addComponent(btnAjouterMatiere, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModifierMatiere, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSupprimerMatiere, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelMatieres.setVerticalGroup(
			gl_panelMatieres.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMatieres.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneMatieres, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMatieres.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAjouterMatiere, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModifierMatiere, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSupprimerMatiere, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelMatieres.setLayout(gl_panelMatieres);
		/**************************************************************************************************************************/
		
		/****************************************************** Professeurs *******************************************************/
		model = new DefaultTableModel();
		JPanel panelProf = new JPanel();
		panelProf.setBackground(new Color(255, 255, 255));
		modules.addTab("Professeurs", null, panelProf, null);
		
		tableauPersonnes= new JTable(model);
		JScrollPane scrollPaneProfs = new JScrollPane(tableauPersonnes);
		
		try {
			lesColonnes = classeBLL.nomColonnes("personne");
			listePersonnes = personneBLL.listePersonnes();
			
			for (String uneColonne:lesColonnes){
				model.addColumn(uneColonne);
			}
			for (personne unePersonne:listePersonnes)
			{
				model.addRow(new Object[]{unePersonne.getIdPersonne(), unePersonne.getNom(), unePersonne.getPrenom(), unePersonne.getEmail(), unePersonne.getStatut(), unePersonne.getIdentifiant()});
			}
		}
		catch (Exception e){
			// Boîte du message préventif
			JOptionPane.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		JButton btnModifierProf = new JButton("Modifier");
		btnModifierProf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSupprimerProf = new JButton("Supprimer");
		btnSupprimerProf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAjouterProf = new JButton("Ajouter");
		btnAjouterProf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_panelProf = new GroupLayout(panelProf);
		gl_panelProf.setHorizontalGroup(
			gl_panelProf.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProf.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelProf.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneProfs, GroupLayout.PREFERRED_SIZE, 859, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelProf.createSequentialGroup()
							.addComponent(btnAjouterProf, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnModifierProf, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnSupprimerProf, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelProf.setVerticalGroup(
			gl_panelProf.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProf.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneProfs, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_panelProf.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAjouterProf, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModifierProf, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSupprimerProf, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelProf.setLayout(gl_panelProf);
		/**************************************************************************************************************************/
		
		JPanel panelSalles = new JPanel();
		panelSalles.setBackground(new Color(255, 255, 255));
		modules.addTab("Salles", null, panelSalles, null);
		
		JButton btnModifierSalle = new JButton("Modifier");
		btnModifierSalle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSupprimerSalle = new JButton("Supprimer");
		btnSupprimerSalle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAjouterSalle = new JButton("Ajouter");
		btnAjouterSalle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JScrollPane scrollPaneSalles = new JScrollPane();
		GroupLayout gl_panelSalles = new GroupLayout(panelSalles);
		gl_panelSalles.setHorizontalGroup(
			gl_panelSalles.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSalles.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSalles.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneSalles, GroupLayout.PREFERRED_SIZE, 859, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelSalles.createSequentialGroup()
							.addComponent(btnAjouterSalle, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnModifierSalle, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnSupprimerSalle, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelSalles.setVerticalGroup(
			gl_panelSalles.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSalles.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPaneSalles, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_panelSalles.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAjouterSalle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModifierSalle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSupprimerSalle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelSalles.setLayout(gl_panelSalles);
	}
	
	public JTable getTableauClasse(DefaultTableModel model, JButton btnAjouterClasses, JButton btnModifierClasses, JButton btnSupprimerClasses/*, JButton btnActualiserClasses*/){
		tableauClasses = new JTable(model);
		
		JScrollPane scrollPaneClasses = new JScrollPane(tableauClasses);
		getContentPane().add(scrollPaneClasses, BorderLayout.CENTER);
		
		JPanel panelClasses = new JPanel();
		panelClasses.setBackground(new Color(255, 255, 255));
		modules.addTab("Classe", null, panelClasses, null);
		
		try {
			lesColonnes = classeBLL.nomColonnes("classe");
			listeClasses = classeBLL.listeClasses();
			
			for (String uneColonne:lesColonnes){
				model.addColumn(uneColonne);
			}
			for (classe uneClasse:listeClasses)
			{
				model.addRow(new Object[]{uneClasse.getIdClasse(), uneClasse.getNomClasse(), uneClasse.getNombreEleves()});
			}
		}
		catch (Exception e){
			// Boîte du message préventif
			JOptionPane.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		GroupLayout gl_panelClasses = new GroupLayout(panelClasses);
		gl_panelClasses.setHorizontalGroup(
			gl_panelClasses.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClasses.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelClasses.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelClasses.createSequentialGroup()
							.addComponent(btnAjouterClasses, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModifierClasses, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSupprimerClasses, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						/*	.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnActualiserClasses, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)*/)
						.addComponent(scrollPaneClasses, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelClasses.setVerticalGroup(
			gl_panelClasses.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClasses.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneClasses, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelClasses.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAjouterClasses, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(btnModifierClasses, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSupprimerClasses, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					/*	.addComponent(btnActualiserClasses, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)*/)
					.addContainerGap())
		);
		panelClasses.setLayout(gl_panelClasses);
		
		return tableauClasses;
	}
}
