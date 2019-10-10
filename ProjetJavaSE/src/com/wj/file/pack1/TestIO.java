package com.wj.file.pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIO {

	public static void main(String[] args) {
		String path = "C:/FormationJavaProf/Projet1/src/Pack1";
		
		scanRep(path);
		
		//Appel méthode lecture
		try {
			lectureFichier(path + "/Exos.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Appel méthode écriture
		try {
			ecritureFichier(path + "/testFile.txt"); //Ecriture dans le fichier non existant
			lectureFichier(path + "/testFile.txt");  //Lecture du fichier existant
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			copyFichier(path + "/testFile.txt", path + "/testFileDest.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void scanRep(String path) {
		//Créer un objet File
		File f = new File(path);
		//Tester si le fichier existe
		if(f.exists()) {
			//Tester si c'est un repertoire
			if(f.isDirectory()) {
				//Stocker le contenu du REP dans un tableau
				File[] tabf = f.listFiles();
				//Lister le tableau
				for(File f1 : tabf) {
					if(f1.isFile())
						System.out.println("Fichier : " + f1.getName());
					else {
						System.out.println("Repertoire : " + f1.getName());
						scanRep(f1.getAbsolutePath());
					}
				} 
					
				} else {
					System.out.println("Fichier : " + f.getName());
			}
		} else {
			//Créeer le fichier s'il existe pas
			f.mkdir();
		}
			
	}
	
	
	/**
	 * *
	 * @param path
	 * @throws IOException
	 * 	Lecture de fichiers
	 */
	public static void  lectureFichier(String path) throws IOException {
		//Deux methodes pour lire: ligne par ligne ou binaire
		File f = new File(path);
		if(f.exists()) {
			FileReader fr = new FileReader(f); // Méthode de lecture par chaine de caractère, ligne par ligne
			BufferedReader br = new BufferedReader(fr); //Charger le fichier en memoire (Ouverture en mode lecture)
			String str = br.readLine();
			while(str != null) {
				System.out.println(str);
				str = br.readLine();
			}
			fr.close();
		} else {
			throw new IOException();
		}
	}
	
	
	/**
	 * 
	 * @param path
	 * @throws IOException
	 * Ecriture dans le fichier
	 */
	public static void ecritureFichier(String path) throws IOException {
		File f = new File(path);
		if(f.exists()) {
			FileWriter fw =  new FileWriter(f); //Ecriture par méthode chaines de caractères ligne par ligne
			BufferedWriter bw = new BufferedWriter(fw);  //charger le fichier dans la mémoire
			bw.write("Petit test pour les fichiers files");
			bw.close();
			fw.close();
		} else {
			f.createNewFile();
		}

	}
	
	/**
	 * 
	 * @param pathSrc
	 * @param pathTarget
	 * @throws IOException
	 * Methode binaire 
	 */
	public static void copyFichier(String pathSrc, String pathTarget) throws IOException {
		File f = new File(pathSrc);
		if(f.exists()) {
			FileInputStream fis = new FileInputStream(f); //lecture par méthode binaire
			FileOutputStream fos = new FileOutputStream(pathTarget);   //Fichier crée si il n'existe pas
			int tmp = fis.read();
			while(tmp != -1) {					//-1 veut dire qu'il n'y a plus de char à lire
				fos.write(tmp);
				//Affichage des CHAR associés aux valeurs numériques
				System.out.println(tmp + "(" + (char) tmp + ")");
				tmp = fis.read();			//je passe au caractère suivant
			}
			fis.close();
			fos.close();	
		} else {
			f.createNewFile();
		}
	}

}
