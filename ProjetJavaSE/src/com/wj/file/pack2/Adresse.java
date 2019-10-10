package com.wj.file.pack2;

import java.io.Serializable;

/** 
 * @author Admin stagiaire
 * Serialisable : Les objets de cette classe peuvent être sérialisée
 *
 */
public class Adresse implements Serializable{
	
	private String voie;
	private String ville;
	private transient int codePostal; 	//transient eviter que cette  attribut soit sérialiser
	
	
	public Adresse() {
		super();
	}
	
	
	public Adresse(String voie, String ville, int codePostal) {
		super();
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public int getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}


	@Override
	public String toString() {
		return "Adresse [voie=" + voie + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}


}
