package lista;

public class TestSwap {

	private static DoublyLinkedList<String> lista;

	public static void main(String[] args) {

		testSwap1();
		testSwap2();
		testSwap3();
		testSwap4();
		testSwap5();
		
	}

	public static void testSwap1() {
		lista = new DoublyLinkedList<String>();
		lista.addLast("0");
		lista.addLast("1");
		lista.addLast("2");
		lista.addLast("3");
		lista.addLast("4");
		
		System.out.println("Test 1");
		System.out.println(lista);
		lista.swap(0, 4);
		System.out.println(lista);
	}

	public static void testSwap2() {
		lista = new DoublyLinkedList<String>();
		lista.addLast("0");
		lista.addLast("1");
		lista.addLast("2");
		lista.addLast("3");
		lista.addLast("4");

		System.out.println("Test 2");
		System.out.println(lista);
		lista.swap(3, 1);
		System.out.println(lista);
	}

	public static void testSwap3() {
		lista = new DoublyLinkedList<String>();
		lista.addLast("0");
		lista.addLast("1");
		lista.addLast("2");
		lista.addLast("3");
		lista.addLast("4");

		System.out.println("Test 3");
		System.out.println(lista);
		lista.swap(2, 2);
		System.out.println(lista);
	}

	public static void testSwap4() {
		lista = new DoublyLinkedList<String>();
		lista.addLast("0");
		lista.addLast("1");
		lista.addLast("2");
		lista.addLast("3");
		lista.addLast("4");

		System.out.println("Test 4");
		System.out.println(lista);
		try {
			lista.swap(-1, 2);
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
	
	public static void testSwap5() {
		lista = new DoublyLinkedList<String>();
		lista.addLast("0");
		lista.addLast("1");
		lista.addLast("2");
		lista.addLast("3");
		lista.addLast("4");

		System.out.println("Test 5");
		System.out.println(lista);
		try {
			lista.swap(2, 7);
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
}
