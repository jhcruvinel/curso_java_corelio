package com.exercicio.home_banking;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.exercicio.home_banking.entities.Cliente;
import com.exercicio.home_banking.entities.Conta;
import com.exercicio.home_banking.entities.Movimentacao;

@SuppressWarnings("deprecation")
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Cliente.class);
        config.exposeIdsFor(Conta.class);
        config.exposeIdsFor(Movimentacao.class);
    }
}
