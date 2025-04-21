package test;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class TestSubLista {
	public static void main(String[] argv) throws Exception {
		
		List<String> lista = new ArrayList<String>();
		lista.add(0, "A");
		lista.add(1, "B");
		lista.add(2, "C");
		lista.add(3, "D");
		lista.add(4, "E");
		System.out.println("Lista: " + lista);
		
		try {
			List<String> subLista = lista.subList(2, 4);
			System.out.println("Sublista: " + subLista);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown: " + e);
		}
		
		try {
			List<String> subLista = lista.subList(0, 5);
			System.out.println("Sublista: " + subLista);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown: " + e);
		}
		
		try {
			List<String> subLista = lista.subList(3, 3);
			System.out.println("Sublista: " + subLista);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown: " + e);
		}
		
		try {
			List<String> subLista = lista.subList(2, 6);
			System.out.println("Sublista: " + subLista);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown: " + e);
		}
		
		try {
			List<String> subLista = lista.subList(7, 2);
			System.out.println("Sublista: " + subLista);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown: " + e);
		}
		
		try {
			List<String> subLista = lista.subList(-1, 3);
			System.out.println("Sublista: " + subLista);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown: " + e);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown: " + e);
		}
	}
}
