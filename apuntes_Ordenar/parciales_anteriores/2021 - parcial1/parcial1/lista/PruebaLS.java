package lista;

public class PruebaLS {

	public static void main(String[] args) {
		
		// lista vacía
		SinglyLinkedList<String> list0 = new SinglyLinkedList<String>();
		System.out.println("Lista: " + list0);
		System.out.println("No Duplicado: " + list0.noDuplicate());
		
		// lista sin elementos repetidos
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		list1.addLast("a");		
		list1.addLast("b");
		list1.addLast("c");
		System.out.println("Lista: " + list1);
		System.out.println("No Duplicado: " + list1.noDuplicate());
		
		// lista todos elementos repetidos
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		list2.addLast("a");
		list2.addLast("a");
		list2.addLast("a");
		System.out.println("Lista: " + list2);
		System.out.println("No Duplicado: " + list2.noDuplicate());
				
		// lista primer elemento repetido
		SinglyLinkedList<String> list3 = new SinglyLinkedList<String>();
		list3.addLast("a");
		list3.addLast("a");
		list3.addLast("b");
		System.out.println("Lista: " + list3);
		System.out.println("No Duplicado: " + list3.noDuplicate());
				
		// lista último elemento repetido
		SinglyLinkedList<String> list4 = new SinglyLinkedList<String>();
		list4.addLast("a");
		list4.addLast("b");
		list4.addLast("b");
		System.out.println("Lista: " + list4);
		System.out.println("No Duplicado: " + list4.noDuplicate());
				
		// lista elementos repetidos en el medio
		SinglyLinkedList<String> list5 = new SinglyLinkedList<String>();
		list5.addLast("a");
		list5.addLast("b");
		list5.addLast("b");
		list5.addLast("b");
		list5.addLast("b");
		list5.addLast("c");
		System.out.println("Lista: " + list5);
		System.out.println("No Duplicado: " + list5.noDuplicate());
	}

}
