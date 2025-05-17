package ejemplos_TP06.Iterador.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SnapshotIterator {

	public static void main(String[] args) {

		List<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });
		
		Iterator<Integer> iterator = numbers.iterator();

		numbers.add(10);

		List<Integer> result = new LinkedList<>();

		 iterator.forEachRemaining(result::add);
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
