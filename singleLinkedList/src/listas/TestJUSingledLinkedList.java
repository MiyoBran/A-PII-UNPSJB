package listas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * TestJUSingledLinkedList
 * 
 * Suite de pruebas más exhaustiva para SinglyLinkedList, basada en especificaciones de JUnit.
 * Evalúa casos válidos e inválidos para los métodos implementados en el TP03.
 * 
 * Trabajo Práctico N°3 - Algorítmica y Programación II (UNPSJB)
 * 
 * @author ALGII
 */
public class TestJUSingledLinkedList {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearh() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		Assert.assertEquals(list.search("A"), "A");
		Assert.assertEquals(list.search("D"), "D");
		Assert.assertNull(list.search("Z"));
	}

	@Test
	public void testConcatenate() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		list1.addLast("A");
		list1.addLast("B");
		list1.addLast("C");
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		list2.addLast("D");
		list2.addLast("E");
		list1.concatenate(list2);

		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("E");

		Assert.assertEquals(list1, listTest);
	}

	@Test
	public void testAddPos1() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addPos("Z", 0);

		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("Z");
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");

		Assert.assertEquals(list, listTest);
	}

	@Test
	public void testAddPos2() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("Z");
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addPos("Y", 5);

		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("Z");
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("Y");

		Assert.assertEquals(list, listTest);

	}

	@Test
	public void testAddPos3() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("Z");
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("Y");
		list.addPos("X", 5);
		
		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("Z");
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("X");
		listTest.addLast("Y");

		Assert.assertEquals(list, listTest);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddPos4() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addPos("X", -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddPos5() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addPos("X", 1);
	}

	@Test
	public void testRemovePos1() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		list.removePos(0);

		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("E");

		Assert.assertEquals(list, listTest);
	}

	@Test
	public void testRemovePos2() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		list.removePos(3);

		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");

		Assert.assertEquals(list, listTest);
	}

	@Test
	public void testRemovePos3() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.removePos(1);

		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("B");
		listTest.addLast("D");

		Assert.assertEquals(list, listTest);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovePos4() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.removePos(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovePos5() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.removePos(1);
	}

	@Test
	public void testRemoveElement1() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		list.removeElement("W");
		
		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("A");
		listTest.addLast("B");
		listTest.addLast("C");
		listTest.addLast("D");
		listTest.addLast("E");
		
		Assert.assertEquals(list, listTest);
	}

	@Test
	public void testRemoveElement2() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		list.removeElement("C");
		
		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("A");
		listTest.addLast("B");		
		listTest.addLast("D");
		listTest.addLast("E");
		
		Assert.assertEquals(list, listTest);
	}
	
	@Test
	public void testRemoveElement3() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");		
		list.addLast("D");
		list.addLast("E");		
		list.removeElement("A");
			
		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("B");		
		listTest.addLast("D");
		listTest.addLast("E");
		
		Assert.assertEquals(list, listTest);
	}
	
	@Test
	public void testRemoveElement4() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLast("B");		
		list.addLast("D");
		list.addLast("E");		
		list.removeElement("E");
		
		SinglyLinkedList<String> listTest = new SinglyLinkedList<String>();
		listTest.addLast("B");		
		listTest.addLast("D");		
		
		Assert.assertEquals(list, listTest);
	}
		
}
