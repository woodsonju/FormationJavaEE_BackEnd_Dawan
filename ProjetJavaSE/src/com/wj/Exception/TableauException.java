package com.wj.Exception;

public class TableauException {

	public static void main(String[] args) {
		int[] tab = new int[5]; // initialisation du tableau
		
		try {
			tab[0] = 1;
			tab[1] = 10;
			tab[2] = 20;
			tab[3] = 30;
			tab[4] = 40;
			tab[5] = 40;
			
			String str = null;
			System.out.println(str.length());
			//Capture de l'exception de String null
		} catch(NullPointerException e ) {
			System.out.println("Reference null");
		//Capture de l'exception de dépassement de capacité du tableau
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Dépassement de capacité");
		} finally {
			System.out.println("Bloc finally");
		}


	}

}
