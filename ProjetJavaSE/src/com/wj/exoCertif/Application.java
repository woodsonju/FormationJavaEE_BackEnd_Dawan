package com.wj.exoCertif;

public class Application {
	
	int x;
	static int st;
	
	//bloc d'initialisation
	//un bloc non static peut initialiser tout type de variables (static ou non)
	{
		st = 10;
		x=15;
	}
	
	
	//bloc d'initialisation
	//un bloc static ne peut initialiser que des variables static
	static
	{
		st=40;
		x=20;
	}
	
	//Une méthode static n'accèpte que des variables static
	static void maMethode() {
		//On ne peut définir des variables static que pour une classe
		//Une méthode ne peut définir que des variables locales initialisées
		static int y=15; 
		x=20;
	}

}
