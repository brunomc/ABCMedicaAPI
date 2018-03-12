package org.bmc.rest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.bmc.model.Consulta;
import org.bmc.service.ConsultaService;

@Path("consulta")
@Produces("application/json;charset=utf-8")
public class ConsultaResource {
	@Inject
	ConsultaService serv;
	@POST
	public void save(Consulta f) throws ExecutionException {
		System.out.println("ok");
		serv.save(f);
	}
	@PUT
	@Path("{id}")
	public void update(@PathParam("id") long id) throws ExecutionException {
		System.out.println("ok");
		Consulta f = serv.buscarPorId(id);
		serv.update(f.getId());
	}
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") long id) throws ExecutionException {
		System.out.println("ok");
		Consulta f = serv.buscarPorId(id);
		serv.delete(f);
	}
	@GET
	@Path("{id}")
	public Consulta buscarPorId(@PathParam("id") long id) throws ExecutionException {
		System.out.println("ok");
		return new Consulta();
	}
	@GET
	public List<Consulta> buscarTodos(){
		System.out.println("ok");
	 return	serv.buscarTodos();
		
	}
}