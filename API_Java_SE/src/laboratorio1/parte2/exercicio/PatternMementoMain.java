package laboratorio1.parte2.exercicio;

public class PatternMementoMain {

    public static void main(String[] args) {
    	
    	Caretaker caretaker = new Caretaker();
        Ponto ponto1 = new Ponto("2019/08/01", "09:00");
        Ponto ponto2 = new Ponto("2019/08/01", "12:00");
        Ponto ponto3 = new Ponto("2019/08/01", "13:00");
        Ponto ponto4 = new Ponto("2019/08/01", "18:00");

        Ponto ponto5 = new Ponto("2019/08/02", "09:00");
        Ponto ponto6 = new Ponto("2019/08/02", "12:00");
        Ponto ponto7 = new Ponto("2019/08/02", "13:00");
        Ponto ponto8 = new Ponto("2019/08/02", "18:00");

        LancamentoDePontos lancamentoDePontos = new LancamentoDePontos("Carlos");
        //Criar Savepoint 1 aqui
        caretaker.saveMemento("Savepoint 1", lancamentoDePontos.createMemento());

        lancamentoDePontos.lancarPonto(ponto1);
        lancamentoDePontos.lancarPonto(ponto2);
        lancamentoDePontos.lancarPonto(ponto3);
        lancamentoDePontos.lancarPonto(ponto4);

        //Criar Savepoint 2 aqui
        caretaker.saveMemento("Savepoint 2", lancamentoDePontos.createMemento());
        
        lancamentoDePontos.lancarPonto(ponto5);
        lancamentoDePontos.lancarPonto(ponto6);
        lancamentoDePontos.lancarPonto(ponto7);
        lancamentoDePontos.lancarPonto(ponto8);

        //Criar Savepoint 3 aqui
        caretaker.saveMemento("Savepoint 3", lancamentoDePontos.createMemento());

        lancamentoDePontos.removerPonto(ponto7);
        lancamentoDePontos.removerPonto(ponto8);

        //Criar Savepoint 4 aqui
        caretaker.saveMemento("Savepoint 4", lancamentoDePontos.createMemento());
        System.out.println(String.format("%s", lancamentoDePontos));

        //Restaurar para o Savepoint 1 aqui, logo em seguida imprima no console o objeto lancamentoDePontos
        lancamentoDePontos.restoreMemento(caretaker.getMemento("Savepoint 1"));
        System.out.println(String.format("Estado restaurado para: %s - %s", "1",lancamentoDePontos));
        
        //Restaurar para o Savepoint 2 aqui, logo em seguida imprima no console o objeto lancamentoDePontos
        lancamentoDePontos.restoreMemento(caretaker.getMemento("Savepoint 2"));
        System.out.println(String.format("Estado restaurado para: %s - %s", "2",lancamentoDePontos));

        
        //Restaurar para o Savepoint 3 aqui, logo em seguida imprima no console o objeto lancamentoDePontos
        lancamentoDePontos.restoreMemento(caretaker.getMemento("Savepoint 3"));
        System.out.println(String.format("Estado restaurado para: %s - %s", "3",lancamentoDePontos));

        //Restaurar para o Savepoint 4 aqui, logo em seguida imprima no console o objeto lancamentoDePontos
        lancamentoDePontos.restoreMemento(caretaker.getMemento("Savepoint 4"));
        System.out.println(String.format("Estado restaurado para: %s - %s", "4",lancamentoDePontos));

        //Limpar Savepoints aqui

    }

}
