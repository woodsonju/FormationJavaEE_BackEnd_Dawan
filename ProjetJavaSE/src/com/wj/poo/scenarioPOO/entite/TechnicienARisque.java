package com.wj.poo.scenarioPOO.entite;

public class TechnicienARisque extends Technicien implements ARisque {

	public TechnicienARisque() {
		super();
	}

	

	public TechnicienARisque(String nom, String prenom, int age, String date, int unites) {
		super(nom, prenom, age, date, unites);
	}



	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}
	
	
}
