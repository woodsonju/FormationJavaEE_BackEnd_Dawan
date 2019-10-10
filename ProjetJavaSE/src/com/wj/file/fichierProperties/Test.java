package com.wj.file.fichierProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
	
	public static void main(String[] args) {
		
		//Création d'un fichier properties
		String path = "C:/FormationJavaProf/Projet1/src/Pack1/login.properties";
		try {
			FileOutputStream fos = new FileOutputStream(path);
			Properties p = new Properties();
			p.put("login", "admin");
			p.put("mdp", "password");
			p.store(fos, "User et pass de la base de données DEV");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//Lecture d'un ficier properties
		try {
			FileInputStream fis = new FileInputStream(path);
			Properties pr = new Properties();
			pr.load(fis);
			System.out.println(pr.get("mdp"));
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
