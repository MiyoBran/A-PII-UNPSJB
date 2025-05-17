package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String t[] = { "/", "*", "+", "+", "4", "-", "2", "3", "1", null, null, "9", "5", null, null };		
		//String t[] = {"/", null, "*"};
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>(t);
				
		// niveles
		System.out.print("\nNiveles: ");
		for (Position<String> pos : tree.breadthfirst())
			System.out.print(pos.getElement() + " ");

		// preorder RID
		System.out.print("\nPreorder: ");
		for (Position<String> pos : tree.preorder())
			System.out.print(pos.getElement() + " ");

		// inorder IRD
		System.out.print("\nInorder: ");
		for (Position<String> pos : tree.inorder())
			System.out.print(pos.getElement() + " ");

		// postorder IDR
		System.out.print("\nPostorder: ");
		for (Position<String> pos : tree.postorder())
			System.out.print(pos.getElement() + " ");

		
	}
}
