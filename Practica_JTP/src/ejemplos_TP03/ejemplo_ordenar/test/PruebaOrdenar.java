package ejemplos_TP03.ejemplo_ordenar.test;
import java.util.Arrays;

import ejemplos_TP03.ejemplo_ordenar.empleado.Empleado;
import ejemplos_TP03.ejemplo_ordenar.empleado.EmpleadoNombreComparator;

public class PruebaOrdenar {

	public static void main(String[] args) {

		Empleado empleados[] = new Empleado[5];

		empleados[0] = new Empleado(10, "Juan");
		empleados[1] = new Empleado(1234, "Ana");
		empleados[2] = new Empleado(123, "Pedro");
		empleados[3] = new Empleado(134, "Fernando");
		empleados[4] = new Empleado(14, "Pablo");

		for (Empleado e : empleados)
			System.out.println(e);

		System.out.println("\nOrdenar por legajo utilizando Comparable...");

		Arrays.sort(empleados);

		for (Empleado e : empleados)
			System.out.println(e);

		System.out.println("\nOrdenar por nombre utilizando Comparator...");

		Arrays.sort(empleados, new EmpleadoNombreComparator());

		for (Empleado e : empleados)
			System.out.println(e);

	}

}
