package com.exercicio.home_banking.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.exercicio.home_banking.util.COAF;
import com.exercicio.home_banking.util.ContaVisitor;
import com.exercicio.home_banking.util.Observer;
import com.exercicio.home_banking.util.Subject;

@Entity
public class Conta implements Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double saldo;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "conta")
	private List<Movimentacao> movimentacoes;
	
	@Transient
	private List<Observer> observers;
	
	private TipoConta tipoConta;
	
	@Transient
	private SubmissionPublisher<Movimentacao> publisher;
	

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
                	p.conta = this;
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
                	p.conta = this;
                    p.dataHora = new Date();
                    p.tipoMovimentacao = TipoMovimentacao.DEBITO;
                    p.descricao = descricao;
                    p.valor = valor;
                }).build());
	}
	
	public void saque(double valor) throws Exception {
		Calendar cal = Calendar.getInstance();
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		if (valor <= 1000.0 && (hora >= 6 && hora <= 21)) {
			debito("SAQUE", valor);			
		} else {
			throw new Exception(
					"Saques acima de 1000 reais somente s�o permitidos entre 6:00 e 22:00");
		}

	}
	
	public void deposito(double valor) throws Exception {
		saldo += valor;
		Movimentacao movimentacao = new Movimentacao.Builder()
                .set(p -> {
                	p.conta = this;
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

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public SubmissionPublisher<Movimentacao> getPublisher() {
		return publisher;
	}

	public void setPublisher(SubmissionPublisher<Movimentacao> publisher) {
		this.publisher = publisher;
	}

	
	
}
