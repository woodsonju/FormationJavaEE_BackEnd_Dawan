package com.wj.poo.scenarioPOO.entite;

public class Vendeur extends Commercial {
	
	//static car tous les objets vendeurs vont être concernés
	private final static double POURCENT_VENDEUR = 0.2;
	private final static double BONUS_VENDEUR = 400;

	public Vendeur() {
		super();
	}

	public Vendeur(String nom, String prenom, int age, String date, double chiffreDaffaire) {
		super(nom, prenom, age, date, chiffreDaffaire);
	}


	@Override
	public double calculerSalaire() {
		return getChiffreDaffaire()*POURCENT_VENDEUR+BONUS_VENDEUR;
	}
	
	@Override
	public String getTitre() {
		return "Le vendeur ";
	}
}
