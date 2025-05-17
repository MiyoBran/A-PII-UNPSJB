package iteradores;

// Java code to illustrate iterator()

import java.util.*;

public class IterInteger {

	public static void main(String args[])
	{
		// Creating an empty ArrayList
		ArrayList<Integer> list
			= new ArrayList<Integer>();

		// Use add() method to add
		// elements into the list
		list.add(10);
		list.add(15);
		list.add(30);
		list.add(20);
		list.add(5);

		// Displaying the list
		System.out.println("La lista es: \n"
						+ list);

		// Create an iterator for the list
		// using iterator() method
		Iterator<Integer> iter = list.iterator();

		// Displaying the values
		// after iterating through the list
		System.out.println("\nLos valores del Iterador"
						+ " de la lista es: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
