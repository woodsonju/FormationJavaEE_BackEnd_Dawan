package com.wj.Exception.pack2;

public class Voiture {
	private String marque;
	private String vitesse;
	
	public Voiture() {
		super();

	} 
	
	public Voiture(String marque, String vitesse) {
		super();
		this.marque = marque;
		this.vitesse = vitesse;
	}

	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getVitesse() {
		return vitesse;
	}

	public void setVitesse(String vitesse) {
		this.vitesse = vitesse;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", vitesse=" + vitesse + "]";
	}
	
}
