package com.wj.bdd.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mysql.cj.xdevapi.Result;

public class ProduitDAO {
	
	/**
	 * Un DAO (direct object acces contient les differentes opération qu'on effectue sur une base de données
	 * nommée aussi CRUD - Create Read Update Delete
	 */
	
	/**
	 * 1 - Créer la table 
	 * 2 - Installer le driver
	 * 3 - Classe pour établir la connexion
	 * 4 - Un DAO pour établir nos opération sur notre table
	 */
	public static List<Produit> getAll(Connection cnx) throws Exception{
		List<Produit> lp = new ArrayList<Produit>();
		//requête sql
		String sql = "SELECT * FROM produits";
		
		//Créer un objet PreparedStatement
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		//Créer un objet de type resultSet qui contient l'ensemble des enregistrements (liste)
		ResultSet rs = ps.executeQuery();
		
		//Stocker ces enregistrements dans des objets produits de type produit
		while(rs.next()) {
			Produit produit = new Produit();
			
			//Création des attributs du produit dans la liste
			produit.setId(rs.getInt("id"));
			produit.setDescription(rs.getString("description"));
			produit.setPrix(rs.getDouble("prix"));
			lp.add(produit);
		}
		rs.close();
		cnx.close();
		return lp;
		
	}
	
	
	
	public static Produit saveProduit(Produit p, Connection cnx) throws Exception {
		String sql = "INSERT INTO produits (id, description, prix) VALUES (?, ?, ?)";
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		//Recuperer les VALUES à inserer à partir du Produit p définis dans les paramètres
		ps.setInt(1,  p.getId());
		ps.setString(2, p.getDescription());
		ps.setDouble(3, p.getPrix());
		
		//Executer la requête insert 
		//executeUpdate à la place de executeQuery car le contenu de la base de données sera modifié 
		ps.executeUpdate();
		
		ps.close();
		cnx.close();
		
		return p;
		
	}
	
	
	public static void deleteProduit(int id, Connection cnx) throws Exception {
		String sql = "DELETE FROM produits WHERE id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		//Récuperer l'id
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		cnx.close();
	}
	
	public static void updateProduit(Produit p, Connection cnx) throws Exception {
		String sql = "UPDATE produits SET description=?, prix=? WHERE id=?";
		//PreparedStatement - objet qui execute la requête déjà définie
		PreparedStatement ps = cnx.prepareStatement(sql);
		//définir les paramètres de la requêtes à partir du Produit P passé en paramètre
		ps.setString(1,  p.getDescription());
		ps.setDouble(2,  p.getPrix());
		ps.setInt(3,  p.getId());
		
		ps.executeUpdate();
		
		ps.close();
		cnx.close();
	}
	
	
	//Méthode findById
	public static Produit findById(int id, Connection cnx) throws Exception{
		Produit p = null;
		String sql = "SELECT * FROM produits WHERE id = ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		//Définir le paramètre de la requête SQL.
		//Le recuperer dans les arguments passés à la méthode
		ps.setInt(1,  id);
		
		//executeQuery renvoie une liste qu'on stock dans un resultSet
		ResultSet rs = ps.executeQuery();
		
		//Parcours de la liste
		while(rs.next()) {
			p = new Produit(rs.getInt("id"), rs.getString("description"), rs.getDouble("prix"));
		}
		ps.close();
		cnx.close();
		return p;
	}
	
}
