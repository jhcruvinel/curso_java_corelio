package com.exercicio.calculaboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BoletoService {

    private static double MULTA_DIARIA = 0.01;

    public double greeting(double valor, Date vencimento) {
    	LocalDateTime hoje = LocalDateTime.now();
    	LocalDate aux = vencimento.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
    	long dias = aux.until(hoje, ChronoUnit.DAYS);
        return valor*((double)dias )*MULTA_DIARIA;
    }

}