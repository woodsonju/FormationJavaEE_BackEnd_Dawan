package fr.dawan.formationjpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FormateurTest.class, FormationTest.class, SessionFormationTest.class })
public class AllTests {

}
