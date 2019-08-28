package exercicio;

import java.util.Date;
import java.util.function.Consumer;

public class Movimentacao {

	private Date dataHora;
	private TipoMovimentacao tipoMovimentacao;
	private String descricao;
	private double valor;
	
	public Movimentacao() {
		
	}

	public static class Builder {
		public Date dataHora;
		public TipoMovimentacao tipoMovimentacao;
		public String descricao;
		public double valor;

        public Builder() {

        }

        public Builder set(Consumer<Builder> builder) {
        	builder.accept(this);
            return this;
        }

        public Movimentacao build() {
        	Movimentacao m = new Movimentacao();
            m.dataHora = this.dataHora;
            m.tipoMovimentacao = this.tipoMovimentacao;
            m.descricao = this.descricao;
            m.valor = this.valor;
            return m;
        }
	}
	
	public void imprime() {
		System.out.println("Movimentacao [dataHora=" + dataHora + ", tipo=" + tipoMovimentacao + ", descricao="
				+ descricao + ", valor=" + valor + "]");
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
