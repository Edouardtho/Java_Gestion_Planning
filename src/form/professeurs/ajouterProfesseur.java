package form.professeurs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ajouterProfesseur extends JFrame {

	private JPanel contentPane;
	private JTextField NomProfText;
	private JTextField prenomProfText;
	private JTextField emailProfText;
	
	/**
	 * Create the frame.
	 */
	public ajouterProfesseur() {
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JPanel Top = new JPanel();
		Top.setBackground(new Color(102, 0, 0));
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(192, 192, 192));
		
		JLabel lblNomProf = new JLabel("Nom du prof :");
		
		NomProfText = new JTextField();
		NomProfText.setColumns(10);
		
		prenomProfText = new JTextField();
		prenomProfText.setColumns(10);
		
		emailProfText = new JTextField();
		emailProfText.setColumns(10);
		
		JLabel lblPrnomDuProf = new JLabel("Pr\u00E9nom du prof :");
		
		JLabel lblEmailDuProf = new JLabel("Email du prof :");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(Top, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
				.addComponent(bottom, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblEmailDuProf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNomProf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPrnomDuProf, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(emailProfText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(prenomProfText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(NomProfText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(Top, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomProf)
						.addComponent(NomProfText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(prenomProfText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrnomDuProf))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailProfText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailDuProf))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(bottom, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnAjouter = new JButton("Ajouter");
		
		JButton btnAnnuler = new JButton("Annuler");
		GroupLayout gl_bottom = new GroupLayout(bottom);
		gl_bottom.setHorizontalGroup(
			gl_bottom.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_bottom.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addComponent(btnAjouter)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAnnuler)
					.addGap(87))
		);
		gl_bottom.setVerticalGroup(
			gl_bottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bottom.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_bottom.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnuler)
						.addComponent(btnAjouter))
					.addContainerGap())
		);
		bottom.setLayout(gl_bottom);
		
		JLabel lblAjouterProf = new JLabel("Ajouter prof");
		lblAjouterProf.setForeground(Color.WHITE);
		lblAjouterProf.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 29));
		GroupLayout gl_Top = new GroupLayout(Top);
		gl_Top.setHorizontalGroup(
			gl_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjouterProf, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Top.setVerticalGroup(
			gl_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjouterProf)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		Top.setLayout(gl_Top);
		contentPane.setLayout(gl_contentPane);
	}
}
