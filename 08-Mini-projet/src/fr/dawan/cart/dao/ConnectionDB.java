package fr.dawan.cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
	
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
       
    	Connection connection = null;
    	
        try {
                
            Properties p = new Properties();
            
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/application.properties") );
            
                Class.forName( p.getProperty("driver") );
            connection = DriverManager.getConnection(
                            p.getProperty( "url" ) , 
                            p.getProperty("user") , 
                            p.getProperty("psw")
            );
        
            return connection;        

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JBDC non trouvé");
            e.printStackTrace();
            return null;

        } catch (Exception e) {
            System.out.println("Problème de connexion à la base de données");
            e.printStackTrace();
            return null;
        }
    }


}
