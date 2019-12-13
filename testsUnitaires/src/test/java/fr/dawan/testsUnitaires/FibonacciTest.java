package fr.dawan.testsUnitaires;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(Parameterized.class)
public class FibonacciTest {
	/*
	 * Liste des données à tester
	 *  Chaque élement de la liste (ex : {0, 0})
	 *  correspond aux paramètres d'une exécution du test
	 *  Par exemple : 
	 *  Avec {2, 1}, Le test sera éxcuté avec les paramètres 2 et 1
	 *  2 correspodant au paramètre d'entrée (@Parameter(0))
	 *  1 correspodant au paramètre de sortie (@Parameter(1))
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			//0112358
			{0,0}, {1,1}, {2,1}, {3,2}, {4,3}, {5,5}, {6,8}
		});
	}
	
	
	//Obligatoirement public 
	//@Parameter(0) => On peut ne pas mettre de parametre car par défaut le parameter est la première données 
	@Parameter//(0)
	public int donneeEnEntree;

	//Obligatoirement public 
	@Parameter(1)
	public int donneeEnSortie;

	@Test
	public void test() {
		System.out.println("Donnée en entrée : " + donneeEnEntree);
		Calculatrice calc = new Calculatrice();
		Assert.assertEquals(donneeEnSortie, calc.fibonacci(donneeEnEntree));
	}
	
	@Test(expected = RuntimeException.class)
	public void testNegatifValueException() {
		System.out.println("Donnée en entrée : " + donneeEnEntree);
		new Calculatrice().fibonacci(-1);
	}

}
