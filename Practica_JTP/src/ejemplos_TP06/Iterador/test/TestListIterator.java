package ejemplos_TP06.Iterador.test;


import java.util.Iterator;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class TestListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		List<String> l = new ArrayList<String>();
			
		l.add(0, "Hola");
		l.add(1, "Mundo");
		
		System.out.println(l);

		String s;
		String r = "Hola";
		Iterator<String> i = l.iterator();
		while (i.hasNext()) {
			s = i.next();
			if (s.equals(r)){
				i.remove();		
				//i.remove();
			}
		}

		for (String t : l)
			System.out.println(t);
	}

}
