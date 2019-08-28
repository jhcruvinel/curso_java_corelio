package exercicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Conta {

	private long id;
	private double saldo;
	private List<Movimentacao> movimentacoes;
	
	public void credito(String descricao, double valor) {
		saldo += valor;
		movimentacoes.add(new Movimentacao.Builder()
                .set(p -> {
                    p.dataHora = new Date();
                    p.tipoMovimentacao = TipoMovimentacao.CREDITO;
                    p.descricao = descricao;
                    p.valor = valor;
                }).build());		
	}
	
	public void debito(String descricao, double valor) {
		saldo -= valor;
		movimentacoes.add(new Movimentacao.Builder()
                .set(p -> {
                    p.dataHora = new Date();
                    p.tipoMovimentacao = TipoMovimentacao.DEBITO;
                    p.descricao = descricao;
                    p.valor = valor;
                }).build());
	}
	
	public void saque(double valor) throws Exception {
		Calendar cal = Calendar.getInstance();
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		if (valor > 1000.0 && (hora >= 6 || hora <=21)) {
			debito("SAQUE", valor);			
		} else {
			throw new Exception(
					"Saques acima de 1000 reais somente são permitidos entre 6:00 e 22:00");
		}

	}
	
	public void deposito(double valor) throws Exception {
		Calendar cal = Calendar.getInstance();
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		if (valor > 1000.0 && (hora >= 6 || hora <=21)) {
			debito("SAQUE", valor);			
		} else {
			throw new Exception(
					"Saques acima de 1000 reais somente são permitidos entre 6:00 e 22:00");
		}

	} 
	
	public void extratoMovimentacao() {
		movimentacoes.forEach(Movimentacao::imprime);
	}
	
	public Conta() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
