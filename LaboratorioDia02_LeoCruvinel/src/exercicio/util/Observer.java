package exercicio.util;

import exercicio.dominio.Movimentacao;

public interface Observer {
	
	void auditaMovimentacao(Movimentacao movimentacao);
	
}
