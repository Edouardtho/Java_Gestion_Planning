package entite;

public class matiere {
	// Attributs privés de la classe
	private int idMatiere;
	private String nomMatiere;
	private int nbHeures;
	
	// Constructeur
	public matiere(int idMatiere, String nomMatiere, int nbHeures){
		this.idMatiere = idMatiere;
		this.nomMatiere = nomMatiere;
		this.nbHeures = nbHeures;
	}
	
	// Getters
	public int getIdMatiere() {
		return idMatiere;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public int getNbHeures() {
		return nbHeures;
	}
	
	// Setters
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}
}
