package exercicio.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import exercicio.util.FormatoBrasileiro;
import exercicio.util.TransferenciaEntreContasDiferentes;
import exercicio.util.TransferenciaEntreMinhasContas;
import exercicio.util.TransferenciaStrategy;

public class Cliente implements FormatoBrasileiro {

	private String nome;
	private String sobrenome;
	private String endereço;
	private String telefone;
	private List<Conta> contas;

	public void imprimeFormatoBrasileiro() {
		System.out.println(nome + " " + sobrenome);
	}
	
	public void transfereEntreMinhasContas(int idContaDebito, int idContatCredito, double valor) {
		transfere(idContaDebito, idContatCredito, valor, new TransferenciaEntreMinhasContas());
	}
	
	public void transfereEntreContasDiferentes(int idContaDebito, int idContatCredito, double valor) {
		transfere(idContaDebito, idContatCredito, valor, new TransferenciaEntreContasDiferentes());
	}
	
	public void transfere(int idContaDebito, int idContatCredito, double valor, TransferenciaStrategy transferenciaStrategy) {
		for (Conta conta: contas) {
			if (conta.getId() == idContaDebito) {
				conta.debito("Debito de Transferencia entre contas", valor);
				if (transferenciaStrategy.calculaTaxa(valor) > 0.0) {
					conta.debito("Taxa de Transferencia", transferenciaStrategy.calculaTaxa(valor));
				}	
			}
		}
		for (Conta conta: contas) {
			if (conta.getId() == idContatCredito) {
				conta.credito("Credito de Transferencia entre contas", valor);
			}
		}
	}
	
	public double calcularAplicacoesTotais() {
		double total = 0.0;
		for (Conta conta: contas) {
			total += conta.getSaldo();
		}
		return total;
	}
	
	public Cliente() {
		
	}
	
	@Override
    public Cliente clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Cliente");
        Cliente c1 = new Cliente.Builder().build();
		Conta ct1 = new ContaCorrente.Builder()
				.set(p -> {
					p.cliente = c1;
				}).build();
		Conta ct2 = new ContaInvestimento.Builder()
				.set(p -> {
					p.cliente = c1;
				}).build();
		c1.getContas().add(ct1);
		c1.getContas().add(ct2);
        return c1.clone();
    }

    @Override
    public String toString() {
        return "Livro";
    }
	
	public static class Builder {
		
		public String nome;
		public String sobrenome;
		public String endereço;
		public String telefone;

        public Builder() {

        }

        public Builder set(Consumer<Builder> builder) {
        	builder.accept(this);
            return this;
        }

        public Cliente build() {
        	Cliente m = new Cliente();
        	m.nome = this.nome;
            m.sobrenome = this.sobrenome;
            m.endereço = this.endereço;
            m.telefone = this.telefone;
            m.contas = new ArrayList<Conta>();
            return m;
        }
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Cliente(String nome, String sobrenome, String endereço, String telefone, List<Conta> contas) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereço = endereço;
		this.telefone = telefone;
		this.contas = contas;
	}
	
	
	
	
}
