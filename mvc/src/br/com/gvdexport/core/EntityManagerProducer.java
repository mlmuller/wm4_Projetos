package br.com.gvdexport.core;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Dependent
public class EntityManagerProducer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceUnit
	@Default
	private EntityManagerFactory emf;
	
	@Produces
	@RequestScoped
	public EntityManager create() {
	    return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
	    em.close();
	}
}