package com.exercicio.home_banking.entities;

public class ClienteAmericano extends Cliente {

	public void imprimeFormatoAmericano() {
		System.out.println(getSobrenome() + ", " + getNome());
	}

	public ClienteAmericano(Cliente cliente) {
		super(cliente.getNome(), cliente.getSobrenome(), cliente.getEndereco(), 
				cliente.getTelefone(), cliente.getContas());
	}
	
}
