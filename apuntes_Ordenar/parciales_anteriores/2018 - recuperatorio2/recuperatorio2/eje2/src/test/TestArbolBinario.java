package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestArbolBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();

		Position<String> p, q, r;
		p = tree.addRoot("F");
		q = tree.addLeft(p, "B");
		tree.addLeft(q, "A");
		r = tree.addRight(q, "D");
		tree.addLeft(r, "C");
		tree.addRight(r, "E");

		if (!tree.duplicado())
			System.out.println("Arbol sin elementos duplicados!");

		tree.addRight(p, "A");

		if (tree.duplicado())
			System.out.println("Arbol con elementos duplicados!");

	}

}
