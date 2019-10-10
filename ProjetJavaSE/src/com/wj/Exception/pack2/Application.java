package com.wj.Exception.pack2;

public class Application {

	public static void main(String[] args) {
		Parking parc = new Parking();
		
		try {
			parc.garerVoiture(new Voiture());
			parc.garerVoiture(new Voiture());
			parc.garerVoiture(new Voiture());
			parc.garerVoiture(new Voiture());
			parc.garerVoiture(new Voiture());
			parc.garerVoiture(new Voiture());
		} catch (ParkingPleinException e) {
			e.printStackTrace();
		}		
		
		try {
			garerVoiture(12);
		} catch (MonException e) {
			e.printStackTrace();
		}
	}
	
	static void garerVoiture(int nbVoitureGarer) throws MonException{
		int placeParking = 10;
		if(nbVoitureGarer > placeParking)
			throw new MonException("Plus de places sur le parking!!!!");
	}


}
