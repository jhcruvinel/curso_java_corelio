package com.exercicio.home_banking.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.exercicio.home_banking.entities.Movimentacao;

public final class COAF implements Observer {

	private List<Movimentacao> movimentacoes;
		
	@Override
	public void auditaMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
        cadastraMovimentacaoSuspeita(movimentacao);
    }
	
	public void extratoMovimentacoesSuspeitas() {
		System.out.println(" ******** MOVIMENTACOES SUSPEITAS ******** ");
		movimentacoes.forEach(Movimentacao::imprime);
		System.out.println(" ***************************************** ");
	}

	
	private static volatile COAF instance;

	/**
	 * private constructor to prevent client from instantiating.
	 */
	private COAF() {
		// to prevent instantiating by Reflection call
		movimentacoes = new ArrayList<Movimentacao>();
		if (instance != null) {
			throw new IllegalStateException("J� inicializada.");
		}
	}

	/**
	 * Public accessor.
	 *
	 * @return an instance of the class.
	 */
	public static COAF getInstance() {
		// local variable increases performance by 25 percent
		// Joshua Bloch "Effective Java, Second Edition", p. 283-284

		COAF result = instance;
		// Check if singleton instance is initialized. If it is initialized then we can
		// return the instance.
		if (result == null) {
			// It is not initialized but we cannot be sure because some other thread might
			// have initialized it
			// in the meanwhile. So to make sure we need to lock on an object to get mutual
			// exclusion.
			synchronized (COAF.class) {
				// Again assign the instance to local variable to check if it was initialized by
				// some other thread
				// while current thread was blocked to enter the locked zone. If it was
				// initialized then we can
				// return the previously created instance just like the previous null check.
				result = instance;
				if (result == null) {
					// The instance is still not initialized so we can safely (no other thread can
					// enter this zone)
					// create an instance and make it our singleton instance.
					instance = result = new COAF();
				}
			}
		}
		return result;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	
    public static void buscaMovimentacoes() {
    	try {
	        // Criando o HttpClient
    		HttpClient client = HttpClient.newHttpClient();
	        //Criando um HttpRequest do tipo Get e especificando a URI de consulta
	        HttpRequest request = HttpRequest.newBuilder().GET().uri(
	        		URI.create("http://localhost:3000/movimentacoes")).build();
	        // Enviando a requisi��o e recebendo o Objeto de resposta da mesma.
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        // Extraindo o retorno da requisi��o
	        String body = response.body();
	        // Imprimindo o resultado da mesma
	        System.out.println(body);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	
	public static void cadastraMovimentacaoSuspeita(Movimentacao m) {
		try {
			// Criando o HttpClient
			HttpClient client = HttpClient.newHttpClient();
			// String no formato Json que ir� conter o corpo da requisi��o POST
			String body = "{\"idConta\": "+m.getConta().getId()+", "
					+ "\"tipo\": \""+m.getTipoMovimentacao()+"\", "
					+ "\"descricao\": \""+m.getDescricao()+"\", "
					+ "\"valor\": "+m.getValor()+", "
					+ "\"dataHora\": \""+m.getDataHora()+"\"}";
			// Criando um HttpRequest do tipo Post, especificando sua URI e atribuindo ao
			// m�todo Post o corpo da requisi��o
			HttpRequest request = HttpRequest.newBuilder().headers("content-type", "application/json").POST(HttpRequest.BodyPublishers.ofString(body))
					.uri(URI.create("http://localhost:3000/movimentacoes")).build();
			// Enviando a requisi��o e recebendo o Objeto de resposta da mesma.
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			// Extraindo status de resposta da requisi��o Post
			int statusCode = response.statusCode();
			// Imprimindo resultado no console
			System.out.println(String.format("Status code: %s", statusCode));
		} catch (Exception e) {
    		e.printStackTrace();
    	}
	}

}
