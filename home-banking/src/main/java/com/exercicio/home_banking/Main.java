package com.exercicio.home_banking;

import com.exercicio.home_banking.entities.Cliente;
import com.exercicio.home_banking.entities.Conta;
import com.exercicio.home_banking.entities.ContaCorrente;
import com.exercicio.home_banking.util.AdaptadorClienteAmericano;
import com.exercicio.home_banking.util.BaseMensalVisitor;
import com.exercicio.home_banking.util.COAF;

public class Main {

	public static void main (String[] args) throws Exception {
		
		Cliente c1 = new Cliente.Builder()
                .set(p -> {
                    p.nome = "Maria";
                    p.sobrenome = "Alves";
                    p.telefone = "98888-0000";
                    p.endereco = "Rua da Maria";
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
		c1.imprimeFormatoBrasileiro();
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
		
		
		COAF.getInstance().extratoMovimentacoesSuspeitas();
		
		c1.imprimeFormatoBrasileiro();
		AdaptadorClienteAmericano f = new AdaptadorClienteAmericano(c1);
		f.imprimeFormatoBrasileiro();
		
	}
	
}
