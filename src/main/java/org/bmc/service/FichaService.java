package org.bmc.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bmc.model.Ficha;
@Stateless
public class FichaService {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Ficha f) throws ExecutionException {
		em.persist(f);
	}
	public void update(Ficha f) throws ExecutionException {
		if(buscarPorId(f.getId()) != null) {
			f = buscarPorId(f.getId());
			em.persist(f);
		}else {
			System.out.println("Não há objeto para editar.");
		}
	}
	public void delete(Ficha f) {
		em.remove(f);
	}
	public Ficha buscarPorId(long id) throws ExecutionException {
		TypedQuery<Ficha> query  = em.createQuery("select f from Ficha f where id=:id",Ficha.class);
		query.setParameter(":id", id);
		return query.getSingleResult();
		
	}
	public List<Ficha> buscarTodos(){
		TypedQuery<Ficha> query  = em.createQuery("select f from Ficha f",Ficha.class);
		return query.getResultList();
	}
}
