package test;

import net.datastructures.ArrayList;
import net.datastructures.ChainHashMap;
import net.datastructures.Entry;
import net.datastructures.List;
import net.datastructures.Map;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] nombres = { "Juan", "Ana", "Ana", "Pedro", "Juan" };

		Integer cant;
		Map<String, Integer> m1 = new ChainHashMap<String, Integer>();
		for (String s : nombres) {
			cant = m1.get(s);
			if (cant == null)
				cant = 0;
			m1.put(s, 1 + cant);
		}
		for (Entry<String, Integer> e : m1.entrySet())
			System.out.println(e);

		List<String> l;
		Map<Integer,List<String>> m2 = new ChainHashMap<Integer,List<String>>();
		for (Entry<String, Integer> e : m1.entrySet()) {
			l = m2.get(e.getValue());
			if (l == null) {
				l = new ArrayList<String>();
				m2.put(e.getValue(),l);
			}
			l.add(l.size(), e.getKey());			
		}		
		for (Entry<Integer,List<String>> e : m2.entrySet())
			System.out.println(e);		
	}

}
