package org.bmc.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bmc.model.Medico;
@Stateless
public class MedicoService {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(List<Medico> a) throws ExecutionException {
		em.persist(a);
	}
	public void update(Medico a) throws ExecutionException {
		if(buscarPorId(a.getId()) != null) {
			//a = buscarPorId(a.getId());
			em.persist(a);
		}else {
			System.out.println("Nao existe o objeto para editar.");
		}
	}
	public void delete(Medico a) {
		em.remove(a);
	}
	public Medico buscarPorId(long id) throws ExecutionException {
		TypedQuery<Medico> query  = em.createQuery("select a from Medico a where id=:id",Medico.class);
		query.setParameter(":id", id);
		return query.getSingleResult();
		
	}
	public List<Medico> buscarTodos(){
		TypedQuery<Medico> query  = em.createQuery("select a from Medico a",Medico.class);
		return query.getResultList();
	}
}
