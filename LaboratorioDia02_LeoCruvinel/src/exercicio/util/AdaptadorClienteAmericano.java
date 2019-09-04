package exercicio.util;

import exercicio.dominio.Cliente;
import exercicio.dominio.ClienteAmericano;

public class AdaptadorClienteAmericano implements FormatoBrasileiro {

	private ClienteAmericano clienteAmericano;
	
	public AdaptadorClienteAmericano(Cliente cliente) {
		this.clienteAmericano = new ClienteAmericano(cliente);
	}
	
	@Override
	public void imprimeFormatoBrasileiro() {
		clienteAmericano.imprimeFormatoAmericano();
	}
}
