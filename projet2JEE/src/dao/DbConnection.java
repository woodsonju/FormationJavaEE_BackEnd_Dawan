package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DbConnection {
	
	public static Connection getConnection() throws Exception {
		
		//Objet java permmetant de lire le fichier de conf 
		Properties p = new Properties();
		
		//InputStream permettra de lire le fichier application.properties
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
		
		//Charge l'InputStream dans le properties
		p.load(in);
		
		//Fermeture du fichier
		in.close();
		
		//Chargememnt du driver (jar) my-sql
		Class.forName(p.getProperty("driver"));
		
		//Etablir la connexion
		Connection cnx = DriverManager.getConnection(p.getProperty("url"),
					p.getProperty("user"),
					p.getProperty("pwd"));
		
		return cnx;
	}
	
	
	
	

}
