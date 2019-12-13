package fr.dawan.formationjpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

/**
 * Pendant formation TDD
 * 
 * @author Juste Woodson
 */
public class FormationDaoTest {
	
	private Formation formation;
	
	private final String NOM_FORMATION = "Développement piloté par les tests en JAVA";
	private final String CODE_FORMATION = "FOR-TDD-JAVA";
	private final int DUREE_FORMATION = 3;
	private final double PRIX_FORMATION = 1799.99;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		formation = new Formation();
		formation.setNom(NOM_FORMATION);
		formation.setCode(CODE_FORMATION);
		formation.setPrix(PRIX_FORMATION);
		formation.setDuree(DUREE_FORMATION);
		GenericDAO.create(formation);
		//Tant que la formation n'est pas inséré en base, son id est égal à 0
		Assert.assertNotEquals(0, formation.getId());	
	}

	
	@After
	public void tearDown() throws Exception {
		GenericDAO.delete(Formation.class, formation.getId());
	}

	
	@Test
	public void findByIdTest() {
		Formation f = GenericDAO.findById(Formation.class, formation.getId());
		Assert.assertNotNull(f);	
		Assert.assertEquals(NOM_FORMATION, f.getNom());
		Assert.assertEquals(CODE_FORMATION, f.getCode());
		Assert.assertEquals(PRIX_FORMATION, f.getPrix(), 0.01);
		Assert.assertEquals(DUREE_FORMATION, f.getDuree());
	}

}
