package com.wj.Exception.pack2;

public class ParkingPleinException extends Exception {

	//Appeler le constructeur de la classe mère
	public ParkingPleinException() {
		super("Il n'y a plus de place sur le parking");
	}
	
}
