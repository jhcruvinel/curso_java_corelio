package exercicio.util;

import exercicio.dominio.Conta;
import exercicio.dominio.ContaCorrente;
import exercicio.dominio.ContaInvestimento;

public class BaseMensalVisitor implements ContaVisitor {

	@Override
	public void visitaConta(Conta conta) {
		System.out.println("************ Base Mensal ***************");
		if (conta instanceof ContaCorrente) {
			conta.debito("Débito Mensal de Conta Corrente", 1.00);
		} else if (conta instanceof ContaInvestimento) {
			conta.debito("Débito Mensal de Conta Investimento", conta.getSaldo()*0.01);
		} else {
			System.out.println("nenhum");
		}
	}

}
