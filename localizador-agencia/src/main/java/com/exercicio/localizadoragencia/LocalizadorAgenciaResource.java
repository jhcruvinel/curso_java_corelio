package com.exercicio.localizadoragencia;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agencias")
public class LocalizadorAgenciaResource {

	@Inject
    LocalizadorAgenciaService service;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{cidade}")
    public ArrayList<String> localizaAgencias(@PathParam("cidade") String cidade) {
        return service.localizaAgencia(cidade);
    }
    
}