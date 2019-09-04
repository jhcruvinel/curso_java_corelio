package exercicio.util;

import exercicio.dominio.Conta;
import exercicio.dominio.TipoConta;

public class BaseMensalVisitor implements ContaVisitor {

	@Override
	public void visitaConta(Conta conta) {
		System.out.println("************ Base Mensal ***************");
		if (conta.getTipoConta().equals(TipoConta.CORRENTE)) {
			conta.debito("Débito Mensal de Conta Corrente", 1.00);
		} else if (conta.getTipoConta().equals(TipoConta.INVESTIMENTO)) {
			conta.debito("Débito Mensal de Conta Investimento", conta.getSaldo()*0.01);
		} 
	}

}
