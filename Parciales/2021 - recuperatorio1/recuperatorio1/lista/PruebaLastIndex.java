package lista;

public class PruebaLastIndex {

	public static void main(String[] args) {

		DoublyLinkedList<String> lista = new DoublyLinkedList<String>();
		// Lista vacía
		System.out.println("Lista: " + lista);
		System.out.println(lista.lastIndex("azul"));

		lista.addLast("rojo");
		lista.addLast("azul");
		lista.addLast("blanco");
		lista.addLast("azul");
		lista.addLast("azul");
		lista.addLast("amarillo");
		lista.addLast("verde");
		System.out.println("Lista: " + lista);

		// Lista no está el elemento
		System.out.println("negro: " + lista.lastIndex("negro"));

		// Lista está el elemento
		System.out.println("azul: " + lista.lastIndex("azul"));
		System.out.println("rojo: " + lista.lastIndex("rojo"));
		System.out.println("verde: " + lista.lastIndex("verde"));
	}

}
