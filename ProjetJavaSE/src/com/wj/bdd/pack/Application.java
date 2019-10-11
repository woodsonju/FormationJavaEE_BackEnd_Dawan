package com.wj.bdd.pack;

import java.sql.Connection;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		try {
			Connection cnx = ConnexionBDD.getConnection();
			List<Produit> list = ProduitDAO.getAll(cnx);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//Définir les paramètre de la méthode saveProduit
		Produit p = new Produit(3, "Ecran HP", 120.0);
		
		try {
			Connection cnx = ConnexionBDD.getConnection();
			//Appel de la méthode dinsertion d'un Produit
			ProduitDAO.saveProduit(p, cnx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Appel de la méthode deleteById
		try {
			Connection cnx = ConnexionBDD.getConnection();
			ProduitDAO.deleteProduit(1, cnx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		try {
			Connection cnx = ConnexionBDD.getConnection();
			//Appel de la méthode findByID
			Produit p2 = ProduitDAO.findById(2, cnx);
			System.out.println("Produit ayant id=2 : " +p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//appel méthode update
		try {
			Connection cnx = ConnexionBDD.getConnection(); //ouverture du connexion
			Produit p3 = ProduitDAO.findById(2, cnx);  //fermeture du connexion
			p3.setDescription("Ecran msi");
			p3.setPrix(150.0);
			//Nouvel objet connexion : Reouverture du connexion car elle a été fermée par la méthode findById
			Connection cnx1 = ConnexionBDD.getConnection(); 
			ProduitDAO.updateProduit(p3, cnx1);
			System.out.println("Produit ayant id=2 : " +p3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
