package test;

import net.datastructures.LinkedPositionalList;
import net.datastructures.PositionalList;

public class TestReverse {

	public static void main(String[] argv) throws Exception {
		PositionalList<String> pl = new LinkedPositionalList<String>();
		System.out.println("Antes: "+pl);
		pl.reverse();
		System.out.println("Después: "+pl);		
				
		pl.addLast("Juan");
		pl.addLast("Ana");
		pl.addLast("Pedro");

		System.out.println("Antes: "+pl);
		pl.reverse();
		System.out.println("Después: "+pl);
		
		pl.addLast("Maria");
		System.out.println("Antes: "+pl);
		pl.reverse();
		System.out.println("Después: "+pl);
		
	}

}
