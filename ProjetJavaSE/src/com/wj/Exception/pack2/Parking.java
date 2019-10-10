package com.wj.Exception.pack2;

public class Parking {
	
	private Voiture[] tabVoiture = new Voiture[5]; //parking de 5 places
	private int cpt = 0;
	
	public void garerVoiture(Voiture voiture) throws ParkingPleinException {
		
		if(cpt<5) {
			tabVoiture[cpt] = voiture;
			cpt++;
		} else 
			throw new ParkingPleinException();
			
	}
	
}
