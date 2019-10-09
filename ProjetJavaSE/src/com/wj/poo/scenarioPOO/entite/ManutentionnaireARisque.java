package com.wj.poo.scenarioPOO.entite;

public class ManutentionnaireARisque extends Manutentionnaire implements ARisque {

	public ManutentionnaireARisque() {
		super();
	}

	

	public ManutentionnaireARisque(String nom, String prenom, int age, String date, int heure) {
		super(nom, prenom, age, date, heure);
	}



	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}
	
	
}
