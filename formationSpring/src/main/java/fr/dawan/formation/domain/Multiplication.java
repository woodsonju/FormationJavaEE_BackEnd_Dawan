package fr.dawan.formation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 	Cette classe répresente une multiplication
 * @author Admin stagiaire
 *
 */
@Entity
public class Multiplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MULTIPLICATION_ID")
	private long id;
	
	private final int  factorA;
	private final int  factorB;
	
	private int resultat;
	
	public Multiplication() {
		this(0,0);

	}
	
	public Multiplication(int factorA, int factorB) {
		super();
		this.factorA = factorA;
		this.factorB = factorB;
	}

	public int getFactorA() {
		return factorA;
	}


	public int getFactorB() {
		return factorB;
	}



	public int getResultat() {
		return resultat = this.factorA*this.factorB;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}


	@Override
	public String toString() {
		return "Multiplication [factorA=" + factorA + ", factorB=" + factorB + ", resultat=" + resultat + "]";
	}

	
	
}
