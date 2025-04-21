package lista;

public class PruebaListaSimple {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		SinglyLinkedList<String> l;

		try {
			l = cargarDatos();
			l.removePos(2, 3);
			System.out.println(l);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			l = cargarDatos();
			l.removePos(1, 2);
			System.out.println(l);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			l = cargarDatos();
			l.removePos(5, 1);
			System.out.println(l);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			l = cargarDatos();
			l.removePos(5, 2);
			System.out.println(l);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			l = cargarDatos();
			l.removePos(0, 2);
			System.out.println(l);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	public static SinglyLinkedList<String> cargarDatos() {
		SinglyLinkedList<String> lista = new SinglyLinkedList<String>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");
		lista.addLast("E");

		return lista;
	}

}
