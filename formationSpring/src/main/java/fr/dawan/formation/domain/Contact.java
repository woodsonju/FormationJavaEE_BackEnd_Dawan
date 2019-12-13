package fr.dawan.formation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Entity
public class Contact implements InitializingBean, DisposableBean{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	@Column(nullable = true)
	private String prenom;
	
	public Contact() {
		super();

	}
	
	public Contact(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

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

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Instance de contact crée");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destruction élément");
	}

}
