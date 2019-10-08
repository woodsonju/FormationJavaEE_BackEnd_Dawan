package com.wj.poo.pack;

public class Application {
	
	public static void main(String[] args) {
		Voiture voiture = new Voiture();
		voiture.setMarque("Renault");
		voiture.setModele("clio");
		voiture.setVitesse(100);
		System.out.println("Voiture1 : " + voiture);
		
		
		Voiture voiture2 = new Voiture("Peugeot", "207 HDI", 50);
		System.out.println("Voiture 2 : " + voiture2);
		
		System.out.println("Nombre d'instanciation : " + Voiture.compteur);
		
	}

}
