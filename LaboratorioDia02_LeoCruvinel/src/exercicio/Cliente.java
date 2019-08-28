package exercicio;

import java.util.List;
import java.util.function.Consumer;

public class Cliente {

	private String nome;
	private String sobrenome;
	private String endere�o;
	private String telefone;
	private List<Conta> contas;
	
	public double calcularAplicacoesTotais() {
		double total = 0.0;
		for (Conta conta: contas) {
			total += conta.getSaldo();
		}
		return total;
	}
	
	public Cliente() {
		
	}
	
	public static class Builder {
		
		public String nome;
		public String sobrenome;
		public String endere�o;
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
            m.endere�o = this.endere�o;
            m.telefone = this.telefone;
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

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
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
	
	
	
	
}
