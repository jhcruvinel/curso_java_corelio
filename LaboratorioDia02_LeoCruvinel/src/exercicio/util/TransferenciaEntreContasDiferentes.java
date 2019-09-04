package exercicio.util;

public class TransferenciaEntreContasDiferentes implements TransferenciaStrategy {
	
	public TransferenciaEntreContasDiferentes() {}

	@Override
	public double calculaTaxa(double valor) {
		return valor*0.01;
	}
	
	

}
