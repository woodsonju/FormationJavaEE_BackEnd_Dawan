package com.wj.poo.scenarioPOO.entite;

public abstract class Employee {
	
	private String nom;
	private String prenom;
	private int age;
	private String date;
	
	public Employee() {
	
	}
	
	public Employee(String nom, String prenom, int age, String date) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date = date;
	}
	
	public abstract double calculerSalaire();

	public String getTitre() {
		return "L'employée ";
	}
	
	public String getNom() {
		return getTitre() + prenom + " " + nom;
	}

}
