package test;

import net.datastructures.ArrayList;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.List;
import net.datastructures.Position;

public class Prueba<E> {

	public static void main(String[] args) {

		LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
		Position<String> p, q, r, s, u, v, w, x, y, z;

		p = t.addRoot("*");
		q = t.addLeft(p, "/");
		t.addRight(p, "8");

		r = t.addLeft(q, "*");
		s = t.addRight(q, "+");

		u = t.addLeft(r, "+");
		v = t.addRight(r, "-");

		t.addLeft(u, "5");
		t.addRight(u, "2");

		t.addLeft(v, "2");
		t.addRight(v, "1");

		w = t.addLeft(s, "+");
		x = t.addRight(s, "-");

		t.addLeft(w, "2");
		t.addRight(w, "9");

		y = t.addLeft(x, "-");
		t.addLeft(y, "7");
		t.addRight(y, "2");

		z= t.addRight(x, "1");

		List<String> l = new ArrayList<String>();
		l.add(0, "+");
		l.add(0, "-");
		l.add(0, "*");
		l.add(0, "/");
				
		if (validExpressionTree(t, l))
			System.out.println("Arbol de expresiones válido");
		else
			System.out.println("Arbol de expresiones no válido");
		
		
		t.addRight(z, "+");
		
		if (validExpressionTree(t, l))
			System.out.println("Arbol de expresiones válido");
		else
			System.out.println("Arbol de expresiones no válido");
		
	}

	public static boolean validExpressionTree(LinkedBinaryTree<String> t, List<String> op) {
		
		for (Position<String> p : t.positions()){
			if (t.numChildren(p)==1)
				return false;
			if (t.isExternal(p) && !isDouble(p.getElement()))
				return false;
			if (t.isInternal(p) && !op.contains(p.getElement()))
				return false;
		}
		return true;
	}

	
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);

		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	
}
