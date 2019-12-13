package fr.dawan.formation.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MultiplicationResultAttempt {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private final User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MULTIPLICATION_ID")
	private final Multiplication multiplication;
	private int resultAttempt;
	private final boolean estCorrecte;
	
	
	public MultiplicationResultAttempt() {
		user = null;
		multiplication = null;
		resultAttempt = -1;
		estCorrecte = false;
	}
	
	public MultiplicationResultAttempt(long id, User user, Multiplication multiplication, int resultAttempt,
			boolean estCorrecte) {
		super();
		this.id = id;
		this.user = user;
		this.multiplication = multiplication;
		this.resultAttempt = resultAttempt;
		this.estCorrecte = estCorrecte;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getResultAttempt() {
		return resultAttempt;
	}
	public void setResultAttempt(int resultAttempt) {
		this.resultAttempt = resultAttempt;
	}
	public User getUser() {
		return user;
	}
	public Multiplication getMultiplication() {
		return multiplication;
	}
	public boolean isEstCorrecte() {
		return estCorrecte;
	}

	
	
	
	
	
}
