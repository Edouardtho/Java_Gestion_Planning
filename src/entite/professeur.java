package entite;

public class professeur {
	// Attributs privés de la classe
	private int	idProf;
	private String nom;
	private String prenom;
	private String email;
	
	// Constructeur
	public professeur(int idProf, String nom, String prenom, String email){
		this.idProf = idProf;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	// Getters
	public int getIdProf() {
		return idProf;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getEmail() {
		return email;
	}
	
	// Setters
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
