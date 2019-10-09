package com.wj.poo.scenarioPOO.entite;

/**
 * @author JUSTE Woodson
 * chiffreDaffaire est un  attribut qui est commun à deux classes (Vendeur et Representant)
 * On factorise cette attribut et on le met dans une classe (abstraite)
 * Quand une classe est abstraite on est pas obligé de redefinir la méthode
 * de la classe dont il hérite. 
 * Donc ici, calculerSalaire() n'est pas obligée d'être rédefinie dans la classe Commercial.
 * Par Contre, si on enlève abstraite  de la classe Commercial, on est obligé de redefinir 
 * la méthode calculerSalaire()
 */
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
