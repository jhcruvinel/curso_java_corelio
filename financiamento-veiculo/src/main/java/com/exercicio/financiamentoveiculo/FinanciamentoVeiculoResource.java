package com.exercicio.financiamentoveiculo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fveiculo")
public class FinanciamentoVeiculoResource {

	@Inject
    FinanciamentoVeiculoService service;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{valor}/{meses}")
    public double calculaFinanciamentoVeiculo(@PathParam("valor") double valor, @PathParam("meses") int meses) {
        return service.fVeiculo(valor, meses);
    }
    
}