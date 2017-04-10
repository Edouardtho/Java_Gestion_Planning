package form.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.classeBLL;
import entite.classe;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class modifierClasse extends JFrame {

	private JPanel contentPane;
	private JTextField nomClassText;
	private JTextField nbrEleveText;
	
	private List<classe> listeClasse;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings({ "static-access", "rawtypes" })
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
		cmbxClasse.setToolTipText("S\u00E9lectionner une classe \u00E0 modifier");
		
		listeClasse = classeBLL.listeClasse();
		
		for(classe uneClasse:listeClasse){
			cmbxClasse.addItem(uneClasse.getNomClasse());
		}
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblNomClasse = new JLabel("Nom de la classe :");
		
		JLabel lblNbrEleves = new JLabel("Nombre d'\u00E9l\u00E8ves :");
		
		nomClassText = new JTextField();
		nomClassText.setColumns(10);
		
		nbrEleveText = new JTextField();
		nbrEleveText.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(cmbxClasse, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(lblModifClasse, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(btnModifier)
							.addGap(18)
							.addComponent(btnAnnuler))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNomClasse)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nomClassText, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNbrEleves)
							.addGap(10)
							.addComponent(nbrEleveText, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
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
						.addComponent(lblNomClasse)
						.addComponent(nomClassText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nbrEleveText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNbrEleves))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModifier)
						.addComponent(btnAnnuler))
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
