package exercicio;

public class AdapterClienteAmericano extends Cliente {
	private ClienteAmericano clienteAmericano;
	
	public AdapterClienteAmericano(ClienteAmericano clienteAmericano) {
		this.clienteAmericano = clienteAmericano;
	}
	
	public void imprimeNome() {
		clienteAmericano.imprimeNomeAmericano();
	}
}
