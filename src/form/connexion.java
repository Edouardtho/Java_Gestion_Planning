package form;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({ "serial", "unused" })
public class connexion extends JFrame {

	private JPanel contentPane;
	private JTextField identifiant;
	private JPasswordField passwordField;
	private JLabel lblIdentifiant;
	private JLabel lblpassword;
	private JPanel top;
	private JLabel lblConnexion;
	private JPanel panel;
	private JLabel lblErreur;

	/**
	 * Create the frame.
	 */

	public connexion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\Desktop\\Bachelor3\\Mliki\\image.ico"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 313);
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		identifiant = new JTextField();
		identifiant.setColumns(10);
		
		passwordField = new JPasswordField();
		
		lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblpassword = new JLabel("Mot de passe");
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		top = new JPanel();
		top.setBackground(new Color(102, 0, 0));
		
		lblConnexion = new JLabel("Connexion");
		lblConnexion.setForeground(Color.WHITE);
		lblConnexion.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 29));
		lblConnexion.setBackground(Color.WHITE);
		GroupLayout gl_top = new GroupLayout(top);
		gl_top.setHorizontalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConnexion, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_top.setVerticalGroup(
			gl_top.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConnexion, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		top.setLayout(gl_top);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		
		lblErreur = new JLabel("erreur");
		lblErreur.setForeground(new Color(255, 0, 0));
		lblErreur.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(top, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdentifiant, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(identifiant, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(lblpassword, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblErreur)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(top, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblErreur)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(lblIdentifiant)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(identifiant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblpassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
		);
		
		// Bouton "Connexion" et actions men�es lors du clic sur le bouton
		JButton validerBtn = new JButton("Connexion");
		validerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(validerBtn, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(validerBtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}