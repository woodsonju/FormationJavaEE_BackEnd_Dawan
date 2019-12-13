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

	public Qcm(long id, String sujet) {
		this.idQcm = id;
		this.sujet = sujet;
	}

	public long getId() {
		return idQcm;
	}

	public void setId(long id) {
		this.idQcm = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	
}
