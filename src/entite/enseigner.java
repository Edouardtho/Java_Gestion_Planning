package entite;

public class enseigner {
	// Attributs privés de la classe
	private int idProf;
	private int idMatiere;
	
	// Constructeur
	public enseigner(int idProf, int idMatiere){
		this.idProf = idProf;
		this.idMatiere = idMatiere;
	}
	
	// Getters
	public int getIdProf() {
		return idProf;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	
	// Setters
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
}
