package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import net.datastructures.Entry;
import net.datastructures.TreeMap;

public class TestArbolBinarioOrdenadoPalabra {

	public static void main(String[] args) throws FileNotFoundException {

		String[] palRes = { "for", "while", "abstract", "if", "case", "char" };

		TreeMap<String, Integer> palabra = new TreeMap<>();
		for (String s : palRes)
			palabra.put(s, 0);

		File file = new File("LinkedBinaryTree.java");
		Scanner doc = new Scanner(file).useDelimiter("[^a-zA-Z]+");
		String s;
		while (doc.hasNext()) {
			s = doc.next();
			Integer count = palabra.get(s);
			if (count != null)
				palabra.put(s, count + 1);
		}

		for (Entry<String, Integer> e : palabra.entrySet())
			System.out.println(e.getKey() + " " + e.getValue());

	}

}
