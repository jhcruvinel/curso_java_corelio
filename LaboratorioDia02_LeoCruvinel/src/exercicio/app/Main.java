package exercicio.app;

import exercicio.dominio.Cliente;
import exercicio.dominio.Conta;
import exercicio.dominio.ContaCorrente;
import exercicio.util.BaseMensalVisitor;
import exercicio.util.COAF;

public class Main {

	public static void main (String[] args) throws Exception {
		
		
		Cliente c1 = new Cliente.Builder()
                .set(p -> {
                    p.nome = "Maria";
                    p.sobrenome = "Alves";
                    p.telefone = "98888-0000";
                    p.endere�o = "Rua da Maria";
                }).build();
		Conta ct1 = new ContaCorrente.Builder()
				.set(p -> {
					p.id = 1;
					p.cliente = c1;
				}).build();
		ct1.deposito(100.0);
		ct1.saque(30);
		ct1.deposito(52000.0);
		ct1.extratoMovimentacao();
		System.out.println("Saldo: "+ct1.getSaldo());
		c1.getContas().add(ct1);
		c1.imprimeNome();
//		AdapterClienteAmericano adapter = new AdapterClienteAmericano(c1);
		

		Conta ct2 = new ContaCorrente.Builder()
				.set(p -> {
					p.id = 2;
					p.cliente = c1;
				}).build();
		ct2.deposito(1000.0);
		c1.getContas().add(ct2);

		ct1.extratoMovimentacao();
		System.out.println("Saldo: "+ct1.getSaldo());
		ct2.extratoMovimentacao();
		System.out.println("Saldo: "+ct2.getSaldo());
		System.out.println("*********************************");
		c1.transfereEntreMinhasContas(1, 2, 50.0);
		System.out.println("*********************************");
		ct1.extratoMovimentacao();
		System.out.println("Saldo: "+ct1.getSaldo());
		ct2.extratoMovimentacao();
		System.out.println("Saldo: "+ct2.getSaldo());
		
		
		System.out.println("Ap�s um m�s...");
		for (Conta conta: c1.getContas()) {
			conta.accept(new BaseMensalVisitor());
			conta.extratoMovimentacao();
		}
		
		
		c1.imprimeNome();

		COAF.getInstance().extratoMovimentacoesSuspeitas();
		COAF.buscaMovimentacoes();
		
		
	}
	
}