package lista;

public class PruebaLD {

	public static void main(String[] args) {

		// lista vacía
		DoublyLinkedList<String> list0 = new DoublyLinkedList<String>();
		System.out.println();
		System.out.println(list0);
		System.out.println("Palíndromo: " + list0.palindrome());		

		// lista cantidad de elementos par
		DoublyLinkedList<String> list1 = new DoublyLinkedList<String>();
		list1.addLast("a");
		list1.addLast("l");
		list1.addLast("l");
		list1.addLast("a");
		System.out.println();
		System.out.println(list1);
		System.out.println("Palíndromo: " + list1.palindrome());

		// lista cantidad de elementos impar
		DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
		list2.addLast("n");
		list2.addLast("e");
		list2.addLast("u");
		list2.addLast("q");
		list2.addLast("u");
		list2.addLast("e");
		list2.addLast("n");
		System.out.println();
		System.out.println(list2);
		System.out.println("Palíndromo: " + list2.palindrome());

		// lista no palíndromo
		DoublyLinkedList<String> list3 = new DoublyLinkedList<String>();
		list3.addLast("h");
		list3.addLast("o");
		list3.addLast("l");
		list3.addLast("a");
		System.out.println();
		System.out.println(list3);
		System.out.println("Palíndromo: " + list3.palindrome());

		// lista un elemento
		DoublyLinkedList<String> list4 = new DoublyLinkedList<String>();
		list4.addLast("a");
		System.out.println();
		System.out.println(list4);
		System.out.println("Palíndromo: " + list4.palindrome());

		// lista elementos repetidos
		DoublyLinkedList<String> list5 = new DoublyLinkedList<String>();
		list5.addLast("z");
		list5.addLast("z");
		list5.addLast("z");
		System.out.println();
		System.out.println(list5);
		System.out.println("Palíndromo: " + list5.palindrome());
	}

}
