package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestArbolBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();

		Position<String> p, q, r, s, t;
		p = tree.addRoot("F");
		q = tree.addLeft(p, "B");
		tree.addLeft(q, "A");
		r = tree.addRight(q, "D");
		tree.addLeft(r, "C");		
		s = tree.addRight(p, "G");
		t = tree.addRight(s, "I");


		System.out.print("Nodos que son hojas: ");
		for (Position<String> pos : tree.listChildren())			
				System.out.print(pos.getElement()+" ");
		
		System.out.println();
		
		System.out.print("Lista con más ancestros: ");
		for (Position<String> pos : tree.listGreaterAncestor())			
			System.out.print(pos.getElement()+" ");

		tree.addRight(r, "E");
		tree.addLeft(t, "H");
		
		System.out.println();
		
		System.out.print("Nodos que son hojas: ");
		for (Position<String> pos : tree.listChildren())			
				System.out.print(pos.getElement()+" ");
		
		System.out.println();
		
		System.out.print("Lista con más ancestros: ");
		for (Position<String> pos : tree.listGreaterAncestor())			
			System.out.print(pos.getElement()+" ");

	}

}
