package laboratorio4.exercicios;

public class Exercicio2 {

	public static void main(String[] args) {
		try (RecursoExercicio2 myResource = new RecursoExercicio2()) {

			myResource.executaAlgo();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
