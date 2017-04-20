package entite;

public class salle {
	// Attributs privés de la classe
	private int idSalle;
	private String nomSalle;
	private int capaciteSalle;
	
	// Constructeur
	public salle(int idSalle, String nomSalle, int capaciteSalle){
		this.idSalle = idSalle;
		this.nomSalle = nomSalle;
		this.capaciteSalle = capaciteSalle;
	}
	
	// Getters
	public int getIdSalle() {
		return idSalle;
	}
	public String getNomSalle() {
		return nomSalle;
	}
	public int getCapaciteSalle() {
		return capaciteSalle;
	}
	
	// Setters
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	public void setCapaciteSalle(int capaciteSalle) {
		this.capaciteSalle = capaciteSalle;
	}
}
