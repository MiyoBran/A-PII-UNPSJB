package iteradores;

// Java code to illustrate iterator()

import java.util.*;

public class IteratorString {

	public static void main(String[] args)
	{
		// Create and populate the list
		ArrayList<String> list = new ArrayList<>();

		list.add("Geeks");
		list.add("for");
		list.add("Geeks");
		list.add("is");
		list.add("a");
		list.add("CS");
		list.add("Students");
		list.add("Portal");

		// Displaying the list
		System.out.println("La lista es: \n"
						+ list);

		// Create an iterator for the list
		// using iterator() method
		Iterator<String> iter = list.iterator();

		// Displaying the values after iterating
		// through the list
		System.out.println("\nLos valores del Iterador"
						+ " de la lista es: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
