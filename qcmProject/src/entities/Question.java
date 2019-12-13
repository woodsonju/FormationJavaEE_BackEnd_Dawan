package entities;

import java.io.Serializable;

public class Question implements Serializable {
	
	private long idQuestion;
	private long idQcm;
	private String enonce;
	private int ordre;
	private boolean multiple;
	
	public Question() {
	}

	public Question(long idQcm, String enonce, int ordre, boolean multiple) {
		super();
		this.idQcm = idQcm;
		this.enonce = enonce;
		this.ordre = ordre;
		this.multiple = multiple;
	}
	
	public Question(long idQuestion, long idQcm, String enonce, int ordre, boolean multiple) {
		super();
		this.idQuestion = idQuestion;
		this.idQcm = idQcm;
		this.enonce = enonce;
		this.ordre = ordre;
		this.multiple = multiple;
	}

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public long getIdQcm() {
		return idQcm;
	}

	public void setIdQcm(long idQcm) {
		this.idQcm = idQcm;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}


}
