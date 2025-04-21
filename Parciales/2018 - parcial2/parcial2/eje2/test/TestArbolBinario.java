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

		if (!tree.lleno())
			System.out.println("Arbol no lleno!");

		tree.addRight(p, "G");

		if (tree.lleno())
			System.out.println("Arbol lleno!");

		LinkedBinaryTree<String> newTree = new LinkedBinaryTree<String>();

		p = newTree.addRoot("A");
		p = newTree.addLeft(p, "B");
		p = newTree.addLeft(p, "C");
		p = newTree.addLeft(p, "D");
		p = newTree.addLeft(p, "E");
		p = newTree.addLeft(p, "F");

		if (!tree.semejante(newTree))
			System.out.println("Arbol no semejante!");

		p = newTree.addLeft(p, "G");

		if (tree.semejante(newTree))
			System.out.println("Arbol semejante!");

	}

}
