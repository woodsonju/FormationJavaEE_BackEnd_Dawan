package com.wj.poo.polymorphisme.entite;

import com.wj.poo.polymorphisme.enumeration.Motorisation;

public class Utilitaire extends Vehicule {
	
	private int volume;

	public Utilitaire() {
		super();
	}

	public Utilitaire(String plaque, int nbKilometre, Motorisation motorisation, boolean disponible) {
		super(plaque, nbKilometre, motorisation, disponible);
	}


	public Utilitaire(String plaque, int nbKilometre, Motorisation motorisation, boolean disponible, int volume) {
		super(plaque, nbKilometre, motorisation, disponible);
		this.volume = volume;
	}

	
	public int getVolume() {
		return this.volume;
	}
	
	@Override
	public boolean isKilometreOk() {
		return getNbKilometre() < 200000;
	}

}
