package lista_array;

/**
 * Esta clase prueba el funcionamiento de la clase Lista con objetos Empleado.
 * Se prueban inserciones, eliminaciones y recuperación de elementos.
 * 
 * @author Catedra ALGII
 * @author ArispeClaudio (crapz0190@gmail.com)
 * @author BrandolinoCarlos (miyenbran@gmail.com)
 * @author ColipanAxel (maurocolipannn@gmail.com)
 * @author MarinoLizandro (lizandro.e.marino@gmail.com)
 * 
 * @version 1.1
 */
public class PruebaLista {

	public static void main(String[] args) {
		int tamanio = 3;
		Lista<Empleado> lista = new Lista<Empleado>(tamanio);

		Empleado e1 = new Empleado(100, "Juan");
		Empleado e2 = new Empleado(110, "Ana");
		Empleado e3 = new Empleado(120, "Pedro");
		Empleado e4 = new Empleado(120, "Maria");
		Empleado e5 = new Empleado(140, "Luis");

		// Prueba de add(E)
		try {
			System.out.println("Agregando elementos al final...");
			lista.add(e1);
			lista.add(e2);
			lista.add(e3);
			lista.add(e4);
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		// Prueba de remove(obj)
		try {
			System.out.println("Eliminamos a Pedro: ");
			lista.remove(e3);
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		// Prueba de add(pos, E)
		try {
			System.out.println("Insertamos a Maria entre Juan y Ana: ");
			lista.add(1, e4); // debería insertar a Maria entre Juan y Ana
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error al insertar en posición: " + e.getMessage());
		}

		// Remove(pos)
		try {
			System.out.println("Eliminamos a Maria, posicion entre Juan y Ana:");
			Empleado eliminado = lista.remove(1); // elimina a maria
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		// Prueba de remove(E)
		System.out.println("Eliminando objeto Luis (no está aún)...");
		Empleado eliminado2 = lista.remove(e5); // no existe en lista
		if (eliminado2 == null)
			System.out.println("Luis no estaba en la lista.");
		else
			System.out.println("Eliminado: " + eliminado2);
		// Agrego a Luis y lo elimino
		try {
			lista.add(e5);
			System.out.println("Agregando a Luis:");
			System.out.println(lista);
			System.out.println("Eliminando  Luis...");
			lista.remove(e5);
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		System.out.println(lista);
	}
}
