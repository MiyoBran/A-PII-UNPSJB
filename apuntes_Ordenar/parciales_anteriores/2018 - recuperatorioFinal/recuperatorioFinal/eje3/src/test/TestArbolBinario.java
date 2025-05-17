package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestArbolBinario {

	public static void main(String[] args) {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();

		Position<String> p,q,r,s,t;

		p=tree.addRoot("/");
		
		q=tree.addLeft(p, "*");
		
		r=tree.addLeft(q, "+");
		tree.addLeft(r, "5");
		tree.addRight(r, "2");
		
		r=tree.addRight(q, "-");
		tree.addLeft(r, "2");
		tree.addRight(r, "1");
		
		q=tree.addRight(p, "*");
		
		r=tree.addLeft(q, "+");
		
		s=tree.addLeft(r, "+");
		tree.addLeft(s, "2");
		tree.addRight(s, "9");
		
		s=tree.addRight(r, "-");
				
		t=tree.addLeft(s, "-");
		tree.addLeft(t, "7");
		tree.addRight(t, "2");
		
		s=tree.addRight(s, "1");
		
		tree.addRight(q, "8");
				
		if (tree.expression())
			System.out.println("Arbol expresión");
		
	}

}
