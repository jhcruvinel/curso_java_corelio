package laboratorio3.exercicios;

/*
Com base no que foi explicado atÃ© o momento crie uma requisiÃ§Ã£o do tipo PUT e uma requisiÃ§Ã£o do tipo DELETE consumindo a API da
[Reqres](https://reqres.in/).
* */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class Exercicio_3 {

	public static void requisicaoPut() throws IOException, InterruptedException {
		// Criando o HttpClient
    	HttpClient client = HttpClient.newBuilder().proxy(ProxySelector.of(
        		new InetSocketAddress("cache.trt", 3128))).build();
		// String no formato Json que irá conter o corpo da requisição PUT
		String body = "{'name': 'morpheus', 'job': 'zion resident'}";
		// Criando um HttpRequest do tipo Put, especificando sua URI e atribuindo ao
		// método Put o corpo da requisição
		HttpRequest request = HttpRequest.newBuilder().PUT(HttpRequest.BodyPublishers.ofString(body))
				.uri(URI.create("https://reqres.in/api/users")).build();

		// Enviando a requisição e recebendo o Objeto de resposta da mesma.
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		// Extraindo status de resposta da requisição Put
		int statusCode = response.statusCode();
		// Imprimindo resultado no console
		System.out.println(String.format("Status code: %s", statusCode));
		System.out.println(String.format("Return: %s", response.body()));
	}

	public static void requisicaoDelete() throws IOException, InterruptedException {
		// Criando o HttpClient
    	HttpClient client = HttpClient.newBuilder().proxy(ProxySelector.of(
        		new InetSocketAddress("cache.trt", 3128))).build();
		// Criando um HttpRequest do tipo Delete e especificando sua URI
		HttpRequest request = HttpRequest.newBuilder().DELETE()
				.uri(URI.create("https://reqres.in/api/users/2")).build();
		// Enviando a requisição e recebendo o Objeto de resposta da mesma.
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		// Extraindo status de resposta da requisição Delete
		int statusCode = response.statusCode();
		// Imprimindo resultado no console
		System.out.println(statusCode);
		System.out.println(String.format("Return: %s", response.body()));
	}

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		requisicaoPut();
		requisicaoDelete();
	}

}