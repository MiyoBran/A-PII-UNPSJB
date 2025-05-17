package test;

import lista.SinglyLinkedList;

public class PruebaLS {

	public static void main(String[] args) {

		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
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
			list.removeRange(2, 4);
			System.out.println(list);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		try {
			list.removeRange(3, 1);
			System.out.println(list);			
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			list.removeRange(5, 10);
			System.out.println(list);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
	}

}
