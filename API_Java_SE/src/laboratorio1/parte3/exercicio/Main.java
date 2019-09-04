package laboratorio1.parte3.exercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> artigos = new ArrayList<>(
				Arrays.asList("o", "a", "os", "as", "do", "da", "dos", "das"));
		List<String> adjetivos = new ArrayList<>(
				Arrays.asList("brasileiro", "brasileira", "bonito", "bonita", "alegre"));
		List<String> substantivos = new ArrayList<>(
				Arrays.asList("livro", "caneta", "homem", "mulher", "biblioteca"));
		ExpressionParser expressionParser=new ExpressionParser();
		String result = expressionParser.parse(
				"O livro brasileiro contava uma história de um homem , uma mulher bonita na biblioteca da mulher com uma caneta",
				artigos, adjetivos, substantivos);
		System.out.println("Final result: "+result);
	}

}
