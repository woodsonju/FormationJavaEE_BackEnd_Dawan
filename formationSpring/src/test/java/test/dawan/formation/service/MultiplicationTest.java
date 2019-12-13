package test.dawan.formation.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.dawan.formation.domain.Multiplication;
import fr.dawan.formation.service.MultiplicationServiceImpl;
import fr.dawan.formation.service.RandomGeneratorServiceImpl;

public class MultiplicationTest {
	

	@Mock
	private RandomGeneratorServiceImpl randomGeneratorService;
	
	//Initialisation de mockito pour pouvoir utiliser le mock
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	//Mon test
	@Test
	public void createRandomMultiplicationTest() {
	
		//Ce test n'est pas donc unitaire
		//Given 
		//On simule randomGeneratorService en appelant getGenerateRandomFactor
		when(randomGeneratorService.getGenerateRandomFactor()).thenReturn(15, 20); 
		
		//When
		MultiplicationServiceImpl multiplicationService = new MultiplicationServiceImpl(randomGeneratorService);
		Multiplication multiplication = multiplicationService.createRandomMultiplication();
		
		//Then
		//On va utiliser ici les règles de gestion spécifiées pour déterminer les cas de test
		assertEquals(multiplication.getFactorA(), 15);
		assertEquals(multiplication.getFactorB(), 20);
		assertEquals(multiplication.getResultat(), 300);
		
	}
}
