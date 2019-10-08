package com.wj.poo.scenarioPOO.entite;

public abstract class Commercial extends Employee {

	private double chiffreDaffaire;
	
	public Commercial() {
	}
	
	
	public Commercial(String nom, String prenom, int age, String date, double chiffreDaffaire) {
		super(nom, prenom, age, date);
		this.chiffreDaffaire = chiffreDaffaire;
	}


	public abstract double calculerSalaire();
	
	public double getChiffreDaffaire() {
		return this.chiffreDaffaire;
	}

}
