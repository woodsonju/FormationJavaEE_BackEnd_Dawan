package com.wj.poo.scenarioPOO.entite;

public class Representant extends Commercial {
	
	private final static double POURCENT_REPRESENTANT = 0.2;
	private final static double BONUS_REPRESENTANT = 800;
	
	public Representant() {
		super();
	}

	public Representant(String nom, String prenom, int age, String date, double chiffreDaffaire) {
		super(nom, prenom, age, date, chiffreDaffaire);
	}

	@Override
	public double calculerSalaire() {
		return getChiffreDaffaire()*POURCENT_REPRESENTANT + BONUS_REPRESENTANT;
	}

	@Override
	public String getTitre() {
		return "Le representant ";
	}
	
}
