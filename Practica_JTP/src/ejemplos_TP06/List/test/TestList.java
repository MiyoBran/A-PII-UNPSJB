package ejemplos_TP06.List.test;

import java.util.List;
import ejemplos_TP06.List.org.apache.commons.collections4.list.TreeList;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//https://www.javatpoint.com/difference-between-arraylist-and-linkedlist
		//https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java
		//https://www.baeldung.com/java-arraylist-linkedlist
		
		//https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/list/TreeList.html
		
		//List<String> l = new ArrayList<String>();
		//List<String> l = new LinkedList<String>();
		List<String> l = new TreeList<String>();
		
		l.add(0, "Hola");
		l.add(1, "Mundo");
		
		System.out.println(l);
	}
}
