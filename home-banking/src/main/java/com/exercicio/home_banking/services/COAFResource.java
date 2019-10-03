package com.exercicio.home_banking.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exercicio.home_banking.entities.Movimentacao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("COAF API")
@Component
@Path("coaf")
public class COAFResource {

	@Autowired
    private COAFService coafService;
	
	@ApiOperation(value="Retorna uma lista com todas movimentacoes suspeitas.", response = Movimentacao.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou a lista de Usuários"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovimentacoes() {
		List<Movimentacao> lista = coafService.getMovimentacoes();
		return Response.ok(lista).build();
	}

}
