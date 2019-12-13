package test.dawan.formation.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formation.service.RandomGeneratorServiceImpl;

public class RandomGeneratorServiceTest {
	
	private RandomGeneratorServiceImpl randomGeneratorService;
	
	@Before
	public void setup() {
		randomGeneratorService = new RandomGeneratorServiceImpl();
	}
	
	@Test
	public void generateRandomFactoisBetwenExpectedLimtsTest() {
		//Soit un bon échantillon de facteurs générés aléatoirement
		//Given
		
		//When
		List<Integer> randomFactors = IntStream.range(0, 1000)
				.map(i -> randomGeneratorService.getGenerateRandomFactor())
				.boxed().collect(Collectors.toList());
		
		//Then
		assertThat(randomFactors).isSubsetOf(IntStream.range(11, 100).boxed().collect(Collectors.toList()));
	}
	
	@After
	public void postTest() {
		randomGeneratorService = null;
	}
}
