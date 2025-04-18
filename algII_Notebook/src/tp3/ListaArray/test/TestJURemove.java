package tp3.ListaArray.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp3.ListaArray.Lista;

public class TestJURemove {

	private Lista<String> lista1;
	private Lista<String> lista2;

	@Before
	public void setUp() throws Exception {
		lista1 = new Lista<String>(10);
		lista1.add("A");
		lista1.add("B");

		lista2 = new Lista<String>(10);
	}

	// Remover el primer elemento
	@Test
	public void testRemove1() {
		String elemento = lista1.remove(0);

		lista2.add("B");
		Assert.assertEquals(lista1, lista2);
		Assert.assertEquals(elemento, "A");
	}

	// Remover �ltimo elemento
	@Test
	public void testRemove2() {
		String elemento = lista1.remove(1);

		lista2.add("A");
		Assert.assertEquals(lista1, lista2);
		Assert.assertEquals(elemento, "B");
	}

	// Remover en una lista vac�a
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove3() {
		lista2.remove(0);
	}

	// Remover �ndice negativo
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove4() {
		lista1.remove(-1);
	}

	// Remover �ndice fuera de rango
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove5() {
		lista1.remove(2);
	}

	// Remover en el medio
	@Test
	public void testRemove6() {
		lista1.add("C");
		lista2.add("A");
		lista2.add("C");

		String elemento = lista1.remove(1);
		Assert.assertEquals(lista1, lista2);
		Assert.assertEquals(elemento, "B");
	}

}
