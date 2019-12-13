package entities;

import java.io.Serializable;

public class Utilisateur implements Serializable{
	
	private long id;
	private String nom;
	private String email;
	private String pwd;
	
	public Utilisateur() {

	}
	
	public Utilisateur(String nom, String email, String pwd) {
		this.nom = nom;
		this.email = email;
		this.pwd = pwd;
	}
	
	public Utilisateur(long id, String nom, String email, String pwd) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.pwd = pwd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
