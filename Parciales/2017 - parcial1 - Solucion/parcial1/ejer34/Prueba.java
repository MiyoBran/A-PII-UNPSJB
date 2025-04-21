public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();

		lista1.addFirst("Hola");
		lista1.addLast("Mundo");
		lista1.addLast("Hola");
		lista1.addLast("Hola");

		System.out.println(lista1);
		System.out.println("Cantidad ocurrencia: Mundo " + lista1.numSearch("Mundo"));

		System.out.println("Borrar ocurrencia: Hola " +lista1.removeAllElement("Hola"));
		System.out.println(lista1);
		
	}
}
