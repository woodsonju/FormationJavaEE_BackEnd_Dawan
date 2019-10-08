package com.wj.poo.pack.heritage;

public class Animal {
	
	private String nom;

	public Animal() {
		super();
	}

	public Animal(String nom) {
		super();
		this.nom = nom;
	}

	public void emettreUnSon() {
		System.out.println("Classe animal");
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Animal [nom=" + nom + "]";
	}

	
}
