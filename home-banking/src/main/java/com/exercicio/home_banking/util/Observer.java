package com.exercicio.home_banking.util;

import com.exercicio.home_banking.entities.Movimentacao;

public interface Observer {
	
	void auditaMovimentacao(Movimentacao movimentacao);
	
}
