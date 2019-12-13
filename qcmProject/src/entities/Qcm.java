package entities;

import java.io.Serializable;

public class Qcm implements Serializable {
	
	private long idQcm;
	private String sujet;
	
	public Qcm() {

	}
	
	public Qcm(String sujet) {
		this.sujet = sujet;
	}

	public Qcm(long idQcm, String sujet) {
		super();
		this.idQcm = idQcm;
		this.sujet = sujet;
	}

	public long getIdQcm() {
		return idQcm;
	}

	public void setIdQcm(long idQcm) {
		this.idQcm = idQcm;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	
}
