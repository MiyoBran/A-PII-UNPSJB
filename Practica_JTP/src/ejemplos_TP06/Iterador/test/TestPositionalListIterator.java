package ejemplos_TP06.Iterador.test;

import java.util.Iterator;

import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;
import net.datastructures.PositionalList;

public class TestPositionalListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PositionalList<String> l = new LinkedPositionalList<String>();
		Position<String> pos;

		pos = l.addFirst("Hola");
		l.addAfter(pos, "Mundo");

		System.out.println(l);

		String s;
		String r = "Hola";
		Iterator<String> i = l.iterator();
		while (i.hasNext()) {
			s = i.next();
			if (s.equals(r)) {
				i.remove();
				// i.remove();
			}
		}

		for (String t : l)
			System.out.println(t);
	}

}
