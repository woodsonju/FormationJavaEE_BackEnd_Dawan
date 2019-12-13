package fr.dawan.projet_maven1;

import org.junit.Test;

import fr.dawan.projet_maven1.Calcul;
import junit.framework.TestCase;

public class CalculTest extends TestCase {

	@Test
	public void testCalcul() {
		//assertions : fonctions pour tester des affirmations
		assertEquals(5, Calcul.somme(2,3));
		assertEquals(8, Calcul.somme(5,3));

	}

}
