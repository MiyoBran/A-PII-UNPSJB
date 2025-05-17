package ejemplos_TP06.Iterador.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LazyIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(8);

		Iterator<Integer> iterator = numbers.iterator();

		numbers.add(10);

		List<Integer> result = new LinkedList<>();

		// iterator.forEachRemaining(result::add);
		while (iterator.hasNext())
			result.add(iterator.next());

		System.out.println(result);

		Iterator<Integer> iterator2 = numbers.iterator();

		List<Integer> result2 = new LinkedList<>();

		// iterator2.forEachRemaining(result2::add);
		while (iterator2.hasNext())
			result2.add(iterator2.next());

		System.out.println(result2);
	}

}
