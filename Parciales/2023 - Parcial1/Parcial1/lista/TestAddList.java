package lista;

import net.datastructures.SinglyLinkedList;

public class TestAddList {

	public static void main(String[] args) {
		testAddList1();
		testAddList2();
		testAddList3();
		testAddList4();
		testAddList5();
		testAddList6();
		testAddList7();
	}

	public static void testAddList1() {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
		l1.addLast("A");
		l1.addLast("B");
		l1.addLast("C");
		l1.addLast("D");

		SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
		l2.addLast("X");
		l2.addLast("Y");

		l1.addList(l2, 2);
		System.out.println(l1 + " Size: " + l1.size());
	}

	public static void testAddList2() {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
		l1.addLast("A");
		l1.addLast("B");
		l1.addLast("C");
		l1.addLast("D");

		SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
		l2.addLast("X");
		l2.addLast("Y");

		l1.addList(l2, 0);
		System.out.println(l1 + " Size: " + l1.size());
	}

	public static void testAddList3() {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
		l1.addLast("A");
		l1.addLast("B");
		l1.addLast("C");
		l1.addLast("D");

		SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
		l2.addLast("X");
		l2.addLast("Y");

		l1.addList(l2, 4);
		System.out.println(l1 + " Size: " + l1.size());
	}

	public static void testAddList4() {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
		l1.addLast("A");
		l1.addLast("B");
		l1.addLast("C");
		l1.addLast("D");

		SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();

		l1.addList(l2, 2);
		System.out.println(l1 + " Size: " + l1.size());
	}

	public static void testAddList5() {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();

		SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
		l2.addLast("X");
		l2.addLast("Y");

		l1.addList(l2, 0);
		System.out.println(l1 + " Size: " + l1.size());
	}

	public static void testAddList6() {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
		l1.addLast("A");
		l1.addLast("B");
		l1.addLast("C");
		l1.addLast("D");

		SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
		l2.addLast("X");
		l2.addLast("Y");

		try {
			l1.addList(l2, -1);
			System.out.println(l1 + " Size: " + l1.size());
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	public static void testAddList7() {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
		l1.addLast("A");
		l1.addLast("B");
		l1.addLast("C");
		l1.addLast("D");

		SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
		l2.addLast("X");
		l2.addLast("Y");

		try {
			l1.addList(l2, 5);
			System.out.println(l1 + " Size: " + l1.size());
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}
}
