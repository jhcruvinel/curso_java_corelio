package exercicio.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Consumer;

import exercicio.util.ContaVisitor;
import exercicio.util.SubscriberMovimentacao;

public class ContaCorrente extends Conta {

	private double limiteCredito;

	/**
     * Accept visitor
     */
    public void accept(ContaVisitor visitor) {
    	visitor.visitaConta(this);
    }
    
	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
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
            m.setTipoConta(TipoConta.CORRENTE);
            m.setPublisher(new SubmissionPublisher<Movimentacao>());
            SubscriberMovimentacao movimentacaoSubscriber = new SubscriberMovimentacao();
            m.getPublisher().subscribe(movimentacaoSubscriber);
            return m;
        }
	}
}
