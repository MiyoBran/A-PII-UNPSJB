package test;

import lista.DoublyLinkedList;

public class PruebaLD {

	public static void main(String[] args) {

		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addLast("a");
		list.addLast("b");
		list.addLast("c");
		list.addLast("d");
		list.addLast("e");
		list.addLast("f");
		list.addLast("g");
		list.addLast("h");
		System.out.println(list);
		
		try {
			list.removeRange(2, 7);
			System.out.println(list);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		try {
			list.removeRange(1, 0);
			System.out.println(list);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		try {
			list.removeRange(0, 9);
			System.out.println(list);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

}
