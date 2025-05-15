package ej2PilaEmpleados;

import ej1StackPerformance.ArrayStack;
import net.datastructures.Stack;

/**
 * tp5.EJ2 Utilizar una pila para cargar una nómina de empleados (ejercicio
 * 2.10). Calcular el sueldo para cada uno de ellos.
 * 
 * @author Miyo
 * @version 1.0
 * 
 */
public class PilaEmpleados {

	public static void main(String[] args) {
		// Creo la implementacion como pila
		// Es buena práctica programar contra la interfaz si es posible
		Stack<Empleado> pilaEmpleados = new ArrayStack<>(); // Asumiendo que ArrayStack implementa Stack

		// Cargo elementos de prueba
		pilaEmpleados.push(new EmpleadoAsalariado("Juan Pérez", "12345678", 2000));
		pilaEmpleados.push(new EmpleadoPorHora("Ana López", "87654321", 20, 160));
		pilaEmpleados.push(new EmpleadoPorComision("Carlos Gómez", "45678912", 5, 10000));
		pilaEmpleados.push(new EmpleadoBaseMasComision("María Díaz", "78912345", 8000, 4, 1500));

		// Imprimo los elementos y calculo salarios
		System.out.println("Lista de Empleados y Salarios (procesados desde la pila):");
		System.out.println("-------------------------------------------------------");

		while (!pilaEmpleados.isEmpty()) {
			Empleado e = pilaEmpleados.pop(); // Extrae el empleado

			// Obtenemos los datos usando los getters
			String nombreEmpleado = e.getNombre();
			double sueldoEmpleado = e.calcularSalario();

			// Imprimimos la información con el formato deseado
			// System.out.printf("Empleado: %s - Sueldo: $%.2f\n", nombreEmpleado,
			// sueldoEmpleado);
			System.out.println("Empleado: " + nombreEmpleado + " - Sueldo: $" + String.format("%.2f", sueldoEmpleado));
		}

		System.out.println("\nLa pila de empleados ahora está vacía: " + pilaEmpleados.isEmpty());
		System.out.println("Tamaño final de la pila: " + pilaEmpleados.size());
	}
}
