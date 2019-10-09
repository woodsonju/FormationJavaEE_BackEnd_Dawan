package com.wj.poo.scenarioPOO.entite;

public class Manutentionnaire extends Employee {
	 //Concerne tous les objets
	private final static double SALAIRE_HORAIRE = 65;
	//Seulement que pour un objet, car le nombre d'heure est différent pour chaque manutentionnaire
	private int heures; 
	
	public Manutentionnaire() {
	}
	
	public Manutentionnaire(String nom, String prenom, int age, String date, int heures) {
		super(nom, prenom, age, date);
		this.heures = heures;
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
