package revisionCertif.chap4;


//Given the following method, which of the method calls return 2?
public class Q5 {

	public static int howMany(boolean b, boolean... b2) {
		return b2.length;
	}
	
	public static void main(String[] args) {
		System.out.println(howMany(true, true, false));
		System.out.println(howMany(true, new boolean[2]));
		System.out.println(howMany(true, new boolean[] {true, true, true}));
	}
	


}
