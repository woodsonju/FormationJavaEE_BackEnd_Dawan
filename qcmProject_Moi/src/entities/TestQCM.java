package entities;

import java.io.Serializable;
import java.util.Date;

public class TestQCM implements Serializable{
	
	private long idTest;
	private Date datePassage;
	private int score;
	private long idQcm;
	private long idUtilisateur;

	
	public TestQCM() {
		super();
	}

	
	public TestQCM(Date datePassage, int score, long idQcm, long idUtilisateur) {
		super();
		this.datePassage = datePassage;
		this.score = score;
		this.idQcm = idQcm;
		this.idUtilisateur = idUtilisateur;
	}
	
	public TestQCM(long idTest, Date datePassage, int score, long idQcm, long idUtilisateur) {
		super();
		this.idTest = idTest;
		this.datePassage = datePassage;
		this.score = score;
		this.idQcm = idQcm;
		this.idUtilisateur = idUtilisateur;
	}

	public long getIdTest() {
		return idTest;
	}


	public void setIdTest(long idTest) {
		this.idTest = idTest;
	}


	public Date getDatePassage() {
		return datePassage;
	}


	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public long getIdQcm() {
		return idQcm;
	}


	public void setIdQcm(long idQcm) {
		this.idQcm = idQcm;
	}


	public long getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	
}
