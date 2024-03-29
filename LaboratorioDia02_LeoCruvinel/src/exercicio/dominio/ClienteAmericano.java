package exercicio.dominio;

public class ClienteAmericano extends Cliente {

	public void imprimeFormatoAmericano() {
		System.out.println(getSobrenome() + ", " + getNome());
	}

	public ClienteAmericano(Cliente cliente) {
		super(cliente.getNome(), cliente.getSobrenome(), cliente.getEnderešo(), 
				cliente.getTelefone(), cliente.getContas());
	}
	
}
