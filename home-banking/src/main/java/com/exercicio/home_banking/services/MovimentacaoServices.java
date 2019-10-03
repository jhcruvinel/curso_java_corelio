package com.exercicio.home_banking.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.exercicio.home_banking.entities.Movimentacao;

import io.swagger.annotations.Api;

@Api
@RepositoryRestResource(collectionResourceRel = "movimentacao", path = "movimentacao")
public interface MovimentacaoServices extends PagingAndSortingRepository<Movimentacao, Long> {

}
