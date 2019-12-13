package fr.dawan.formationjpa;

import org.junit.Before;
import org.junit.Test;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;
import junit.framework.TestCase;
/**
 * @author JUSTE Woodson
 */
public class FormationTest extends TestCase {

	Formation formation;

	@Before
	public void setUp() throws Exception {
		formation = new Formation();

		formation.setCode("FOR-DEV001");
		formation.setDuree(5);
		formation.setNom("Java - JPA / Hibernate");
		formation.setPrix(1999.99);
	}


	@Test
	public void testCreate() {
		Formation f = GenericDAO.create(formation);
		System.out.println(f);
		assertEquals("FOR-DEV001", formation.getCode());

	}
	
	@Test 
	public void testFindById() {
		Formation f = GenericDAO.findById(Formation.class, 1);
		System.out.println(f);
		assertEquals("FOR-DEV001", formation.getCode());
		assertEquals("Java - JPA / Hibernate", formation.getNom());
	}
	
	@Test
	public void testUpdate() {
		formation.setPrix(799.95);
		formation.setDuree(2);
		GenericDAO.update(formation);
		assertEquals(799.95, formation.getPrix());
		assertEquals(2, formation.getDuree());
	}
	
	@Test
	public void testUpdateIdPositive() {
		//Tester le cas où ça marche pas
		GenericDAO.update(formation);
	
	}
	
//	@Test @Ignore
//	public void testDelete() {	
//		GenericDAO.delete(Formation.class, 12);
//		Formation f = GenericDAO.findById(Formation.class, 12);
//		assertNull(f);
//	}

}





//private EntityManagerFactory  entityManagerFactory;
//private EntityManager entityManager;
//private EntityTransaction entityTransaction;



//try {
//entityManagerFactory = Persistence.createEntityManagerFactory("formationjpa");
//entityManager = entityManagerFactory.createEntityManager();
//
//Formation formation = new Formation();
//formation.setCode("FOR-DEV001");
//formation.setDuree(5);
//formation.setNom("Java - JPA / Hibernate");
//formation.setPrix(1999.99);
//
//entityTransaction = entityManager.getTransaction();
////Début de la transaction
//entityTransaction.begin();
////On fait quelque des truc
//entityManager.persist(formation);
////On commit tout ce qui s'est fait dans la transaction
//entityTransaction.commit();
//
//assertTrue(true);
//} catch (Exception e) {
//fail(e.getMessage());
//e.printStackTrace();
////En cas D'erreur on effectue un rollback
//entityTransaction.rollback();
//}