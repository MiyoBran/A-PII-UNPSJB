package clases_genericas_y_excepciones.codigos_ejemplo;


public class TestGenericPair {
	public static void main(String[] args) {
		Pair <String,Double> libro = 
				new Pair<String,Double>("Estructura de Datos y Algoritmos", 123.45);
		System.out.printf("El libro es: %s %.2f ", libro.getFirst(),libro.getSecond());
	}
}
