package test;

import net.datastructures.Entry;
import net.datastructures.TreeMap;


public class TestArbolBinarioOrdenado {
	
	public static void main(String[] args) {
				
		TreeMap<String, String> espIng = new TreeMap<>();
						
		espIng.put("hola", "hello");		
		espIng.put("mundo", "world");
		
		System.out.println(espIng.get("hola"));
				
		TreeMap<String, String> ingEsp = new TreeMap<>();
		
		for (Entry<String,String> s : espIng.entrySet() )
			ingEsp.put(s.getValue(), s.getKey());
		
		System.out.println(ingEsp.get("hello"));
		
	} 
}
