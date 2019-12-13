package fr.dawan.formationjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.dawan.formationjpa.entities.DbObject;

/**
 * @author JUSTE Woodson
 * EntityManagerFactory va se charger de lire le fichier persistence.xml 
 * et de configurer l’unité de persistance
 * Le succès de ce test devrait permettre de génerer la table formation
 * EntityManager est une interface définie dans JPA.
 * EtityManager définit les méthodes qui permettent de gérer le cycle 
 * de vie de la persistance des Entity.
 */
public class GenericDAO {

	public static <T extends DbObject> T create(T entity) {

		//Controle: On ne fait pas un persiste sur id existant
		//Valeur par défaut d'un entier est zéro
		//au depart formation.getId() = 0 car il n'est pas encore crée dans la base
		if(entity.getId() == 0 ) {
			EntityManager entityManager = createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			try {
				//Début de la transaction
				entityTransaction.begin();
				//On insère la formation dans la base de donnée
				entityManager.persist(entity);
				//On commit tout ce qui s'est fait dans la transaction
				entityTransaction.commit();
			} catch (Exception e) {
				//En cas D'erreur on effectue un rollback
				entityTransaction.rollback();
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
		}

		return entity;

	}


	public static <T extends DbObject> T findById(Class<T> clazz, long id) {
		EntityManager entityManager = createEntityManager();
		T entity = null;
		try {
			entity = entityManager.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();

		}
		return entity;
	}


	public static <T extends DbObject> void update(T entity) {
		//Controle : On fait un update sur un id existant
		if(entity.getId() > 0) {
			EntityManager entityManager = createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			try {
				//Début de la transaction
				entityTransaction.begin();
				entityManager.merge(entity);
				//On commit tout ce qui s'est fait dans la transaction
				entityTransaction.commit();
			} catch (Exception e) {
				//En cas D'erreur on effectue un rollback
				entityTransaction.rollback();
				e.printStackTrace();
			}  finally {
				entityManager.close();

			}
		}
	}


	public static <T extends DbObject> void delete(Class<T> clazz, long id) {
		EntityManager entityManager = createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			//Début de la transaction
			entityTransaction.begin();
			T entity = entityManager.find(clazz, id);
			entityManager.remove(entity);
			//On commit tout ce qui s'est fait dans la transaction
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			//En cas D'erreur on effectue un rollback
			entityTransaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	
	public static<T extends DbObject> List<T> findAll(Class<T> clazz) {
		List<T> resultat = null;
		EntityManager em = createEntityManager();
		//On crée la requête
		TypedQuery<T> query = em.createQuery("SELECT entity FROM " + clazz.getName() + " entity", clazz);
		
		//On execute la requête et on récupèe le resultat
		resultat = query.getResultList();
		
		em.close();
		
		return resultat;
	}
	
	/**
	 * Permet de récupérer toutes les entrées pour une table données à partir d'une entrée
	 * pour  un nombre de résultat donné
	 * @param <T>
	 * @param clazz : Le type que l'on souhaite récupérer 
	 * @param begin : L'index du prémier résultat
	 * @param nbResult : Le nombre de résultat que l'on souhaite récupérer
	 * @return : Une liste d'entrées paginées
	 */
	public static<T extends DbObject> List<T> findAll(Class<T> clazz, int begin, int nbResult) {
		List<T> resultat = null;
		EntityManager em = createEntityManager();
		//On crée la requête
		TypedQuery<T> query = em.createQuery("SELECT entity FROM " + clazz.getName() + " entity", clazz);
		
		//On paramètre et on execute la requête, et on récupère le resultat
		resultat = query.setFirstResult(begin) //On commence à ce numéro (begin) - au Nième résultat
				.setMaxResults(nbResult)	//On charge nbResult résultats
				.getResultList();	
		
		em.close();
		
		return resultat;
	}
	
	
	public static EntityManager createEntityManager() {
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("formationjpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

}
