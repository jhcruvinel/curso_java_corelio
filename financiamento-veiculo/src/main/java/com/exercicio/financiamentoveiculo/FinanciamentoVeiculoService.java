package com.exercicio.financiamentoveiculo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FinanciamentoVeiculoService {

    private static double JUROS = 0.12;

    public double fVeiculo(double valor, int meses) {
    	double montante = valor * Math.pow(1.0 + JUROS,(double)meses/12.0);
    	double prestacao = montante / meses;
    	return prestacao;
    }

}