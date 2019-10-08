package com.wj.poo.pack.heritage;

public class Application {

	public static void main(String[] args) {
		
		Chat c = new Chat();
		c.getNom();
		c.emettreUnSon();
		System.out.println(c);
		
		Chien ch = new Chien();
		Animal a1 = new Chien();
		Animal a2 = new Chien();

	}

}
