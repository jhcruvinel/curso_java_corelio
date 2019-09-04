package exercicio.util;

import exercicio.dominio.Movimentacao;

public interface Subject {

	void registerObserver(Observer o);
    void notifyObservers(Movimentacao movimentacao);
	
}
