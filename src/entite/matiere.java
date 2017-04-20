package entite;

public class matiere {
	// Attributs privés de la classe
	private int idMatiere;
	private String nomMatiere;
	private int nbrHeures;
	
	// Constructeur
	public matiere(String nomMatiere, int nbrHeures){
		this.nomMatiere = nomMatiere;
		this.nbrHeures = nbrHeures;
	}
	
	public matiere(int idMatiere, String nomMatiere, int nbrHeures){
		this.idMatiere = idMatiere;
		this.nomMatiere = nomMatiere;
		this.nbrHeures = nbrHeures;
	}
	
	// Getters
	public int getIdMatiere() {
		return idMatiere;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public int getNbrHeures() {
		return nbrHeures;
	}
	
	// Setters
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}
}
