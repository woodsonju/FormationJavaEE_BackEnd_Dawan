package com.wj.poo.polymorphisme.application;

import java.util.Arrays;
import java.util.List;

import com.wj.poo.polymorphisme.entite.Utilitaire;
import com.wj.poo.polymorphisme.entite.Vehicule;
import com.wj.poo.polymorphisme.entite.Voiture;
import com.wj.poo.polymorphisme.enumeration.Motorisation;

public class Main {

	public static void main(String[] args) {
		Vehicule[] tabv = new Vehicule[3];  //initialisation du tableau
		tabv[0] = new Voiture(3, "couleur");  //1er objet voiture
		tabv[0].setMotorisation(Motorisation.DIESEL);
		tabv[1] = new Voiture();  //2eme objet voiture
		tabv[1].setNbKilometre(300000);
		tabv[2] = new Utilitaire();
		tabv[2].setNbKilometre(1000);
		
		for(Vehicule val: tabv) {
			System.out.println(val);
			System.out.println(val.isRentable());
		}
		
		System.out.println("\n********************Liste*******************************");
		//Transformation en liste 
		List<Vehicule> listVehicule = Arrays.asList(tabv);
		listVehicule.forEach(v -> {
			System.out.println("list et forEach : " + v);
			System.out.println(v.isRentable());
		});
	}

}
