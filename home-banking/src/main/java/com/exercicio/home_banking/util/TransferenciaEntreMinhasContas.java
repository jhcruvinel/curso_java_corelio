package com.exercicio.home_banking.util;

public class TransferenciaEntreMinhasContas implements TransferenciaStrategy {
	
	public TransferenciaEntreMinhasContas() {}

	@Override
	public double calculaTaxa(double valor) {
		return 0.0;
	}
	
	

}
