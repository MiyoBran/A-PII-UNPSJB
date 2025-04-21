package lista;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList<Empleado> lista = new SinglyLinkedList<Empleado>();

		lista.addLast(new Empleado(10, "Juan"));
		lista.addLast(new Empleado(20, "Pedro"));
		lista.addLast(new Empleado(20, "Pedro"));
		//lista.addLast(new Empleado(30, "Pedro"));
		
		System.out.println(lista.lastIndexOf(new Empleado(20,null)));

		if (lista.containsDuplicate())
			System.out.println("contiene duplicados");
		else
			System.out.println("no contiene duplicados");
	}

}
