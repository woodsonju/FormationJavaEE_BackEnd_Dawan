package com.wj.Serialisation;

public class Application {

	public static void main(String[] args) {
		Produit p = new Produit(1, "Ordinateur", 500.0);
		TestSerialisation.toBin(p, "toto");
		
		Produit p1 = new Produit();
		p1=TestSerialisation.fromBin("toto");
		System.out.println(p1);
	}

}
