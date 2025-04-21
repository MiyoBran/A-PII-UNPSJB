package test;

import net.datastructures.SinglyLinkedList;

public class TestAddCombineAfter {

	public static void main(String[] args) {
		prueba1();
		prueba2();
		prueba3();
		prueba4();
		prueba5();
		prueba6();
	}

	public static void prueba1() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		list1.addLast("A");
		list1.addLast("B");
		list1.addLast("C");
		list1.addLast("D");

		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		list2.addLast("W");
		list2.addLast("X");
		list2.addLast("Y");
		list2.addLast("Z");

		System.out.print(list1 + " " + list2 + " => ");
		list1.addCombineAfter(list2);
		System.out.println(list1 + "  (" + list1.size() + ")");
	}

	public static void prueba2() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		list1.addLast("A");
		list1.addLast("B");
		list1.addLast("C");
		list1.addLast("D");

		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		list2.addLast("W");
		list2.addLast("X");

		System.out.print(list1 + " " + list2 + " => ");
		list1.addCombineAfter(list2);
		System.out.println(list1 + "  (" + list1.size() + ")");
	}

	public static void prueba3() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		list1.addLast("A");
		list1.addLast("B");

		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		list2.addLast("W");
		list2.addLast("X");
		list2.addLast("Y");
		list2.addLast("Z");

		System.out.print(list1 + " " + list2 + " => ");
		list1.addCombineAfter(list2);
		System.out.println(list1 + "  (" + list1.size() + ")");
	}

	public static void prueba4() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		list1.addLast("A");
		list1.addLast("B");
		list1.addLast("C");
		list1.addLast("D");

		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();

		System.out.print(list1 + " " + list2 + " => ");
		list1.addCombineAfter(list2);
		System.out.println(list1 + "  (" + list1.size() + ")");
	}

	public static void prueba5() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();

		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		list2.addLast("W");
		list2.addLast("X");
		list2.addLast("Y");
		list2.addLast("Z");

		System.out.print(list1 + " " + list2 + " => ");
		list1.addCombineAfter(list2);
		System.out.println(list1 + "  (" + list1.size() + ")");
	}

	public static void prueba6() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();

		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();

		System.out.print(list1 + " " + list2 + " => ");
		list1.addCombineAfter(list2);
		System.out.println(list1 + "  (" + list1.size() + ")");
	}

}
