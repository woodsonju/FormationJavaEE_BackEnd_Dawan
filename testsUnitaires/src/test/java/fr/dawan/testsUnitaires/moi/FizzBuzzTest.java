package fr.dawan.testsUnitaires.moi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void should_print_1_when_given_1() {
		Assert.assertEquals("1", FizzBuzz.printNumber(1));
	}
	
	//un nombre est « Fizz » si il est multiple de 3 ou si il contient un « 3 »
	@Test
	public void should_print_Fizz_when_given_3() {	
		Assert.assertEquals("Fizz", FizzBuzz.printNumber(3));
	}
	
	//un nombre est « Buzz » si il est multiple de 5 ou si il contient un « 5 »
	@Test
	public void should_print_Buzz_when_given_5() {	
		Assert.assertEquals("Buzz", FizzBuzz.printNumber(5));
	}
	
	//un nombre est « FizzBuzz » si il est multiple de 3 et de 5
		@Test
		public void should_print_FizzBuzz_when_given_3and5() {	
			Assert.assertEquals("FizzBuzz", FizzBuzz.printNumber(15));
		}
}
