package form.classes;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.classeBLL;
import entite.classe;

import javax.swing.GroupLayout.Alignment;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class listeClasses extends JFrame {
	/**
	 * Attributs de l'application.
	 */
	private JPanel contentPane;
	private JOptionPane avertissement;
	private List<classe> listeClasse;
	private final String[] entetes = {"Id classe", "Nom", "Nombre d'élèves"};
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "static-access" })
	public listeClasses() {
		setTitle("Liste des classes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		try {
			listeClasse = classeBLL.listeClasses();
		}
		catch (Exception e){
			// Boîte du message préventif
			avertissement = new JOptionPane();
			avertissement.showMessageDialog(null, "Erreur de connection à la base de données !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		// Tuto : http://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable
		// Création du modèle de la table (colonnes)...
		DefaultTableModel model = new DefaultTableModel();
		
		// ...et du tableau
		JTable tableau = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tableau);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		// Ajout des colonnes
		for (String uneColonne:entetes)
		{
			model.addColumn(uneColonne);
		}
		
		// Ajout des données à partir de la base de données
		try {
			for (classe uneClasse:listeClasse)
			{
				model.addRow(new Object[]{uneClasse.getIdClasse(), uneClasse.getNomClasse(), uneClasse.getNombreEleves()});
			}
		}
		catch(Exception e){
			// Boîte du message préventif
			avertissement = new JOptionPane();
			avertissement.showMessageDialog(null, "Erreur de remplissage de la liste !" + System.getProperty("line.separator") + e, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
		JButton btnLoadClasses = new JButton("Chargement des donn\u00E9es");
		btnLoadClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JLabel lblListeDesClasses = new JLabel("Liste des classes");
		lblListeDesClasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesClasses.setFont(new Font("Tahoma", Font.BOLD, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblListeDesClasses, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
								.addComponent(btnLoadClasses))))
					.addGap(9))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListeDesClasses)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(btnLoadClasses)
					.addGap(76))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
