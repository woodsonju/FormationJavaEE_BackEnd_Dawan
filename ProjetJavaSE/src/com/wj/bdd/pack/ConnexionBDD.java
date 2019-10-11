package com.wj.bdd.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnexionBDD {
	
	public static Connection getConnection() throws Exception{
		//Objet Properties pour récuperer les valeurs du fichier conf.properties
		Properties p = new Properties();
		
		//Etablir la connexion
		p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conf.properties"));
		
		//charger le driver
		Class.forName(p.getProperty("driver"));
		
		//Créer l'objet connexion
		Connection cnx = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
	
		return cnx;
	}
	
	
	
}
