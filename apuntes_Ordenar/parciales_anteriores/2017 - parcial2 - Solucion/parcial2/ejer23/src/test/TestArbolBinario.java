package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestArbolBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();

		Position<String> p, q, r, s, t, u;
		p = tree.addRoot("F");
		q = tree.addLeft(p, "B");
		tree.addLeft(q, "A");
		r = tree.addRight(q, "D");
		tree.addLeft(r, "C");
		u = tree.addRight(r, "E");
		s = tree.addRight(p, "G");
		t = tree.addRight(s, "I");
		tree.addLeft(t, "H");

		for (Position<String> pos : tree.inorder())
			System.out.println(pos.getElement());

		System.out.println("Nodos que no son hojas");
		for (Position<String> pos : tree.inorder())
			if (tree.isInternal(pos))
				System.out.println(pos.getElement());

		System.out.println("Nodos que tienen un solo hijo");
		for (Position<String> pos : tree.inorder())
			if (tree.numChildren(pos) == 1)
				System.out.println(pos.getElement());

		System.out.println("Ancestros del nodo E");
		for (Position<String> pos : tree.ancestor(u))
			System.out.println(pos.getElement());

	}

}
