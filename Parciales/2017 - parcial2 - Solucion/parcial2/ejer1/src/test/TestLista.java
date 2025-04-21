package test;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class TestLista {

	public static void main(String[] args) {
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		List<String> lista3 = new ArrayList<String>();

		lista1.add(0, "Juan");
		lista1.add(1, "Mario");
		lista1.add(2, "Pedro");

		lista2.add(0, "Ana");
		lista2.add(1, "Pedro");
		lista2.add(2, "Susana");

		int l1 = 0, l2 = 0, l3 = 0, cmp;
		while (l1 < lista1.size() && l2 < lista2.size()) {
			cmp = lista1.get(l1).compareTo(lista2.get(l2));
			if (cmp < 0) {
				lista3.add(l3++, lista1.get(l1));
				l1++;
			} else if (cmp > 0) {
				lista3.add(l3++, lista2.get(l2));
				l2++;
			} else {
				lista3.add(l3++, lista1.get(l1));
				l1++;
				l2++;
			}
		}

		while (l1 < lista1.size()) {
			lista3.add(l3++, lista1.get(l1));
			l1++;
		}

		while (l2 < lista2.size()) {
			lista3.add(l3++, lista2.get(l2));
			l2++;
		}

		System.out.println(lista3);

	}
}
