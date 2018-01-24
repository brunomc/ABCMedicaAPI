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

import org.bmc.model.Ficha;
import org.bmc.service.FichaService;

@Path("ficha")
@Produces("application/json;charset=utf-8")
public class FichaResource {
	@Inject
	FichaService serv;
	@POST
	public void save(Ficha f) throws ExecutionException {
		serv.save(f);
	}
	@PUT
	@Path("{id}")
	public void update(@PathParam("id") long id) throws ExecutionException {
		Ficha f = serv.buscarPorId(id);
		serv.update(f);
	}
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") long id) throws ExecutionException {
		Ficha f = serv.buscarPorId(id);
		serv.delete(f);
	}
	public Ficha buscarPorId(long id) throws ExecutionException {
		return serv.buscarPorId(id);
	}
	@GET
	public List<Ficha> buscarTodos(){
	 return	serv.buscarTodos();
		
	}
}
