package lista;

public class TestAlternate {

	private static SinglyLinkedList<String> lista;
	private static SinglyLinkedList<String> listaAlternada;

	public static void main(String[] args) {

		lista = new SinglyLinkedList<String>();
		listaAlternada = lista.alternate(false);
		System.out.println("Lista vacía");
		System.out.println(listaAlternada);
		
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");
		lista.addLast("E");

		System.out.println(lista);
		listaAlternada = lista.alternate(true);
		System.out.println("Elementos impares");
		System.out.println(listaAlternada);		
		System.out.println("Elementos pares");
		listaAlternada = lista.alternate(false);
		System.out.println(listaAlternada);

	}

}
