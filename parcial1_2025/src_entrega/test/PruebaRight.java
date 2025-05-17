package test; // O el paquete que estés usando para las pruebas

// Asegúrate de que el paquete coincida con donde está tu SinglyLinkedList
import net.datastructures.SinglyLinkedList;

/**
 * Prueba el método right(n) de la clase SinglyLinkedList.
 */
public class PruebaRight {

	public static void main(String[] args) {
		System.out.println("--- Pruebas para right(n) ---");

		// Lista base para las pruebas
		SinglyLinkedList<String> baseList = new SinglyLinkedList<>();
		baseList.addLast("A");
		baseList.addLast("B");
		baseList.addLast("C");
		baseList.addLast("D");
		System.out.println("Lista Base: " + baseList + "\n");

		// Casos Válidos
		probarCasoRight(baseList, 4); // right(4)
		probarCasoRight(baseList, 3); // right(3)
		probarCasoRight(baseList, 2); // right(2)
		probarCasoRight(baseList, 1); // right(1)
		probarCasoRight(baseList, 0); // right(0)

		// Casos Inválidos (lanzan excepción)
		probarCasoRight(baseList, 5); // right(5) - n > size
		probarCasoRight(baseList, -1); // right(-1) - n < 0

	}

	// Helper para probar un caso
	private static void probarCasoRight(SinglyLinkedList<String> list, int n) {
		System.out.print("right(" + n + "): ");
		try {
			SinglyLinkedList<String> result = list.right(n);
			System.out.println("=>: " + result );
		} catch (IndexOutOfBoundsException e) {
			// Capturamos la excepción esperada para casos inválidos
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// Capturamos cualquier otra excepción inesperada
			System.out.println("¡ERROR INESPERADO para n=" + n + "!: " + e);
			e.printStackTrace();
		}
	}
}