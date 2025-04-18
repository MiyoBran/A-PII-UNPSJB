package empresa;

/**
* Clase de prueba para la clase Empleado.
* 
* Se crean instancias de empleados, se imprimen sus datos y se calcula su sueldo.
* También se modifican atributos de un empleado y se muestra el resultado actualizado.
* 
* @author Catedra
* @author ArispeClaudio crapz0190@gmail.com
* @author BrandolinoCarlos miyenbran@gmail.com
* @author ColipanAxel maurocolipannn@gmail.com
* @author MarinoLizandro lizandro.e.marino@gmail.com
* @version 1.5
 */
public class PruebaEmpleado {
	public static void main(String[] args) {

		Empleado e1 = new Empleado(1234, "Juan", null, 40, 25);
		Empleado e2 = new Empleado(1235, "Ana", e1, 40, 15);
		Empleado e3 = new Empleado(4567, "Carlos", e2, 10, 100);
		Empleado e4 = new Empleado(6789, "Miyen", null, 100, 10);

		System.out.println(e1);
		System.out.println("Sueldo: " + e1.obtenerPago());
		System.out.println(e2);
		System.out.println("Sueldo: " + e2.obtenerPago());
		System.out.println(e3);
		System.out.println("Sueldo: " + e3.obtenerPago());
		System.out.println(e4);
		System.out.println("Sueldo: " + e4.obtenerPago());

		e4.setSupervisor(e3);
		e4.setNombre("Miyo");
		e4.setHorasTrabajadas(10);
		e4.setLegajo(1122);
		System.out.println(e4);
		System.out.println("Sueldo actualizado: " + e4.obtenerPago());
		System.out.println("Supervisor: " + e4.getSupervisor());

	}

}
