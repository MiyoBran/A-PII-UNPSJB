package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		LinkedBinaryTree<Integer> tree1 = new LinkedBinaryTree<Integer>();
		
		Position<Integer> p,q,r;
		
		p = tree1.addRoot(1);
		q = tree1.addLeft(p, 2);
		tree1.addLeft(q, 4);
		tree1.addRight(q, 5);
		r = tree1.addRight(p, 3);
		tree1.addLeft(r, 6);
		tree1.addRight(r, 7);
				
		LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<Integer>();
		
		p = tree2.addRoot(3);
		r = tree2.addRight(p, 7);
		//tree2.addRight(r, 7);
		
		//p = tree2.addRoot(3);
		//tree2.addLeft(p, 6);
		//tree2.addRight(p, 7);
		
		if (tree1.isSubtree(tree2))
			System.out.println("Es un subárbol");
		else
			System.out.println("No es un subárbol");
	}
}
