package com.wj.string;

public class ClasseTest {

	public static void main(String[] args) {
		String s1 = "Bonjour";
		String s2 = "Bonjour";
		String s3 = new String("Bonjour");
		
		//Comparaison par reference
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		System.out.println(s1.equals(s3));  // Comparaison du contenu
		
		String str = "test";
		System.out.println(str.charAt(2));  
		
		//str.concat("e"); Faux : Chaine de caractère immutable une fois crée on ne peut pas la remplacer
		//Bonne pratique
		str = str.concat("e");	//concatenation avec une chaine
		System.out.println(str);
		
		//Garbage Collector : ramasse miettes)
		s2 = s3; //Pas d'objets à ramasser par le garbage collector
		s1=s3; //Un objet a ramassé par le garbase collector
		
		System.out.println("substring(1, 3) " + str.substring(1, 3));
		
		
		//StringBuilder: sont mutable par rapport aux chaine de caractère
		//Choisir plutot les StringBuilder quand on manipule beaucoup les caractères
		StringBuilder stb = new StringBuilder("test");
		StringBuilder stb2 = new StringBuilder("test");
		
		System.out.println("Comparaison refrence string builder : " + (stb == stb2));
		
		System.out.println("StringBuilder : " + stb.append("e"));
		
		System.out.println("6"+4+5);  //Commence par une chaine de caractère donc concaténation
		System.out.println(4+5+"7");  //Commence par une addition
		System.out.println(4+"3"+5);  //Commence par une concaténation  donc pas d'addition
		
		int x = 5 + 'A';   //Le code ASCII  de A vaut 65
		//int x = 5 + "A";	//erreur de compilation
		System.out.println("X= " +x);
		
		System.out.println("6"+5*4);  //precedence des opérateurs arithmétiques *, /, %, +, -
		System.out.println("6"+(5-4));  //Sans préciser avec parenthèses la priorité de la soustraction j'ai une erreur de compilation
		
		
	}

}
