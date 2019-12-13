package fr.dawan.formationjpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
//@Table(name="Trainer")
public class Formateur extends DbObject{

	//unique : permet d'empecher le nombre de doublon
	@Column(unique=true)
	private String matricule;
	
	//length : permet de préciser la limite de taille
	//nullable : il accepte pas de valeur nul
	@Column(length=100, nullable=false)
	private String prenom;
	
	private String nom;
	private boolean estInterne;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Formation> competences = new ArrayList<>();

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isEstInterne() {
		return estInterne;
	}
	
	public void setEstInterne(boolean estInterne) {
		this.estInterne = estInterne;
	}
	
	
	public List<Formation> getCompetences() {
		return new ArrayList<Formation>(competences);
	}
	
	
	public void addCompetences(Formation formation) {
		if(!competences.contains(formation) && formation != null)
			this.competences.add(formation);
	}

	public void removeCompetences(Formation formation) {
		this.competences.remove(formation);
	}
	
	
	@Override
	public String toString() {
		return "Formateur [id="  + getId() + ", matricule=" + matricule + ", prenom=" + prenom + ", nom=" + nom + ", estInterne="
				+ estInterne + "]";
	}
	
	
	
}
