package ejemplos_TP02.conjunto;

public class TestConjunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conjunto<Integer> c1 = new Conjunto<Integer>(3);
		Conjunto<Integer> c2 = new Conjunto<Integer>(3);
		
		c1.insertarElemento(10);
		c1.insertarElemento(20);
		c1.insertarElemento(30);
		c2.insertarElemento(20);
		c2.insertarElemento(30);
		c2.insertarElemento(40);
		
		System.out.println(c1.union(c2));
		System.out.println(c1.interseccion(c2));
		System.out.println(c1.iguales(c2));

				
	}
	
	

}
