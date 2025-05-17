package lista;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList<String> lista = new SinglyLinkedList<String>();

		lista.addLast("Juan");
		lista.addLast("Pedro");
		lista.addLast("Pablo");
		
		SinglyLinkedList<String> lista2 = new SinglyLinkedList<String>();

		lista2.addLast("Ana");
		lista2.addLast("Maria");

		lista.addAll(1, lista2);
		System.out.println(lista);
	}	

}
