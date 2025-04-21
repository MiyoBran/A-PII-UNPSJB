package lista;

public class PruebaRetainAll {

	public static void main(String[] args) {

		// lista y listaRT vacías
		DoublyLinkedList<String> lista = new DoublyLinkedList<String>();
		DoublyLinkedList<String> listaRT = new DoublyLinkedList<String>();

		System.out.println("lista y listaRT vacías");
		System.out.println("Lista: " + lista);
		System.out.println("ListaRT: " + listaRT);
		lista.retainAll(listaRT);
		System.out.println("Lista: " + lista);
		System.out.println();

		// listaRT con todos los elementos
		lista.addLast("rojo");
		lista.addLast("azul");
		lista.addLast("blanco");
		lista.addLast("azul");
		lista.addLast("azul");
		lista.addLast("amarillo");
		lista.addLast("verde");

		listaRT.addLast("amarillo");
		listaRT.addLast("verde");
		listaRT.addLast("rojo");
		listaRT.addLast("blanco");
		listaRT.addLast("azul");
		
		System.out.println("listaRT con todos los elementos");
		System.out.println("Lista: " + lista);
		System.out.println("ListaRT: " + listaRT);
		lista.retainAll(listaRT);
		System.out.println("Lista: " + lista);
		System.out.println();
		
		// listaRT sin un elemento de lista
		listaRT.removeLast();
		System.out.println("listaRT sin un elemento");
		System.out.println("Lista: " + lista);
		System.out.println("ListaRT: " + listaRT);
		lista.retainAll(listaRT);
		System.out.println("Lista: " + lista);
		System.out.println();
		
		// listaRT todos elementos distintos a lista
		listaRT.removeLast();
		listaRT.removeLast();
		listaRT.removeLast();
		listaRT.removeLast();
		listaRT.addFirst("negro");
		listaRT.addFirst("naranja");
		
		System.out.println("listaRT todos elementos distintos a lista");
		System.out.println("Lista: " + lista);
		System.out.println("ListaRT: " + listaRT);
		lista.retainAll(listaRT);
		System.out.println("Lista: " + lista);
		System.out.println();
		
	}

}
