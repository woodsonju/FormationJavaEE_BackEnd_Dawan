package com.wj.poo.pack.heritage;

public class Chien extends Animal {
	private String race;

	public Chien() {
		super();
	}

	public Chien(String race) {
		super();
		this.race = race;
	}
	
	public void manger() {
		System.out.println("Je mange de la viande");
	}
	
}
