package fr.dawan.formation.service;

import fr.dawan.formation.domain.Multiplication;

/**
 * Classe qui calcule une multiplication aléatoire
 * @author Admin stagiaire
 *
 */
public class MultiplicationServiceImpl implements MultiplicationService{
	
	/**
	 * Création d'une dépendance entre deux classes
	 * @return
	 */
	private RandomGeneratorServiceImpl randomGeneratorService;
	
	/**
	 * Instanciation d'une classe à chaque construction = rupture de la règle Single Responsability
	 * @return
	 */
//	public MultiplicationService(RandomGeneratorService randomGeneratorService) {
//		super();
//		this.randomGeneratorService = new RandomGeneratorService();
//	}
	
	/**
	 * Injection par autowired
	 * @return
	 */
	public MultiplicationServiceImpl(RandomGeneratorServiceImpl randomGeneratorService) {
		super();
		//Avant on avait mis new mais maintenant c'est Spring qui le fait (voir beans.xml ligne 61)
		this.randomGeneratorService = randomGeneratorService;
	}
	
	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.getGenerateRandomFactor();
		int factorB = randomGeneratorService.getGenerateRandomFactor();
		return new Multiplication(factorA, factorB);
	}


	
	
	
}
