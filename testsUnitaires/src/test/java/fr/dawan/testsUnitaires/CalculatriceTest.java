package fr.dawan.testsUnitaires;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exception.DivisionParZeroException;
import junit.framework.Assert;

public class CalculatriceTest {
	
	/**
	 * @BeforeClass permet d'initialiseer notre classe de tests
	 */
	@BeforeClass
	public static void initClass() {
		System.out.println("BEFORE CLASSE");
	}
	
	/**
	 * AfterClass permet d'effectuer un nettoyage en fin de tests
	 * Exemple: Réinitialisation de BDD, modification de configuration...
	 * Sera exécuté une seule fois en fin de classe
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("AFTER CLASSE");
	}

	/**
	 * Code appelé AVANT CHAQUE méthode de test 
	 * @throws Exception
	 */
	@Before
	//@BeforeEach => junit 5
	public void setUp() throws Exception {
		// On peut tout à fait inclure des Assert dans ces methodes
		System.out.println("Appel AVANT chaque test");
	}

	
	/**
	 * Code appelé APRES CHAQUE méthode de test 
	 * @throws Exception
	 */
	@After
	//@AfterEach => junit 5
	public void cleanUp() {
		System.out.println("Appel APRES chaque test");
	}

	
	@Test
	public void additionnerTest() {
		System.out.println("additionnerTest");
		//croix bleue : valeur non attendue

		//croix rouge : exception
		//fail("Not yet implemented");

		//1ère étape : du code qui ne compile
		//ce que l'on souhaite faire	
		// 2ème etape : On fait en sorte que le code compile
		//RIEN DE PLUS
		Calculatrice calc = new Calculatrice();
		long resultat = calc.additionner(2, 3);

		//A la prémière erreur le teste s'arrête
		//Assert.assertEquals(0,  resultat);

		//3ème étape : faire juste les corrections nécessaires 
		// ou les implémentations permettant de faire en sorte que ça fonctionne
		Assert.assertEquals(5, resultat);
		Assert.assertEquals(22, calc.additionner(-3, 25));

		Assert.assertEquals(2147483648L, calc.additionner(Integer.MAX_VALUE, 1));

		//Assert.assertEquals(Integer.MAX_VALUE+1, calc.additionner(Integer.MAX_VALUE, 1));

	}


	@Test
	public void diviserTest() {
		System.out.println("divisionTest");
		Calculatrice calc = null;
		//Pour vérifier si un objet est null
		Assert.assertNull(calc);

		calc = new Calculatrice();
		//Pour vérifier si un objet n'est pas null
		Assert.assertNotNull(calc);

		//Assert.assertEquals(2d, calc.diviser(6, 3));

		Assert.assertEquals(2.0, calc.diviser(6, 3));
		//Comparaison de doubles, 3ème paramètre : 
		//précisin après la virgule
		Assert.assertEquals(2.5, calc.diviser(5, 2), 0.1);
		Assert.assertEquals(-0.333,  calc.diviser(-1, 3), 0.001);

	}

	//On attend une DivisionParZeroException
	//Le test fonctionnera (vert) si on  a cette erreur
	//Echouera si on a une autre erreur ou pas d'erreur
	@Test(expected = DivisionParZeroException.class)
	public void divisionParZeroTest() {
		System.out.println("DivisionParZeroTest");
		Calculatrice calc = new Calculatrice();
		calc.diviser(5, 0);
		Assert.assertEquals(Double.POSITIVE_INFINITY,  calc.diviser(7, 0), 0.001);

	}


}
