package exercicio.util;

import exercicio.dominio.Conta;

public interface ContaVisitor {
	void visitaConta(Conta conta);
}
