package test;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class TestLista {

	public static void main(String[] args) {
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		
		lista1.add(0, "A");
		lista1.add(1, "B");
		lista1.add(2, "C");
		lista1.add(3, "D");
		lista1.add(4, "A");
		lista1.add(5, "C");
		lista1.add(6, "C");
			
		lista2.add(0, "A");
		lista2.add(1, "C");
	
		
		lista1.removeAll(lista2);
		System.out.println(lista1);
		

	}
}
