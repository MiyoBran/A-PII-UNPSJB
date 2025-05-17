package test;

import org.junit.Assert;
import org.junit.Test;

import net.datastructures.SinglyLinkedList;

public class TestRight {

	@Test
	public void testRight1() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();
		listRes.addLast("A");
		listRes.addLast("B");
		listRes.addLast("C");
		listRes.addLast("D");

		Assert.assertEquals(list.right(4), listRes);
	}

	@Test
	public void testRight2() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();
		listRes.addLast("B");
		listRes.addLast("C");
		listRes.addLast("D");

		Assert.assertEquals(list.right(3), listRes);
	}

	@Test
	public void testRight3() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();
		listRes.addLast("C");
		listRes.addLast("D");

		Assert.assertEquals(list.right(2), listRes);
	}

	@Test
	public void testRight4() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();
		listRes.addLast("D");

		Assert.assertEquals(list.right(1), listRes);

	}

	@Test
	public void testRight5() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();
		
		Assert.assertEquals(list.right(0), listRes);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRight6() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		list.right(-1);
		list.right(5);
	}
}
