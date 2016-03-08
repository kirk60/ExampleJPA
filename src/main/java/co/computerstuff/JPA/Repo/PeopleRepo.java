package co.computerstuff.JPA.Repo;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import co.computerstuff.JPA.Entities.People;
import lombok.extern.java.Log;
/**
 * 
 * Simple repository for a simple case where there is only 1 table !
 * 
 * jpa-example is defined in resources/META-INF/persistance.xml
 * -- Persistence.createEntityManagerFactory("jpa-example");
 * 
 * @author Kirk Larson
 *
 */

@Log
public class PeopleRepo {

	private EntityManagerFactory factory = null;
	private EntityManager entityManager = null;
	
	private static PeopleRepo peopleRep = null;
	
	public static PeopleRepo getRepo(){
		if( peopleRep == null ){
			peopleRep = new PeopleRepo();
		}
		return peopleRep;
	}

	public PeopleRepo(){
		try {
			factory = Persistence.createEntityManagerFactory("jpa-example");
			entityManager = factory.createEntityManager();
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}

	public void save(People person) {

		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(person);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
}
