package model.dao;

import javax.persistence.*;

public class InstanciaJPA {
	private static EntityManagerFactory emf;
	public static void createEntityManagerFactory(){
		if( emf == null){
			emf = Persistence.createEntityManagerFactory("psc");
		}
	}
	public static EntityManager getEntityManager(){
		if (emf == null){
			createEntityManagerFactory();
		}
		return emf.createEntityManager();
	}
	public static void closeEntityManagerFactory(){
		emf.close();
	}
}