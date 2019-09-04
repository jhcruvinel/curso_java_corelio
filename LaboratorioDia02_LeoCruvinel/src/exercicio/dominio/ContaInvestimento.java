package exercicio.dominio;

import exercicio.util.ContaVisitor;

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
}
