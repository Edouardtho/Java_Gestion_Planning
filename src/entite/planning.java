package entite;

import java.sql.Date;
import java.sql.Time;

public class planning {
	// Attributs privés de la classe
	private int idPlanning;
	private Date jour;
	private Time heure;
	private int idSalle;
	private int idProf;
	private int idMatiere;
	
	// Constructeur
	public planning(int idPlanning, Date jour, Time heure, int idSalle, int idProf, int idMatiere){
		this.idPlanning = idPlanning;
		this.jour = jour;
		this.heure = heure;
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
	public Time getHeure() {
		return heure;
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
	public void setHeure(Time heure) {
		this.heure = heure;
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
