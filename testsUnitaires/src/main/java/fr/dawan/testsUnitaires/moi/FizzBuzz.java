package fr.dawan.testsUnitaires.moi;

public class FizzBuzz {

	public static String printNumber(int param) {
		if(param % 15 == 0)
			return "FizzBuzz";
		if(param % 3 == 0)
			return "Fizz";
		if(param % 5 == 0)
			return "Buzz";
		return String.valueOf(param);
	}
	
	public static void main(String[] args) {
		System.out.println(printNumber(100));
	}

}
