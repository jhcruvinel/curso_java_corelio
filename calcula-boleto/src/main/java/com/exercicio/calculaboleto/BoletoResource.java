package com.exercicio.calculaboleto;

import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/boleto")
public class BoletoResource {

	@Inject
    BoletoService service;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{valor}/{vencimento}")
    public double calculaBoleto(@PathParam("valor") double valor, @PathParam("vencimento") Date vencimento) {
        return service.greeting(valor, vencimento);
    }
    
}