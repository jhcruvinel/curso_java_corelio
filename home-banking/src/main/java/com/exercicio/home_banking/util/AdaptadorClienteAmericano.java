package com.exercicio.home_banking.util;

import com.exercicio.home_banking.entities.Cliente;
import com.exercicio.home_banking.entities.ClienteAmericano;

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
