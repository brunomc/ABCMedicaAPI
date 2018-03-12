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

import org.bmc.model.Paciente;
import org.bmc.service.PacienteService;

@Path("paciente")
@Produces("application/json;charset=utf-8")
public class PacienteResource {
	@Inject
	PacienteService serv;
	@POST
	public void save(Paciente a) throws ExecutionException {
		
	}
	@PUT
	public void update(long id) throws ExecutionException {
		
	}
	@DELETE
	public void delete(long id) throws ExecutionException {
		
	}
	public Paciente buscarPorId(long id) throws ExecutionException {
		return serv.buscarPorId(id);
	}
	@GET
	public List<Paciente> buscarTodos(){
	 return	serv.buscarTodos();
		
	}
}
