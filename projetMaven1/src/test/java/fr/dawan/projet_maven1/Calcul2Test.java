package fr.dawan.projet_maven1;

import org.junit.Test;

import fr.dawan.projet_maven1.Calcul2;
import junit.framework.TestCase;

public class Calcul2Test extends TestCase {

	@Test
	public void testMultiplier() {
		assertEquals(10, Calcul2.multiplier(5, 2));
		assertEquals(100, Calcul2.multiplier(10, 10));
	}

}
