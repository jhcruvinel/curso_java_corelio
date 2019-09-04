package exercicio.dominio;

import exercicio.util.ContaVisitor;

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
	
	
}
