package com.exercicio.home_banking.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.exercicio.home_banking.entities.Conta;

@RepositoryRestResource(collectionResourceRel = "conta", path = "conta")
public interface ContaServices extends PagingAndSortingRepository<Conta, Long> {

}
