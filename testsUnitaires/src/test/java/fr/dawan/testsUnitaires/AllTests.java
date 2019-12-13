package fr.dawan.testsUnitaires;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.dawan.testsUnitaires.moi.FizzBuzzTest;

@RunWith(Suite.class)
@SuiteClasses({ CalculatriceTest.class, DemoTestSuite.class, FibonacciTest.class, FizzBuzzTest.class })
public class AllTests {
	// On ne met rien ici !!!
}
