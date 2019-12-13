package fr.dawan.formation.service;

import fr.dawan.formation.domain.Multiplication;

public interface MultiplicationService {
	
	/**
	 * Méthode qui calcule la multiplication entre deux facteurs
	 * @return une multiplication
	 */
	public Multiplication createRandomMultiplication();
}
