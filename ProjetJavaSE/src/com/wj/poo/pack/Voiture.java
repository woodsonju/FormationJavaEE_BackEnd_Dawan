package com.wj.poo.pack;

public class Voiture {
	
	//Variables d'instance forment la carte d'identité d'un objet
	private String marque;
	protected String modele;
	private int vitesse = 10;
	
	//Variable de classe communes à toutes les instances de la classe
	static int compteur;
	
	
	/*
	 * Le constructeur est une méthode public qui porte le nom de la classe
	 * Son rôle: initialiser les attributs
	 * constructeur sans paramètre
	 */
	public Voiture() {
		this.compteur++;
	}

	//Constructeur avec paramètres
	public Voiture(String marque, String modele, int vitesse) {
		this(); //appelle le constructeur par défaut de la même classe
		this.marque = marque;
		this.modele = modele;
		this.vitesse = vitesse;
	}

	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}


	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", modele=" + modele + ", vitesse=" + vitesse + "]";
	}
		
	
}
