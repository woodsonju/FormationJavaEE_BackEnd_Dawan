package com.wj.poo.polymorphisme.entite;

import com.wj.poo.polymorphisme.enumeration.Motorisation;

public class Voiture extends Vehicule {

	private int nbPlace;
	private String couleur;

	public Voiture() {
		super();
	}
	
	public Voiture(int nbPlace,String couleur) {
		super();
		this.nbPlace = nbPlace;
		this.couleur = couleur;
	}

	public Voiture(String plaque, int nbKilometre, Motorisation motorisation, boolean disponible, int nbPlace,
			String couleur) {
		super(plaque, nbKilometre, motorisation, disponible);
		this.nbPlace = nbPlace;
		this.couleur = couleur;
	}

	
	public Voiture(String plaque, int nbKilometre, Motorisation motorisation, boolean disponible) {
		super(plaque, nbKilometre, motorisation, disponible);
	}
	
	

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public boolean isKilometreOk() {
		switch (getMotorisation()) {
		case ESSENCE:
			return getNbKilometre() < 100000;
		case DIESEL:
			return getNbKilometre() < 150000;
		default:
			return getNbKilometre() < 60000;
		}
	}

}
