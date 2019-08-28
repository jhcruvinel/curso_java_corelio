package exercicio;

public class Main {

	public static void main (String[] args) throws Exception {
		
		
		Cliente c1 = new Cliente.Builder()
                .set(p -> {
                    p.nome = "Maria";
                    p.sobrenome = "Alves";
                    p.telefone = "98888-0000";
                    p.endereço = "Rua da Maria";
                }).build();
		Conta ct1 = new ContaCorrente.Builder()
				.set(p -> {
					p.id = 1;
					p.cliente = c1;
				}).build();
		ct1.deposito(100.0);
		ct1.saque(30);
		ct1.deposito(52000.0);
		ct1.extratoMovimentacao();
		
		c1.imprimeNome();
//		AdapterClienteAmericano adapter = new AdapterClienteAmericano(c1);
		
		
		COAF.getInstance().extratoMovimentacoesSuspeitas();
	}
	
}
