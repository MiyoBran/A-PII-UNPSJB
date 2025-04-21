package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.List;
import net.datastructures.Position;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedBinaryTree<Integer> tree1 = new LinkedBinaryTree<Integer>();

		Position<Integer> p, q, r, s, t, u, v;

		p = tree1.addRoot(1);
		q = tree1.addLeft(p, 2);
		s = tree1.addLeft(q, 4);
		t = tree1.addRight(q, 5);
		r = tree1.addRight(p, 3);
		u = tree1.addLeft(r, 6);
		v = tree1.addRight(r, 7);

		List<Position<Integer>> list = tree1.cousins(s);

		for (Position<Integer> pos : list)
			System.out.println(pos.getElement());

	}
}
