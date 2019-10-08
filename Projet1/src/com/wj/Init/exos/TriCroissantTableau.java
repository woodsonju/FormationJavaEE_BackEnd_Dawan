package com.wj.exos;

public class TriCroissantTableau {

	public static void main(String[] args) {
		//tri tableau
		int[] tab = {5, 2, 9, 10, 1};
		triCroissant(tab);
		for(int val : tab) {
			System.out.println(val);
		}
	}
	
	
	public static void triCroissant(int[] tableau) {
		int tmp = 0;
		boolean permut;
		int longueur = tableau.length;
		do {
			 permut = false;
			 for(int i=0; i<longueur-1; i++) {
				 if(tableau[i] > tableau[i+1]) {
					tmp =  tableau[i];
					 tableau[i] = tableau[i+1];
					 tableau[i+1] = tmp;
					 permut = true; 
				 }
			 }
		} while(permut);
	}
	
}
