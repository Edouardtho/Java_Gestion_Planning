package entite;

import hibernate.fonctions;

public class personne {
	// Attributs privés de la classe
	private int	idPersonne;
	private String nom;
	private String prenom;
	private String email;
	private String statut;
	private String identifiant;
	private String motDePasse;
	
	// Constructeur
	public personne(String nom, String prenom, String email, String statut){
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.statut = statut;
		this.identifiant = nom.substring(0).toLowerCase() + prenom.substring(0,1);
	}
	
	public personne(int idPersonne, String nom, String prenom, String email, String statut){
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.statut = statut;
	}
	
	public personne(String identifiant, String motDePasse){
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}
	
	// Getters
	public int getIdPersonne() {
		return idPersonne;
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
	public String getStatut() {
		return statut;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	
	// Setters
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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
	public void getStatut(String statut) {
		this.statut = statut;
	}
	public void getIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public void getMotDePasse(String motDePasse) {
		this.motDePasse = fonctions.md5(motDePasse);
	}
}
