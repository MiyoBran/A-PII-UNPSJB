package test;

import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;
import net.datastructures.PositionalList;

public class TestPalindromo {

	public static void main(String[] argv) throws Exception {
		PositionalList<String> p;

		String s[] = { "N", "E", "U", "Q", "U", "E", "N" };
		p = cargarPL(s);
		System.out.println(p + " " + palindromo(p));

		String t[] = { "A", "L", "L", "A" };
		p = cargarPL(t);
		System.out.println(p + " " + palindromo(p));

		String u[] = { "H", "O", "L", "A" };
		p = cargarPL(u);
		System.out.println(p + " " + palindromo(p));

		String y[] = { "A" };
		p = cargarPL(y);
		System.out.println(p + " " + palindromo(p));
		
		String x[] = {  };
		p = cargarPL(x);
		System.out.println(p + " " + palindromo(p));
	}

	
	/**
	 * Retorna una lista posicional con los elementos pasados en un array de String
	 */
	public static PositionalList<String> cargarPL(String i[]) {
		PositionalList<String> p = new LinkedPositionalList<String>();

		for (String s : i)
			p.addLast(s);
		return p;
	}

	/**
	 * Verifica si los elementos de una lista posicional son palíndromos
	 */
	public static boolean palindromo(PositionalList<String> pl) {
		if (pl.isEmpty())
			return false;

		int i = 1;
		int j = pl.size();

		Position<String> walk1 = pl.first();
		Position<String> walk2 = pl.last();
		while (i < j) {
			if (!walk1.getElement().equals(walk2.getElement()))
				return false;
			walk1 = pl.after(walk1);
			walk2 = pl.before(walk2);
			i++;
			j--;
		}
		return true;
	}
}
