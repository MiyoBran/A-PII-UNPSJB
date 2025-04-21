package lista;

public class PruebaDoble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList<String> lista = new DoublyLinkedList<String>();

		lista.addLast("Maria");
		lista.addLast("Pedro");
		lista.addLast("Pablo");
		lista.addLast("Pablo");
		
		DoublyLinkedList<String> lista2 = new DoublyLinkedList<String>();

		lista2.addLast("Ana");
		lista2.addLast("Maria");
		lista2.addLast("Pablo");
		
		lista.removeAll(1, lista2);
		System.out.println(lista);
	}	

}
