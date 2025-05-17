package ejemplos_TP03.ejemplo_clone.lista;

public class PruebaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList<Empleado> lista2 = new SinglyLinkedList<Empleado>();				
		
		lista2.addFirst(new Empleado(10, "Juan"));
		lista2.addFirst(new Empleado(20, "Pedro"));
		
		System.out.println(lista2);
									
		SinglyLinkedList<Empleado> lista3 = null;
		try {
			lista3 = lista2.clone();
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lista3);
		Empleado empl2 = lista2.first();
		Empleado empl3 = lista3.first();
		
		if (empl2==empl3)
			System.out.println("Direcciones iguales");
		else				
			System.out.println("Direcciones distintas");
		
		if (empl2.equals(empl3))
			System.out.println("Empleados iguales");
		else				
			System.out.println("Empleados distintos");
		
		
	}

}
