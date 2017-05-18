package br.gov.pa.prodepa.persistence.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceUnit(name="defaultPU")
	private EntityManagerFactory emf;
	
	@RequestScoped
	@Produces
	public EntityManager createEntityManager(){
		return emf.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
        if (manager.isOpen()) {
            manager.close();
        }
    }
}
