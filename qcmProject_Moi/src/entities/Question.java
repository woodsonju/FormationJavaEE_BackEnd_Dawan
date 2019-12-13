package entities;

public class Question {
	
	private long idQuestion;
	private String enonce;
	private long idQcm;
	private int ordre;
	private int multiple;
	
	public Question() {
	}
	
	public Question(String enonce, long idQCM, int ordre, int multiple) {
		this.enonce = enonce;
		this.idQcm = idQCM;
		this.ordre = ordre;
		this.multiple = multiple;
	}
	
	public Question(long idQuestion, String enonce, long idQCM, int ordre, int multiple) {
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.idQcm = idQCM;
		this.ordre = ordre;
		this.multiple = multiple;
	}

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public long getIdQCM() {
		return idQcm;
	}

	public void setIdQCM(long idQCM) {
		this.idQcm = idQCM;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}
	
}
