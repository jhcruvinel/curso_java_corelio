package exercicio;

import java.util.ArrayList;
import java.util.List;

public final class COAF implements Observer {

	private List<Movimentacao> movimentacoes;
		
	@Override
	public void auditaMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
    }
	
	public void extratoMovimentacoesSuspeitas() {
		System.out.println(" ******** MOVIMENTACOES SUSPEITAS ******** ");
		movimentacoes.forEach(Movimentacao::imprime);
		System.out.println(" ***************************************** ");
	}

	
	private static volatile COAF instance;

	/**
	 * private constructor to prevent client from instantiating.
	 */
	private COAF() {
		// to prevent instantiating by Reflection call
		movimentacoes = new ArrayList<Movimentacao>();
		if (instance != null) {
			throw new IllegalStateException("Já inicializada.");
		}
	}

	/**
	 * Public accessor.
	 *
	 * @return an instance of the class.
	 */
	public static COAF getInstance() {
		// local variable increases performance by 25 percent
		// Joshua Bloch "Effective Java, Second Edition", p. 283-284

		COAF result = instance;
		// Check if singleton instance is initialized. If it is initialized then we can
		// return the instance.
		if (result == null) {
			// It is not initialized but we cannot be sure because some other thread might
			// have initialized it
			// in the meanwhile. So to make sure we need to lock on an object to get mutual
			// exclusion.
			synchronized (COAF.class) {
				// Again assign the instance to local variable to check if it was initialized by
				// some other thread
				// while current thread was blocked to enter the locked zone. If it was
				// initialized then we can
				// return the previously created instance just like the previous null check.
				result = instance;
				if (result == null) {
					// The instance is still not initialized so we can safely (no other thread can
					// enter this zone)
					// create an instance and make it our singleton instance.
					instance = result = new COAF();
				}
			}
		}
		return result;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	

}
