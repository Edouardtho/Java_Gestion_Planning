package entite;

public class classe {
	// Attributs privés de la classe
	private int idClasse;
	private String nomClasse;
	private int nombreEleves;
	
	// Constructeurs
	public classe(String nomClasse, int nombreEleves){
		this.nomClasse = nomClasse;
		this.nombreEleves = nombreEleves;
	}
	public classe(int idClasse, String nomClasse, int nombreEleves){
		this.idClasse = idClasse;
		this.nomClasse = nomClasse;
		this.nombreEleves = nombreEleves;
	}
	
	// Getters
	public int getIdClasse() {
		return idClasse;
	}
	public String getNomClasse() {
		return nomClasse;
	}
	public int getNombreEleves() {
		return nombreEleves;
	}
	
	// Setters
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	public void setNombreEleve(int nombreEleves) {
		this.nombreEleves = nombreEleves;
	}
}
