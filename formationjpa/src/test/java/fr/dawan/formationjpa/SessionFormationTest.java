package fr.dawan.formationjpa;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import fr.dawan.formationjpa.dao.FormationDAO;
import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;
import fr.dawan.formationjpa.entities.SessionFormation;
import junit.framework.Assert;
import junit.framework.TestCase;

public class SessionFormationTest extends TestCase{

	Formation formationJPA;
	SessionFormation sessionNovembre;
	SessionFormation sessionDecembre;

	@Before
	public void setUp() throws Exception {
		formationJPA = new Formation();
		formationJPA.setCode("FOR-DEV002");
		formationJPA.setDuree(2);
		formationJPA.setNom("GIT");
		formationJPA.setPrix(999.99);

		sessionNovembre = new SessionFormation();
		sessionNovembre.setDateDebut(LocalDate.of(2020, Month.JANUARY, 2));
		sessionNovembre.setNbPlaceMaxi(15);
		sessionNovembre.setNbPlace(12);
		sessionNovembre.setFormation(formationJPA);

		sessionDecembre = new SessionFormation();  // Etat : détachée
		sessionDecembre.setDateDebut(LocalDate.of(2019, Month.DECEMBER, 2));
		sessionDecembre.setNbPlaceMaxi(15);
		sessionDecembre.setNbPlace(10);
		sessionDecembre.setFormation(formationJPA);
	}


	// **********************************************************
	// PREMIERE TENTATIVE
	// *********************************************************
//	@Test @Ignore
//	public void testCreateV1() {
//
//		//GenericDAO.create(formationJPA);
//		// avec cascade.PERSIST, pas besoin d'insérer la formation 
//		// avant d'insérer la session (la session s'en chargera)
//		// on tente d'insérer la session de novembre, 
//		// avec le cascade persist formationJPA est aussi insérée
//		GenericDAO.create(sessionNovembre); 
//
//		// on tente d'insérer la session de décembre, 
//		// avec le cascade persist formationJPA est aussi insérée
//		// sauf qu'il existe déjà, donc qu'il a un id, et qu'il est détaché
//		// donc : EXCEPTION, donc, pas d'insertion
//		GenericDAO.create(sessionDecembre);
//
//		// Le nombre session à partir de l'objet formation en mémoire
//		System.out.println("nombre de sessions dans la formation JPA : " 
//				+ formationJPA.getSessions().size());
//
//		System.out.println("id de la formation : " + formationJPA.getId());
//
//		// récupération de la formation correspondante en base de données
//		Formation formationEnBDD = 
//				GenericDAO.findById(Formation.class,
//						formationJPA.getId()); 
//		// détaché, mais qui vient de la base de données
//		// on a un fetch eager sur sessions
//
//
//		// Le nombre session à partir de l'objet formation provenant de la base de données
//		System.out.println("nombre de sessions dans la formation JPA : " 
//				+ formationEnBDD.getSessions().size());
//	}


	

	/**
	 * DEUXIEME TENTATIVE
	 * Après modification des règles de cascade
	 * dans Formation et SessionFormation
	 */
	@Test
	public void testCreateV2() {

		//On va sauvegarder la formation, et laisser les cascades créer les sessions 
		formationJPA.addSessions(sessionNovembre);
		formationJPA.addSessions(sessionDecembre);

		GenericDAO.create(formationJPA);

		//Le nombre sessions à partir de l'objet formation en mémoire
		System.out.println("nombre de sessions dans la formation JPA : " 
				+ formationJPA.getSessions().size());

		Formation formationEnBDD = GenericDAO.findById(Formation.class, formationJPA.getId());


		Assert.assertNotNull(formationEnBDD);

		//Le nombre de session à partir de l'objet formation provenant de la base de données
		System.out.println("nombre de sessions dans la formation JPA : " 
				+ formationEnBDD.getSessions().size());

	}
	
	/**
	 * TROISIEME TENTATIVE
	 */
	@Test
	public void testCreateV3() {
		formationJPA.addSessions(sessionNovembre);
		formationJPA.addSessions(sessionDecembre);
		FormationDAO.createFormation(formationJPA);
		Formation formationEnBDD = GenericDAO.findById(Formation.class, formationJPA.getId());
		System.out.println(formationEnBDD);
		assertNotNull(formationEnBDD);
		assertEquals(999.99, formationEnBDD.getPrix());
	}

}
