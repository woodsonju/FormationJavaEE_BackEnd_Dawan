package com.wj.Init;

public class Tableaux2Dimensions {

	public static void main(String[] args) {

		/*
		 * Première façon de déclarer un tableau à 2D; Obligatoire : Initialisation du
		 * prémier tableau est obligatoire C'est un tableau dans un tableau
		 */
		int[][] tab2D = new int[2][];
		tab2D[0] = new int[2];
		tab2D[1] = new int[3];

		// Deuxième façon
		int[][] t2d = { { 1, 2 }, { 3, 4, 9 }, { 5, 6, 7, 8 } };
		System.out.println(t2d[1][0]);

		for (int i = 0; i < t2d.length; i++) {
			for (int j = 0; j < t2d[i].length; j++) {
				System.out.println("Lecture du tableau t2d : " + t2d[i][j]);
			}
		}

	}

}
