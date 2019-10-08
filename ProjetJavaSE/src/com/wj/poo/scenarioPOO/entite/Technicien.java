package com.wj.poo.scenarioPOO.entite;

public class Technicien extends Employee {
	
	private final static double FACTEUR_UNITE = 5.0;
	private int unites;
	
	public Technicien() {
	}

	public Technicien(String nom, String prenom, int age, String date) {
		super(nom, prenom, age, date);
	}

	@Override
	public double calculerSalaire() {
		return FACTEUR_UNITE*unites;
	}
	
	@Override
	public String getTitre() {
		return "Le Technicien ";
	}

}
