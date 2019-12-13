package fr.dawan.testsUnitaires;

import exception.DivisionParZeroException;

/**
 * @author Admin stagiaire
 *
 */
public class Calculatrice {

	public static long additionner(int param1, int param2) {
		return (long)param1 + param2;
	}

	public double diviser(int param1, int param2) {	
		if(param2 == 0)
			throw new DivisionParZeroException();
		return (double)param1/param2;
	}
	
	/**
	 * Methode recursice
	 *  u0 = u1 = 1
	 *  un = un-2 + un-1    pour n > 1
	 * @param a
	 * @return
	 */
	public int fibonacci(int a) {
		int resultat = 0;
		
		if(a < 0)
			throw new RuntimeException("Chiffres négatifs interdits !");
		else if(a <= 1)
			return a;
		else
			resultat = fibonacci(a-1) + fibonacci(a-2);
		return resultat;
	}
	
}
