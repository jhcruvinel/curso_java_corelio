package laboratorio4.exercicios;

public class RecursoExercicio2 implements AutoCloseable {

	public void executaAlgo() throws Exception {
		System.out.println("Executando alguma a��o que pode retornar uma exception!");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Meu primeiro recurso personalizado do try-with-resouce");
	}
}