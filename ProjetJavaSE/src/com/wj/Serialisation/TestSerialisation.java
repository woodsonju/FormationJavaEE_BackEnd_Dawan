package com.wj.Serialisation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialisation {

	public static void toBin(Produit p, String cheminFichier) {

		try {
			FileOutputStream fos = new FileOutputStream(cheminFichier);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			/**
			 * Deuxième façon de la faire
			 * BufferedOutputStream bos = new BufferedOutputStream((new FileOutputStream(cheminFichier));	
			 */
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(p);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	}
	
	public static Produit fromBin(String cheminFichier) {
		Object o = null;
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(cheminFichier));
			ObjectInputStream ois = new ObjectInputStream(bis);
			o = ois.readObject();
			ois.close();
			return (Produit) o;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}
		
	}

}
