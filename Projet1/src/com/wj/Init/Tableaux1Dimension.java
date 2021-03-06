package com.wj.Init;

public class Tableaux1Dimension {

	public static void main(String[] args) {
		
		//Tableaux à une dimension
		int[] tab = new int[3]; //Prémière façon de déclarer un tableau
		tab[0]=1;
		tab[1]=2;
		tab[2]=3;
		
		int[] tab2 = {4, 5, 6, 2, 8, 9};  // deuxième façon de déclarer un tableau
		
		//boucle normal
		
		
		//autre syntaxe 
		for(int i: tab2)
			System.out.println(i);	
		
		System.out.println("minimum : " + minimum(tab2));
		
		System.out.println("maximum : " + maximum(tab2));
		
		System.out.println("moyenne : " + moyenne(tab2));

		
	}
	
	//Méthode min : retourne la plus petite valeur du tableau
	public static int minimum(int[] tableau) {
		int min = tableau[0];
		for(int i=0; i<tableau.length; i++) {
			if(min>tableau[i])
				min = tableau[i];
		}
		return min;
	}
	
	
	//Méthode max : retourne la plus grande valeur du tableau
		public static int maximum(int[] tableau) {
			int max = tableau[0];
			for(int i=0; i<tableau.length; i++) {
				if(max<tableau[i])
					max = tableau[i];
			}
			return max;
		}
		
		
		//moyenne des élelement du tableau
		public static int moyenne(int[] tableau) {
			int somme = 0;
			for(int i=0; i<tableau.length; i++) {
				somme +=tableau[i];
			}
			
			return somme/tableau.length;
		}
	

}
