package com.exercicio.home_banking.util;

import com.exercicio.home_banking.entities.Movimentacao;

public interface Subject {

	void registerObserver(Observer o);
    void notifyObservers(Movimentacao movimentacao);
	
}
