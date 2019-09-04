package exercicio.util;

import exercicio.dominio.Cliente;

public class ClienteAmericano extends Cliente {

	public void imprimeNomeAmericano() {
		System.out.println(getSobrenome() + ", " + getNome());
	}
	
}
