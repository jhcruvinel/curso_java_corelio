package com.exercicio.financiamentocasa;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FinanciamentoCasaService {

    private static double JUROS = 0.12;

    public double fCasa(double valor, int meses) {
    	double montante = valor * Math.pow(1.0 + JUROS,(double)meses/12.0);
    	double prestacao = montante / meses;
    	return prestacao;
    }

}