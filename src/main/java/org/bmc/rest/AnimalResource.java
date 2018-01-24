package org.bmc.rest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.bmc.model.Animal;
import org.bmc.service.AnimalService;

@Path("animal")
@Produces("application/json;charset=utf-8")
public class AnimalResource {
	@Inject
	AnimalService serv;
	@POST
	public void save(Animal a) throws ExecutionException {
		serv.save(a);
	}
	@PUT
	public void update(long id) throws ExecutionException {
		Animal a = serv.buscarPorId(id);
		serv.update(a);
	}
	@DELETE
	public void delete(long id) throws ExecutionException {
		Animal a = serv.buscarPorId(id);
		serv.delete(a);
	}
	public Animal buscarPorId(long id) throws ExecutionException {
		return serv.buscarPorId(id);
	}
	@GET
	public List<Animal> buscarTodos(){
	 return	serv.buscarTodos();
		
	}
}
