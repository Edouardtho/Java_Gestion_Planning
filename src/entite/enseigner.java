package entite;

public class enseigner {
	// Attributs privés de la classe
	private int idEnseigner;
	private int idProf;
	private int idMatiere;
	
	// Constructeurs
	public enseigner(int idProf, int idMatiere){
		this.idProf = idProf;
		this.idMatiere = idMatiere;
	}
	
	public enseigner(int idEnseigner, int idProf, int idMatiere){
		this.idEnseigner = idEnseigner;
		this.idProf = idProf;
		this.idMatiere = idMatiere;
	}
	
	// Getters
	public int getIdEnseigner() {
		return idEnseigner;
	}
	public int getIdProf() {
		return idProf;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	
	// Setters
	public void setIdEnseigner(int idEnseigner) {
		this.idEnseigner = idEnseigner;
	}
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
}
