package org.bmc.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bmc.model.Animal;
@Stateless
public class AnimalService {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Animal a) throws ExecutionException {
		em.persist(a);
	}
	public void update(Animal a) throws ExecutionException {
		if(buscarPorId(a.getId()) != null) {
			a = buscarPorId(a.getId());
			em.persist(a);
		}else {
			System.out.println("Não há objeto para editar.");
		}
	}
	public void delete(Animal a) {
		em.remove(a);
	}
	public Animal buscarPorId(long id) throws ExecutionException {
		TypedQuery<Animal> query  = em.createQuery("select a from Animal a where id=:id",Animal.class);
		query.setParameter(":id", id);
		return query.getSingleResult();
		
	}
	public List<Animal> buscarTodos(){
		TypedQuery<Animal> query  = em.createQuery("select a from Animal a",Animal.class);
		return query.getResultList();
	}
}
