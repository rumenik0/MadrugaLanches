package model.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
	
	private static EntityManagerFactory emfPSC;
	
	public static void createEntityManagerFactoryPSC() {
		if ( emfPSC == null ) {
			emfPSC = Persistence.createEntityManagerFactory("psc");
		}
	}	
		
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = null;
		if ( emfPSC == null ) {
			createEntityManagerFactoryPSC();
		}
		emf = emfPSC;	
		return emf.createEntityManager();
	}
	
	public static void closeEntityManager(
		EntityManager	pEM,
		boolean			pFecharEntityManager
	) {
		if ( pEM != null && pFecharEntityManager ) {
			pEM.close();
		}
	}
	
	public static void closeEntityManager(
		EntityManager pEM
	) {
		if ( pEM != null ) {
			pEM.close();
		}
	}
	
	public static void closeEntityManagerFactory() {
		if ( emfPSC != null ) {
			emfPSC.close();
		}		
	}
	
}