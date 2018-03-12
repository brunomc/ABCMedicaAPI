package org.bmc.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bmc.model.Consulta;
@Stateful
public class ConsultaService {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Consulta a) throws ExecutionException {
		System.out.println(a);
		Object c=em.merge(a);
		System.out.println(c);
		em.persist(c);
		
	}
	public void update(long a) throws ExecutionException {
		if(buscarPorId(a) != null) {
			Consulta b = buscarPorId(a);
			Object c=em.merge(b);
			em.persist(c);
			
		}else {
			System.out.println("Nao existe o objeto para editar.");
		}
	}
	public void delete(Consulta a) {
		Object c=em.merge(a);
		em.remove(c);
	}
	public Consulta buscarPorId(long id) throws ExecutionException {
		TypedQuery<Consulta> query  = em.createQuery("select a from Consulta a where id=:id",Consulta.class);
		query.setParameter(":id", id);
		return query.getSingleResult();
		
	}
	public List<Consulta> buscarTodos(){
		TypedQuery<Consulta> query  = em.createQuery("select a from Consulta a",Consulta.class);
		return query.getResultList();
	}
}
