package lista;

public class PruebaListaDoble {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		DoublyLinkedList<String> lista = new DoublyLinkedList<String>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");
		lista.addLast("E");
		System.out.println(lista);

		try {
			lista.addPos("AB", 2);
			System.out.println(lista);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			lista.addPos("DE", 6);
			System.out.println(lista);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			lista.addPos("Z", 8);
			System.out.println(lista);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		try {
			lista.addPos("1", 1);
			System.out.println(lista);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			lista.addPos("-1", -1);
			System.out.println(lista);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			lista.addPos("11", 11);
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

}
