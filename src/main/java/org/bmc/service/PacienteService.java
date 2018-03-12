package org.bmc.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bmc.model.Paciente;
@Stateless
public class PacienteService {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(List<Paciente> a) throws ExecutionException {
		em.persist(a);
	}
	public void update(Paciente a) throws ExecutionException {
		if(buscarPorId(a.getId()) != null) {
			//a = buscarPorId(a.getId());
			em.persist(a);
		}else {
			System.out.println("Nao existe o objeto para editar.");
		}
	}
	public void delete(Paciente a) {
		em.remove(a);
	}
	public Paciente buscarPorId(long id) throws ExecutionException {
		TypedQuery<Paciente> query  = em.createQuery("select a from Paciente a where id=:id",Paciente.class);
		query.setParameter(":id", id);
		return query.getSingleResult();
		
	}
	public List<Paciente> buscarTodos(){
		TypedQuery<Paciente> query  = em.createQuery("select a from Paciente a",Paciente.class);
		return query.getResultList();
	}
}
