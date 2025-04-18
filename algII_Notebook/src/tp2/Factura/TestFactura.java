package tp2.Factura;

import tp2.Factura.Empleado;
import tp2.Factura.Factura;
import tp2.Factura.PorPagar;

/**
 * Clase de prueba para TP2 Ej11, para validar el funcionamiento de la interfaz
 * PorPagar, la clase Empleado y la clase Factura.
 * 
 * Crea instancias de empleados y facturas, las almacena en un arreglo de tipo
 * PorPagar y muestra los importes a pagar.
 * 
 * @author MiyenBrandolino
 * @version 1.0
 */
public class TestFactura {
	public static void main(String[] args) {
		// Crear empleados con datos variados
		Empleado emp1 = new Empleado(1010, "Carlos", null, 45, 30); // Sin supervisor
		Empleado emp2 = new Empleado(2020, "Lucia", emp1, 38, 28); // Supervisor: Carlos
		Empleado emp3 = new Empleado(3030, "Pedro", emp1, 40, 32); // Supervisor: Carlos
		Empleado emp4 = new Empleado(4040, "Mariana", emp2, 42, 27); // Supervisor: Lucia

		// Crear factura y agregar ítems
		Factura factura1 = new Factura("Insumos Industriales SA", 33333, "2021-07-15");
		factura1.agregarItem("Tornillos", 50, 0.25);
		factura1.agregarItem("Clavos", 100, 0.1);
		factura1.agregarItem("Martillos", 10, 15.0);
		factura1.agregarItem("Destornilladores", 20, 8.5);
		factura1.agregarItem("Taladros", 5, 75.0);

		// Crear un array de PorPagar y cargar empleados y factura
		PorPagar[] pagos = new PorPagar[5];
		pagos[0] = emp1;
		pagos[1] = emp2;
		pagos[2] = factura1;
		pagos[3] = emp3;
		pagos[4] = emp4;

		// Recorrer el array mostrando el importe a pagar
		System.out.println("Listado de Pagos:");
		for (PorPagar p : pagos) {
			System.out.println(p);
		}
	}
}
