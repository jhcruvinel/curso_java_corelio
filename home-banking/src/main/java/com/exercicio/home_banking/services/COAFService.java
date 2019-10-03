package com.exercicio.home_banking.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.exercicio.home_banking.entities.Movimentacao;
import com.exercicio.home_banking.util.COAF;

@Component
public class COAFService {


    public COAFService() {
    }

    public List<Movimentacao> getMovimentacoes() {
        return COAF.getInstance().getMovimentacoes();
    }

}
