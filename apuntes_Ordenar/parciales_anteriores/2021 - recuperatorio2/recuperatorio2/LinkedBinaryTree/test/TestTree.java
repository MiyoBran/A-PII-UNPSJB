package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.List;
import net.datastructures.Position;

public class TestTree {

	public static void main(String[] args) {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();

		Position<String> p, q, r, s, t;

		p = tree.addRoot("/");		
		
		q = tree.addLeft(p, "*");
		r = tree.addRight(p, "+");

		s = tree.addLeft(q, "+");
		tree.addRight(q, "4");

		tree.addLeft(s, "3");
		tree.addRight(s, "1");

		t = tree.addLeft(r, "-");
		tree.addRight(r, "2");
		
		tree.addLeft(t, "9");
		tree.addRight(t, "5");
				
		for (Position<String> pos : tree.breadthfirst()) 
			System.out.print(pos.getElement());
		
		System.out.println();
		
		List<String> l = tree.ListBinaryTree();		
		for (String c: l)
			System.out.print(c+" ");
	}
}
