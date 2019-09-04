package exercicio.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import exercicio.util.COAF;
import exercicio.util.ContaVisitor;
import exercicio.util.Observer;
import exercicio.util.Subject;

public class Conta implements Subject {

	private long id;
	private double saldo;
	private Cliente cliente;
	private List<Movimentacao> movimentacoes;
	private List<Observer> observers;

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }
    
    /**
     * Accept visitor
     */
    public void accept(ContaVisitor visitor) {
    	visitor.visitaConta(this);
    }

    

    @Override
    public void notifyObservers(Movimentacao movimentacao) {
        for(Observer observer : this.observers){
            observer.auditaMovimentacao(movimentacao);
        }
    }
    
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
		System.out.println(hora);
		if (valor <= 1000.0 && (hora >= 6 && hora <= 21)) {
			debito("SAQUE", valor);			
		} else {
			throw new Exception(
					"Saques acima de 1000 reais somente são permitidos entre 6:00 e 22:00");
		}

	}
	
	public void deposito(double valor) throws Exception {
		saldo += valor;
		Movimentacao movimentacao = new Movimentacao.Builder()
                .set(p -> {
                    p.dataHora = new Date();
                    p.tipoMovimentacao = TipoMovimentacao.CREDITO;
                    p.descricao = "DEPOSITO";
                    p.valor = valor;
                }).build();
		if (valor > 50000.0) {
			notifyObservers(movimentacao);
		}
		movimentacoes.add(movimentacao);
	} 
	
	public void extratoMovimentacao() {
		System.out.println("-----------------------------------------------------");
		movimentacoes.forEach(Movimentacao::imprime);
	}
	
	public Conta() {
		movimentacoes = new ArrayList<Movimentacao>();
		observers = new ArrayList<Observer>();
		registerObserver(COAF.getInstance());
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
        	m.id = this.id;
            m.saldo = this.saldo;
            m.cliente = this.cliente;
            m.movimentacoes = this.movimentacoes;
            return m;
        }
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	
}
