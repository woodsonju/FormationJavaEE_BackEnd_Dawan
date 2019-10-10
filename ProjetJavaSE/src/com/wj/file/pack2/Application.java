package com.wj.file.pack2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Application {

	public static void main(String[] args) {
		
		/**
		 * Sérialisation de l'objet adresse
		 */
		String path = "C:/FormationJavaProf/Projet1/src/Pack1/adresse.txt";
		Adresse adr = new Adresse("Place Occitane", "Toulouse", 31000);
		try {
			//Chemin du fichier où sera stocké l'adresse
			FileOutputStream fos = new FileOutputStream(path);
			
			//stream de sortie de l'objet adresse
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Ecriture du fichier
			oos.writeObject(adr);
			
			oos.close();
			fos.close();
		} catch(FileNotFoundException e) {
			System.out.println("Le fichier n'existe pas");
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		
		/**
		 * Désérialisation
		 */
		Object o;
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = ois.readObject();
			if(o instanceof Adresse) {			//Est ce que l'objet est de type adresse
				Adresse adr2 = (Adresse) o;			//Caster l'objet de type classe mère (supérieur) dans un type inférieur de type adresse
				System.out.println(adr2.getVoie());
				System.out.println(adr2);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Le fichier n'existe pas");
		} catch(ClassNotFoundException e) {
			System.out.println("Le fichier n'existe pas");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
