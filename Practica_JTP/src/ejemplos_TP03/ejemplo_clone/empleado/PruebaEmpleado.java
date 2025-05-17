package ejemplos_TP03.ejemplo_clone.empleado;

public class PruebaEmpleado {

	public static void main(String[] args) throws CloneNotSupportedException {

		Empleado e1 = new Empleado(10, "Juan");
		Empleado e2 = e1.clone();

		if (e1 == e2)
			System.out.println("Direcciones iguales");
		else
			System.out.println("Direcciones distintas");

		if (e1.equals(e2))
			System.out.println("Empleados iguales");
		else
			System.out.println("Empleados distintos");
	}

}
