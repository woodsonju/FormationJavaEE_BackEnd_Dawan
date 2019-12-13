package fr.dawan.formationjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.dawan.formationjpa.entities.Formateur;

public class FormateurDAO {

	/**
	 * Permet de trouver les formateurs possédant ce nom
	 * En sql natif (par exemple MySQL)
	 * @param name Le nom du formateur
	 * @return	Une liste de formateurs
	 */
	@SuppressWarnings("unchecked")
	public static List<Formateur> findByNameNativeSQL(String nom) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		resultat = em.createNativeQuery("SELECT * FROM formateur WHERE nom like '%" + nom + "%'", Formateur.class)
				.getResultList();
		em.close();
		return resultat;
	}


	public static List<Formateur> findByNameHQLConcat(String nom) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		resultat = em.createQuery("SELECT f FROM Formateur f WHERE f.nom like '%" + nom + "%'", Formateur.class)
				.getResultList();
		em.close();
		return resultat;
	}

	public static List<Formateur> findByNameHQLParamater1(String nom) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		resultat = em.createQuery("SELECT f "
				+ " FROM Formateur f "
				+ " WHERE f.nom like?1"  //Si plx params: ?1 ?2...
				+ " ORDER BY f.nom, f.prenom DESC",   
				// + " AND f.prenom like ?2"
				Formateur.class)
				.setParameter(1, "%" + nom + "%")  // 1 vient remplacer ?1
				.getResultList();
		em.close();
		return resultat;
	}

	public static List<Formateur> findByNameHQLNameParamater(String nom) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		resultat = em.createQuery(
				"SELECT f "
				+ " FROM Formateur f "
				+ " WHERE f.nom like :leNom"
				+ " ORDER BY f.nom, f.prenom DESC",  
				Formateur.class)
				.setParameter("leNom", "%" + nom + "%")  
				.getResultList();
		em.close();
		return resultat;
	}
	
	public static List<Formateur> findByNameWithCriteria(String nom) {
		List<Formateur> resultat = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		//Builder de requête
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		// Initialisation de la requête
		CriteriaQuery<Formateur> query = criteriaBuilder.createQuery(Formateur.class);
		
		//Création de "FROM"
		Root<Formateur> entity = query.from(Formateur.class);
		
		//création du "WHERE", dans lequel on insère le "Like"
		query = query.where(criteriaBuilder.like(entity.get("nom"), "%" + nom + "%"));
		
		//On récupère le résultat
		resultat = em.createQuery(query).getResultList();
		
		em.close();
		return resultat;
	}

}
