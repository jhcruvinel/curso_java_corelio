package com.exercicio.home_banking.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Consumer;

import com.exercicio.home_banking.util.ContaVisitor;
import com.exercicio.home_banking.util.SubscriberMovimentacao;

public class ContaInvestimento extends Conta {

	private TipoAplicacao tipoAplicacao;

	/**
     * Accept visitor
     */
    public void accept(ContaVisitor visitor) {
    	visitor.visitaConta(this);
    }
	
	public TipoAplicacao getTipoAplicacao() {
		return tipoAplicacao;
	}

	public void setTipoAplicacao(TipoAplicacao tipoAplicacao) {
		this.tipoAplicacao = tipoAplicacao;
	}
	
	public void aplicacaoRendimentosPeriodicos(TipoPeriodo tipoPeriodo, double rendimento) {
		
	}
	
	public ContaInvestimento() {
		
	}
	
	public static class Builder {
		
		public long id;
		public double saldo;
		public Cliente cliente;
		public List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

        public Builder() {

        }

        public Builder set(Consumer<Builder> builder) {
        	builder.accept(this);
            return this;
        }

        public Conta build() {
        	Conta m = new Conta();
        	m.setId(this.id);
            m.setSaldo(this.saldo);
            m.setCliente(this.cliente);
            m.setMovimentacoes(this.movimentacoes);
            m.setTipoConta(TipoConta.INVESTIMENTO);
            m.setPublisher(new SubmissionPublisher<Movimentacao>());
            SubscriberMovimentacao movimentacaoSubscriber = new SubscriberMovimentacao();
            m.getPublisher().subscribe(movimentacaoSubscriber);
            return m;
        }
	}
	
}
