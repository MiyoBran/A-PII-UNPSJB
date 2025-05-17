package test;

import net.datastructures.ArrayList;
import net.datastructures.List;
import net.datastructures.TreeMap;

public class Prueba<E> {

	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();
		List<String> s = new ArrayList<String>();

		l.add(0, "Ana");
		l.add(1, "Juan");
		l.add(2, "Ana");
		l.add(3, "Pedro");
		l.add(4, "Ana");
		
		s.add(0, "Juan");
		s.add(1, "Pedro");
		s.add(2, "Ana");
		s.add(3, "Ana");
		s.add(4, "Ana");
		
		if (similar(l,s))			
			System.out.println("Son similares");
		else
			System.out.println("No son similares");
		
		l.add(0, "Juan");
		s.add(0, "Analia");
		
		if (similar(l,s))			
			System.out.println("Son similares");
		else
			System.out.println("No son similares");
	}

	public static boolean similar(List<String> l, List<String> s) {
		if (l.size()!=s.size())
			return false;

		TreeMap<String, Integer> t = new TreeMap<String, Integer>();		
		for (String st : l)
			if (t.get(st) == null)
				t.put(st, 1);
			else
				t.put(st, t.get(st) + 1);

		TreeMap<String, Integer> q = new TreeMap<String, Integer>();
		for (String st : s)
			if (q.get(st) == null)
				q.put(st, 1);
			else
				q.put(st, q.get(st) + 1);
		
		if (t.size() != q.size()) 		
			return false;
		
		for (String k : t.keySet()) 			
			if (!t.get(k).equals(q.get(k))) 				
				return false;
		
		return true;
	}
	
	
}
