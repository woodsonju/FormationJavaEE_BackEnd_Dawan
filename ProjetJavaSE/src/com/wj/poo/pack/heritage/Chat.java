package com.wj.poo.pack.heritage;

public class Chat extends Animal {
	
	public Chat() {
		super();
	}
	
	@Override
	public void emettreUnSon() {
		System.out.println("Miauler");
	}

	@Override
	public String toString() {
		return "Chat [Nom = " + getNom() + "]";
	}
	
	
	
}
