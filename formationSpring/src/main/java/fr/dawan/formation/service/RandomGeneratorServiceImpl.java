package fr.dawan.formation.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService{
	
	final static int MINIMUM_FACTOR = 11;
	final static int MAXIMUM_FACTOR = 99;

	//Doit retourner un nombre aléatoire entre 1 et 99
	@SuppressWarnings("unused")
	@Override
	public int getGenerateRandomFactor() {
		
		if (MINIMUM_FACTOR >= MAXIMUM_FACTOR) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		
		Random r = new Random();
		return r.nextInt((MAXIMUM_FACTOR - MINIMUM_FACTOR) + 1) + MINIMUM_FACTOR;		
	
	}


	//Création RandomGeneratorServiceTest en premier

}
