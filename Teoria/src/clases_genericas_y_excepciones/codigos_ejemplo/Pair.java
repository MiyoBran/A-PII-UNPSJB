package clases_genericas_y_excepciones.codigos_ejemplo;


public class Pair<A, B> {
	private A first;
	private B second;

	public Pair(A a, B b) { // constructor
		first = a;
		second = b;
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}
}