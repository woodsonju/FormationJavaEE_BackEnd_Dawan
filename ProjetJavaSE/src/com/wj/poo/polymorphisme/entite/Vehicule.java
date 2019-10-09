package com.wj.poo.polymorphisme.entite;

import com.wj.poo.polymorphisme.enumeration.Motorisation;
import com.wj.poo.polymorphisme.interfaces.Rentable;


public abstract class Vehicule implements Rentable{
	
	private String plaque;
	private int nbKilometre;
	private Motorisation motorisation = Motorisation.ESSENCE;
	private boolean disponible = true;
	
	public Vehicule() {
		super();
	}

	public Vehicule(String plaque, int nbKilometre, Motorisation motorisation, boolean disponible) {
		super();
		this.plaque = plaque;
		this.nbKilometre = nbKilometre;
		this.motorisation = motorisation;
		this.disponible = disponible;
	}
	
	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public int getNbKilometre() {
		return nbKilometre;
	}


	public void setNbKilometre(int nbKilometre) {
		this.nbKilometre = nbKilometre;
	}

	public Motorisation getMotorisation() {
		return motorisation;
	}

	public void setMotorisation(Motorisation motorisation) {
		this.motorisation = motorisation;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Vehicule [plaque=" + plaque + ", nbKilometre=" + nbKilometre + ", motorisation=" + motorisation
				+ ", disponible=" + disponible + "]";
	}

	
	@Override
	public boolean isRentable() {
		return isKilometreOk() && disponible;
	}
	
	public abstract boolean isKilometreOk();

}
