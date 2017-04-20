package entite;

import java.sql.Date;
import java.sql.Time;

public class planning {
	// Attributs privés de la classe
	private int idPlanning;
	private Date jour;
	private Time heureDebut;
	private Time heureFin;
	private int idSalle;
	private int idProf;
	private int idMatiere;
	
	// Constructeur
	public planning(int idPlanning, Date jour, Time heureDebut, Time heureFin, int idSalle, int idProf, int idMatiere){
		this.idPlanning = idPlanning;
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.idSalle = idSalle;
		this.idProf = idProf;
		this.idMatiere = idMatiere;
	}
	
	// Getters
	public int getIdPlanning() {
		return idPlanning;
	}
	public Date getJour() {
		return jour;
	}
	public Time getHeureDebut() {
		return heureDebut;
	}
	public Time getHeureFin() {
		return heureFin;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public int getIdProf() {
		return idProf;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	
	// Setters
	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}
	public void setJour(Date jour) {
		this.jour = jour;
	}
	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}
	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
}
