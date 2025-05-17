package test;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class TestAddAll {
	public static void main(String[] argv) throws Exception {

		List<String> lista1 = new ArrayList<String>();
		lista1.add(0, "A");
		lista1.add(1, "B");
		lista1.add(2, "C");
		lista1.add(3, "D");
		lista1.add(4, "E");
		System.out.println(lista1);
		
		List<String> lista2 = new ArrayList<String>();
		lista2.add(0, "1");
		lista2.add(1, "2");
		System.out.println(lista2);
		
		List<String> lista3 = new ArrayList<String>();
		
		// Válido		
		try {
			lista1.addAll(2, lista2);			
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}				
		System.out.println(lista1);
		
		// Error indice
		try {
			lista1.addAll(8, lista2);			
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}				
		System.out.println(lista1);
		
		// Error indice
		try {
			lista1.addAll(-1, lista2);			
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}				
		System.out.println(lista1);
		
		// Lista vacía
		try {
			lista1.addAll(6, lista3);			
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}				
		System.out.println(lista1);
	}
}
