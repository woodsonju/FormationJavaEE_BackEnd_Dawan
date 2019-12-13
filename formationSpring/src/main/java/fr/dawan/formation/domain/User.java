package fr.dawan.formation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	public String getAlias() {
		return alias;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private final String alias;
	
	public User() {
		this.alias = null;
	}
	
	public User(long id, String alias) {
		super();
		this.id = id;
		this.alias = alias;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
