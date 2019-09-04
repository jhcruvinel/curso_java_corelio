package exercicio.dominio;

public class ClienteAmericano extends Cliente {

	public void imprimeFormatoAmericano() {
		System.out.println(getSobrenome() + ", " + getNome());
	}

	public ClienteAmericano(Cliente cliente) {
		super(cliente.getNome(), cliente.getSobrenome(), cliente.getEndereço(), 
				cliente.getTelefone(), cliente.getContas());
	}
	
}
