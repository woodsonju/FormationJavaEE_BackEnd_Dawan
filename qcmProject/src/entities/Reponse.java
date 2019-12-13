package entities;

import java.io.Serializable;

public class Reponse implements Serializable{
	
	private long idReponse;
	private long idQuestion;
	private String texte;
	private boolean correcte;
	
	public Reponse() {

	}

	public Reponse(long idQuestion, String texte, boolean correcte) {
		super();
		this.idQuestion = idQuestion;
		this.texte = texte;
		this.correcte = correcte;
	}

	public Reponse(long idReponse, long idQuestion, String texte, boolean correcte) {
		super();
		this.idReponse = idReponse;
		this.idQuestion = idQuestion;
		this.texte = texte;
		this.correcte = correcte;
	}


	public long getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(long idReponse) {
		this.idReponse = idReponse;
	}

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public boolean isCorrecte() {
		return correcte;
	}

	public void setCorrecte(boolean correcte) {
		this.correcte = correcte;
	}

}
