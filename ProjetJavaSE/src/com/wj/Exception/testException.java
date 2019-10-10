package com.wj.Exception;

public class testException {
	public static void main(String[] args) {
		
		int x = 10;
		
		//try -- essaye de faire l'exception
		try {
			System.out.println(x/0);
			//catch -- Capture et traitement de l'exception
		} catch( ArithmeticException e) {
			System.out.println("Erreur division par zéro !!!  " + e.getMessage());
			//Finally bloc optionnel qui s'execute à tous les coups
		} finally {
			System.out.println("Bloc finally");
		}
		
		System.out.println("Après le finally");
	}
}
