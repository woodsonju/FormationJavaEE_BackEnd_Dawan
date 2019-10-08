package com.wj.poo.scenarioPOO.entite;

public class Manutentionnaire extends Employee {
	private final static double SALAIRE_HORAIRE = 65;
	private int heures;
	
	public Manutentionnaire() {
	}
	
	public Manutentionnaire(String nom, String prenom, int age, String date) {
		super(nom, prenom, age, date);
	}

	@Override
	public double calculerSalaire() {
		return SALAIRE_HORAIRE*heures;
	}
	
	@Override
	public String getTitre() {
		return "Le Manutentionnaire ";
	}
}
