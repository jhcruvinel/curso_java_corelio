package com.exercicio.financiamentocasa;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fcasa")
public class FinanciamentoCasaResource {

	@Inject
    FinanciamentoCasaService service;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{valor}/{meses}")
    public double calculaFinanciamentoCasa(@PathParam("valor") double valor, @PathParam("meses") int meses) {
        return service.fCasa(valor, meses);
    }
    
}