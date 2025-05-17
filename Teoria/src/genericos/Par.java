package genericos;


public class Par<A, B> {
	A first;
	B second;

	public Par(A a, B b) { // constructor
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
