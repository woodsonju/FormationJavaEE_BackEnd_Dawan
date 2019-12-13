package fr.dawan.formationjpa;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import fr.dawan.formationjpa.dao.FormateurDAO;
import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formateur;
import fr.dawan.formationjpa.entities.Formation;
import junit.framework.TestCase;

public class FormateurTest extends TestCase {

	Formation formation1;
	Formation formation2;
	Formation formation3;


	Formateur formateur1;
	Formateur formateur2;
	Formateur formateur3;

	@Before
	public void setUp() throws Exception {
		formateur1 = new Formateur();
		formateur1.setEstInterne(true);
		formateur1.setMatricule(UUID.randomUUID().toString());  //Pour avoir un identifiant unique
		formateur1.setNom("Derkaoui");
		formateur1.setPrenom("Mohamed");

		formateur2 = new Formateur();
		formateur2.setEstInterne(true);
		formateur2.setMatricule(UUID.randomUUID().toString());
		formateur2.setNom("Lorent");
		formateur2.setPrenom("Christopher");

		formateur3 = new Formateur();
		formateur3.setEstInterne(true);
		formateur3.setMatricule(UUID.randomUUID().toString());
		formateur3.setNom("Zein");
		formateur3.setPrenom("Cham");

		// créer des formations (3)
		formation1 = new Formation();
		formation1.setCode("FOR-DEV001");
		formation1.setDuree(5);
		formation1.setNom("Java - JSE");
		formation1.setPrix(1999.99);

		formation2 = new Formation();
		formation2.setCode("FOR-DEV002");
		formation2.setDuree(5);
		formation2.setNom("Java - Spring MVC");
		formation2.setPrix(2999.99);

		formation3 = new Formation();
		formation3.setCode("FOR-DEV003");
		formation3.setDuree(3);
		formation3.setNom("Webmaster - initiation");
		formation3.setPrix(799.99);

	}


	@Test
	public void testCreate() {
		// associer des formations à des formateurs
		// et/ou associer des formateurs à des formations
		formateur2.addCompetences(formation1);		
		formateur2.addCompetences(formation2);

		// mettre à jour la base de données
		GenericDAO.create(formateur1);
		GenericDAO.create(formateur2);
		GenericDAO.create(formateur3);
	}


	@Test
	public void testFindById() {
		// on récupère le formateur ayant l'id 2
		Formateur formateur = GenericDAO.findById(Formateur.class, 2);
		
		System.out.println("Nb de compétences pour "  + formateur.getPrenom() + " "
				+ formateur.getCompetences().size());

		// Pour chaque formation comprise dans la liste de compétence du formateur
		for (Formation formation : formateur.getCompetences()) {
			System.out.println(formation);
		}
	}
	
	@Test
	public void testFindAll() {
		List<Formateur> formateurs = GenericDAO.findAll(Formateur.class);
		System.out.println("TOUS LES FORMATEURS");
		formateurs.forEach(System.out::println);
	}
	
	@Test
	public void testFindAll2() {
		List<Formateur> formateurs = GenericDAO.findAll(Formateur.class, 2, 5);
		System.out.println("LES FORMATEURS du 3ème au 5ème");
		formateurs.forEach(System.out::println);
	}
	
	@Test
	public void testFindByNameNativeSQL() {
		Scanner sc = getSaisir();
		String saisie = sc.nextLine();
		
		List<Formateur> formateurs = FormateurDAO.findByNameNativeSQL(saisie);
		System.out.println("Les formateurs dont le nom contient \"" + saisie +   "e\".");
		formateurs.forEach(System.out::println);
		
		sc.close();
	}
	
	
	@Test
	public void testFindByNameHQLConcat() {
		Scanner sc = getSaisir();
		String saisie = sc.nextLine();
		
		List<Formateur> formateurs = FormateurDAO.findByNameHQLConcat(saisie);
		System.out.println("Les formateurs dont le nom contient \"" + saisie +   "e\".");
		formateurs.forEach(System.out::println);
		
		sc.close();
	}
	
	@Test
	public void testFindByNameHQLParamater1() {
		Scanner sc = getSaisir();
		String saisie = sc.nextLine();
		
		List<Formateur> formateurs = FormateurDAO.findByNameHQLParamater1(saisie);
		System.out.println("Les formateurs dont le nom contient \"" + saisie +   "e\".");
		formateurs.forEach(System.out::println);
		
		sc.close();
	}
	
	@Test
	public void testFindByNameHQLNameParamater() {
		Scanner sc = getSaisir();
		String saisie = sc.nextLine();
		
		List<Formateur> formateurs = FormateurDAO.findByNameHQLNameParamater(saisie);
		System.out.println("Les formateurs dont le nom contient \"" + saisie +   "e\".");
		formateurs.forEach(System.out::println);
		
		sc.close();
	}
	
	@Test
	public void testFindByNameWithCriteria() {
		Scanner sc = getSaisir();
		String saisie = sc.nextLine();
		
		List<Formateur> formateurs = FormateurDAO.findByNameWithCriteria(saisie);
		System.out.println("Les formateurs dont le nom contient \"" + saisie +   "e\".");
		formateurs.forEach(System.out::println);
		
		sc.close();
	}


	private Scanner getSaisir() {
		System.out.println("Veuillez saisir un nom ou une partie de nom : ");
		Scanner sc = new Scanner(System.in);
		return sc;
	}

}
