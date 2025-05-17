package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class TestSubList2 {

	private static List<Integer> lista1;
	private static List<Integer> lista2;

	/**
	 * Ejemplo:
	 * 
	 * Dada la lista: [1, 2, 4, 5, 3, 6, 7]
	 * 
	 * Las siguientes listas son sublista: [3, 6, 7] [2, 4] [] [1]
	 * 
	 * Las siguientes listas no son sublista: [9] [3, 7, 6] [2, 1]
	 * 
	 */

	@Before
	public void setUp() throws Exception {
		lista1 = new ArrayList<Integer>();
		lista1.add(0, 1);
		lista1.add(1, 2);
		lista1.add(2, 4);
		lista1.add(3, 5);
		lista1.add(4, 3);
		lista1.add(5, 6);
		lista1.add(6, 7);
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [3, 6, 7]
	@Test
	public void test1() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 3);
		lista2.add(1, 6);
		lista2.add(2, 7);
		assertTrue(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [2, 4]
	@Test
	public void test2() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 2);
		lista2.add(1, 4);
		assertTrue(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// []
	@Test
	public void test3() {
		lista2 = new ArrayList<Integer>();
		assertTrue(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [1]
	@Test
	public void test4() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 1);
		assertTrue(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [9]
	@Test
	public void test5() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 9);
		assertFalse(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [3, 7, 6]
	@Test
	public void test6() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 3);
		lista2.add(1, 7);
		lista2.add(2, 6);
		assertFalse(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [2, 1]
	@Test
	public void test7() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 2);
		lista2.add(1, 1);
		assertFalse(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [1, 2, 4, 5, 3, 6, 7]
	@Test
	public void test8() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 1);
		lista2.add(1, 2);
		lista2.add(2, 4);
		lista2.add(3, 5);
		lista2.add(4, 3);
		lista2.add(5, 6);
		lista2.add(6, 7);
		assertTrue(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [1, 2, 4, 5, 3, 6, 7, 8]
	@Test
	public void test9() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 1);
		lista2.add(1, 2);
		lista2.add(2, 4);
		lista2.add(3, 5);
		lista2.add(4, 3);
		lista2.add(5, 6);
		lista2.add(6, 7);
		lista2.add(7, 8);
		assertFalse(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 6, 7]
	// [1, 1, 2]
	@Test
	public void test10() {
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 1);
		lista2.add(1, 1);
		lista2.add(2, 2);
		assertFalse(lista1.isSubList(lista2));
	}

	// [1, 1, 1, 2, 4, 5, 3, 6, 7]
	// [1, 2, 4]
	@Test
	public void test11() {
		lista1.add(0, 1);
		lista1.add(0, 1);
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 1);
		lista2.add(1, 2);
		lista2.add(2, 4);
		assertTrue(lista1.isSubList(lista2));
	}

	// [1, 2, 4, 5, 3, 3, 6, 7]
	// [3, 6]
	@Test
	public void test12() {
		lista1.add(4, 3);
		lista2 = new ArrayList<Integer>();
		lista2.add(0, 3);
		lista2.add(1, 6);
		System.out.println(lista1);
		System.out.println(lista2);
		assertTrue(lista1.isSubList(lista2));
	}

}