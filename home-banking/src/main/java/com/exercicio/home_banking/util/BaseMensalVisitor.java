package com.exercicio.home_banking.util;

import com.exercicio.home_banking.entities.Conta;
import com.exercicio.home_banking.entities.TipoConta;

public class BaseMensalVisitor implements ContaVisitor {

	@Override
	public void visitaConta(Conta conta) {
		System.out.println("************ Base Mensal ***************");
		if (conta.getTipoConta().equals(TipoConta.CORRENTE)) {
			conta.debito("D�bito Mensal de Conta Corrente", 1.00);
		} else if (conta.getTipoConta().equals(TipoConta.INVESTIMENTO)) {
			conta.debito("D�bito Mensal de Conta Investimento", conta.getSaldo()*0.01);
		} 
	}

}
