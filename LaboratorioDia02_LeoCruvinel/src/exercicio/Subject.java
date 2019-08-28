package exercicio;

public interface Subject {

	void registerObserver(Observer o);
    void notifyObservers(Movimentacao movimentacao);
	
}
