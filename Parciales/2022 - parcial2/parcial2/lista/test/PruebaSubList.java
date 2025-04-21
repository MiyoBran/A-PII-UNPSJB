package test;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class PruebaSubList {
	public static void main(String[] argv) throws Exception {

		List<Integer> lista1 = new ArrayList<Integer>();
		lista1.add(0, 1);
		lista1.add(1, 2);
		lista1.add(2, 4);
		lista1.add(3, 5);
		lista1.add(4, 3);
		lista1.add(5, 6);
		lista1.add(6, 7);

		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.add(0, 3);
		lista2.add(1, 6);
		lista2.add(2, 7);	

		System.out.println(lista1.isSubList(lista2));

	}
}
