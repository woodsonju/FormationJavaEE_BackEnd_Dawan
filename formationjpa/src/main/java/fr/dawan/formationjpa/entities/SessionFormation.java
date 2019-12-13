package fr.dawan.formationjpa.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SessionFormation extends DbObject{
	
	private String lieu;
	private LocalDate dateDebut;
	private int nbPlaceMaxi;
	private int nbPlace;
	
	//On met cascade dans Formation, car quand on crée une session de formation
	//On veut créer une formation directement
	@ManyToOne //(cascade = CascadeType.PERSIST)
	private Formation formation;
	
	@ManyToOne
	private Formateur formateur;

	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public int getNbPlaceMaxi() {
		return nbPlaceMaxi;
	}
	public void setNbPlaceMaxi(int nbPlaceMaxi) {
		this.nbPlaceMaxi = nbPlaceMaxi;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	@Override
	public String toString() {
		return "SessionFormation [id="  + getId() + ", lieu=" + lieu + ", dateDebut=" + dateDebut + ", nbPlaceMaxi=" + nbPlaceMaxi
				+ ", nbPlace=" + nbPlace + ", formation=" + formation + ", formateur=" + formateur + "]";
	}
	
	
	
}
