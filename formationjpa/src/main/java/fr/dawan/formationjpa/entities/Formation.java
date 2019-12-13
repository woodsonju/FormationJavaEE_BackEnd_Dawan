package fr.dawan.formationjpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Formation extends DbObject{

	private String nom;
	private String prenom;
	private String code;
	
	@Column(scale=2)
	private double prix;
	
	private int duree;

	//@OneToMany(mappedBy="formation", cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	@OneToMany(mappedBy="formation", fetch=FetchType.EAGER)
	private List<SessionFormation> sessions = new ArrayList<SessionFormation>();
	
	@ManyToMany(mappedBy = "competences")
	private List<Formateur> formateursCompetents = new ArrayList<Formateur>();

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}


	public List<SessionFormation> getSessions() {
		//Retourne une copie de la collection avec le new 
		//Afin qu'il ne reference pas le même objet
		return new ArrayList<SessionFormation>(sessions);
	}

	public void addSessions(SessionFormation session) {
		if(!sessions.contains(session) && session != null)
			this.sessions.add(session);
	}

	public void removeSessions(SessionFormation session) {
		this.sessions.remove(session);
	}
	

	public List<Formateur> getFormateursCompetents() {
		return new ArrayList<Formateur>(formateursCompetents);
	}
	
	public void addFormateursCompetents(Formateur formateur) {
		this.formateursCompetents.add(formateur);
	}
	
	public void removeFormateursCompetents(Formateur formateur) {
		this.formateursCompetents.remove(formateur);

	}
	

	@Override
	public String toString() {
		return "Formation [id=" + getId() + ", nom=" + nom + ", code=" + code + ", prix=" + prix + ", duree=" + duree + "]";
	}

}
