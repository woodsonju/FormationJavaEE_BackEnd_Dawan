package revisionCertif.chap4;

public class Q4 {

	public static void main(String[] args) {

	}

	//Var-args doit être le dernier paramètre 
	//Ici ça marche pas
//	public void morede( int...nums, String values) {}
	
	//Ici non plus : deux var ne sont pas permis dans le même méthode
//	public void morede(String... values,  int...nums) {}
	
	//Ici non plus
	//public void morede(String val, String... values,  int...nums) {}


	
	//Ici ça fonctionne
	public void morede(String values,  int...nums) {}
	


}
