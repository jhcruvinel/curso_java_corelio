package com.exercicio.home_banking.util;

import com.exercicio.home_banking.entities.Conta;

public interface ContaVisitor {
	void visitaConta(Conta conta);
}
